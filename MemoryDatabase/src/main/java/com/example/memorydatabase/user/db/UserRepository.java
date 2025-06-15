package com.example.memorydatabase.user.db;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.memorydatabase.db.SimpleDataRepository;
import com.example.memorydatabase.user.model.UserEntity;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

	public List<UserEntity> findAllScoreGreaterThen(int score){
		return this.findAll()
			.stream()
			.filter(
				it -> {
					return it.getScore() >= score;
				}
			).collect(Collectors.toList());
	}
}
