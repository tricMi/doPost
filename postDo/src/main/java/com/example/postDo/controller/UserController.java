package com.example.postDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.UserDTO;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.User;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.UserService;

@RestController
@RequestMapping(value = "api/login")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<UserDTO> doLogin(@RequestBody UserDTO tempUser) {
		
		System.out.println(tempUser.getUsername());
		
		boolean pass = false;
		
		User user = userService.findByUsername(tempUser.getUsername());
		
		if(user.getPassword().equals(tempUser.getPassword())) {
			pass = true;
		}
		
		if(pass == true && user != null) {
			return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		
		
			
	}
	
}
