package com.example.todoserver.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.example.todoserver.constants.TaskStatus;
import com.example.todoserver.persist.TaskRepository;
import com.example.todoserver.persist.entity.TaskEntity;
import com.example.todoserver.model.Task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepository;

	public Task add(String title, String description, LocalDate dueDate){
		var e = TaskEntity.builder()
			.title(title)
			.description(description)
			.dueDate(Date.valueOf(dueDate))
			.status(TaskStatus.TODO)
			.build();
		var saved = this.taskRepository.save(e);
		return entityToObject(saved);
	}


	public List<Task> getAll() {
		return this.taskRepository.findAll().stream()
			.map(this::entityToObject)
			.collect(Collectors.toList());
	}

	public List<Task> getByDueDate(String dueDate) {
		return this.taskRepository.findAllByDueDate(Date.valueOf(dueDate)).stream()
			.map(this::entityToObject)
			.collect(Collectors.toList());
	}

	public List<Task> getByStatus(TaskStatus status) {
		return this.taskRepository.findAllByStatus(status).stream()
			.map(this::entityToObject)
			.collect(Collectors.toList());
	}

	public Task getOne(Long id) {
		var entity = this.getById(id);
		return this.entityToObject(entity);
	}

	private TaskEntity getById(Long id) {
		return this.taskRepository.findById(id)
			.orElseThrow(() ->
				new IllegalArgumentException(String.format("not exists task id [%d]", id)));
	}

	public Task update(Long id, String title, String description, LocalDate dueDate) {
		var exists = this.getById(id);

		exists.setTitle(Strings.isEmpty(title) ?
			exists.getTitle() : title);

		exists.setDescription(Strings.isEmpty(description) ?
			exists.getDescription() : description);

		exists.setDueDate(Objects.isNull(dueDate) ?
			exists.getDueDate() : Date.valueOf(dueDate));

		var updated = this.taskRepository.save(exists);
		return this.entityToObject(updated);
	}

	public Task updateStatus(Long id, TaskStatus status) {
		var entity = this.getById(id);

		entity.setStatus(status);

		var saved = this.taskRepository.save(entity);

		return this.entityToObject(saved);
	}

	public boolean delete(Long id) {
		try {
			this.taskRepository.deleteById(id);
		} catch (Exception e) {
			log.error("an error occurred while deleting [{}]", e.toString());
			return false;
		}
		return true;
	}

	private Task entityToObject(TaskEntity e){
		return Task.builder()
			.id(e.getId())
			.title(e.getTitle())
			.description(e.getDescription())
			.status(e.getStatus())
			.dueDate(e.getDueDate().toString())
			.createdAt(e.getCreatedAt().toLocalDateTime())
			.updatedAt(e.getUpdatedAt().toLocalDateTime())
			.build();
	}
}
