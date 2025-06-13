package com.example.week2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.week2.model.UserRequest;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

	@PutMapping("/put")
	public void put(
		@RequestBody
		UserRequest userRequest
	){
		System.out.println("");
		log.info("Request : {}", userRequest);
	}
}
