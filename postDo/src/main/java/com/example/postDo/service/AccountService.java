package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Account;
import com.example.postDo.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	AccountRepository accountServiceInterface;
	
	@Override
	public Account findOne(Integer id) {
		return accountServiceInterface.findById(id).orElse(null);
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
