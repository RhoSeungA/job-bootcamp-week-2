package com.example.week2.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.week2.model.BookRequest;
import com.example.week2.model.UserRequest;

@RestController
@RequestMapping("/api")
public class PostApiController {

	@PostMapping("/post")
	public String post(
		@RequestBody BookRequest bookRequest
	){
		System.out.println(bookRequest);
		return bookRequest.toString();
	}

	@PostMapping("/user")
	public UserRequest User(
		@RequestBody
		UserRequest userRequest
	){
		System.out.println(userRequest);
		return userRequest;
	}

}
