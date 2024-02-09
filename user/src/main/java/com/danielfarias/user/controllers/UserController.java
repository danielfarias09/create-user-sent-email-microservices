package com.danielfarias.user.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danielfarias.user.dtos.UserRecordDto;
import com.danielfarias.user.models.UserModel;
import com.danielfarias.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> save(@RequestBody @Valid UserRecordDto userDto){
		var user = new UserModel();
		BeanUtils.copyProperties(userDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(user));
	}

}
