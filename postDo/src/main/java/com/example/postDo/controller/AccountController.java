package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.example.postDo.service.AccountServiceInterface;

import dto.Account;

@RestController
@RequestMapping(value = "api/accounts")
public class AccountController {
	
	
	@Autowired
	private AccountServiceInterface accountService;
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccounts(){
		List<entity.Account> accounts = accountService.findAll();
		
		List<Account> accountDTO = new ArrayList<Account>();
		
		for(entity.Account a: accounts) {
			accountDTO.add(new Account(a));
		}
		
		return new ResponseEntity<List<Account>>(accountDTO, HttpStatus.OK);
	}
	

}
