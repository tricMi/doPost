package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Account;
import repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	AccountRepository accountServiceInterface;
	
	@Override
	public Account findOne(Integer id) {
		return accountServiceInterface.findOne(id);
	}

	@Override
	public List<Account> findAll() {
		return accountServiceInterface.findAll();
	}

	@Override
	public Account save(Account account) {
		return accountServiceInterface.save(account);
	}

	@Override
	public void remove(Integer id) {
		accountServiceInterface.deleteById(id);
		
	}
	

}
