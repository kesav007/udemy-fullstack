package com.codedecode.userInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.userInfo.dto.UserDTO;
import com.codedecode.userInfo.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		userDTO = userService.addUser(userDTO);
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}

	@GetMapping("/fetchUserById/{userid}")
	public ResponseEntity<UserDTO> getUserDetailsById(@PathVariable Integer userid){
		return userService.getUserDetailsById(userid);
	}

}
