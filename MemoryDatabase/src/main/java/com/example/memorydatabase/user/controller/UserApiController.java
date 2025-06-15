package com.example.memorydatabase.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.memorydatabase.user.model.UserEntity;
import com.example.memorydatabase.user.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PutMapping("")
	public UserEntity create(
		@RequestBody UserEntity userEntity
	){
		return userService.save(userEntity);
	}

	@GetMapping("/all")
	public List<UserEntity> findAll(){
		return userService.findAll();
	}

	// delete
	@DeleteMapping("/id/{id}")
	public void delete(
		@PathVariable Long id
	){
		userService.delete(id);
	}


	// findby id -> path variable
	@GetMapping("/id/{id}")
	public UserEntity findOne(
		@PathVariable Long id
	){
		var response = userService.findById(id);
		return response.get();
	}

	@GetMapping("/score")
	public List<UserEntity> filterScore(
		@RequestParam int score
	){
		return userService.filterScore(score);
	}
}