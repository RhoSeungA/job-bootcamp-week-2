package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

	// MethodArgumentNotValidException

	@PostMapping("")
	public Api<UserRegisterRequest> register(

		@Valid
		@RequestBody
		Api<UserRegisterRequest> userRegisterRequest

	){
		log.info("init : {}", userRegisterRequest);

		var body = userRegisterRequest.getData();

		var response = Api.<UserRegisterRequest>builder()
			.resultCode(String.valueOf(HttpStatus.OK.value()))
			.resultMessage(HttpStatus.OK.getReasonPhrase())
			.data(body)
			.build();

		return response;
	}

}