package com.example.memorydatabase.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.memorydatabase.user.db.UserRepository;
import com.example.memorydatabase.user.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity save(UserEntity user){
		// save
		return userRepository.save(user);
	}

	public List<UserEntity> findAll(){
		return userRepository.findAll();
	}

	public void delete(Long id){
		userRepository.delete(id);
	}

	public Optional<UserEntity> findById(Long id){
		return userRepository.findById(id);
	}

	public List<UserEntity> filterScore(int score){
		return userRepository.findAllScoreGreaterThen(score);
	}
}