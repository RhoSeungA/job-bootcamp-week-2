package com.example.week2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.week2.model.UserRequest;

@Slf4j
@RestController
//@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {


    @GetMapping(path = "")
	//@ResponseBody
    public UserRequest user(){

        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .header("x-custom","hi")
            .body(user);

        return user;
    }
}
