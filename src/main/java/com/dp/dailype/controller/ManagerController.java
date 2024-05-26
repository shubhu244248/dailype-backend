package com.dp.dailype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.dailype.model.Manager;
import com.dp.dailype.service.IManagerService;

@RestController
@RequestMapping("manager")
public class ManagerController {

	@Autowired
	private IManagerService managerService;

	@PostMapping("/save")
	public ResponseEntity<String> saveManager(@RequestBody Manager manager) {

		Long id = managerService.saveManager(manager);

		return new ResponseEntity<String>("Manager " + id + " saved.", HttpStatus.OK);
	}

	
}
