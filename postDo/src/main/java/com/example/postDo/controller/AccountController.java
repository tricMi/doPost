package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.service.AccountServiceInterface;

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.entity.Account;

@RestController
@RequestMapping(value = "api/accounts")
public class AccountController {
	
	
	@Autowired
	private AccountServiceInterface accountService;
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAccounts(){
		List<Account> accounts = accountService.findAll();
		
		List<AccountDTO> accountDTO = new ArrayList<AccountDTO>();
		
		for(Account a: accounts) {
			accountDTO.add(new AccountDTO(a));
		}
		
		return new ResponseEntity<List<AccountDTO>>(accountDTO, HttpStatus.OK);
	}
	

}

