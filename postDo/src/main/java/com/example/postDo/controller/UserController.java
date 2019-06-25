package com.example.postDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.UserDTO;
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.User;
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.UserService;

@RestController
@RequestMapping(value = "api/login")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountServiceInterface accountsService;
	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<UserDTO> doLogin(@RequestBody UserDTO tempUser) {
		
		System.out.println("called");
		
		List<Account> accounts = accountsService.findAll();
		
		boolean pass = false;
		
		User user = userService.findByUsername(tempUser.getUsername());
		
		UserDTO userDTO = new UserDTO(user);
		
		for(Account acc : accounts) {
			if(userDTO.getId() == acc.getUser().getId()) {
				System.out.println("added");
				userDTO.addAccount(new AccountDTO(acc));
				for(AccountDTO accDTO : userDTO.getAccounts()) {
					System.out.println(accDTO.getDisplayname());
				}
			}
		}
		
		if(user.getPassword().equals(tempUser.getPassword())) {
			pass = true;
		}
		
		if(pass == true && user != null) {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		
		
			
	}
	
}
