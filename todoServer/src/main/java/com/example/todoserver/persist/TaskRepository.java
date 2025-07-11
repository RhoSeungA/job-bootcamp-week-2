package com.example.todoserver.persist;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoserver.constants.TaskStatus;
import com.example.todoserver.persist.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
	List<TaskEntity> findAllByDueDate(Date dueDate);
	List<TaskEntity> findAllByStatus(TaskStatus status);
}
