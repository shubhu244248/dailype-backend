package com.dp.dailype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.dailype.model.Manager;
import com.dp.dailype.model.User;
import com.dp.dailype.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

//	@Autowired
//	private IManagerService managerService;

	@Autowired
	private IUserService userService;

	@PostMapping("/create_user")
	public ResponseEntity<String> saveUser(@RequestBody User user, @Valid Manager manager) {

		userService.saveUser(user, manager);

		return new ResponseEntity<String>("User details saved.", HttpStatus.OK);
	}

}
