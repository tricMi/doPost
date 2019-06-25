package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Account;

public interface AccountServiceInterface {

	Account findOne(Long id);
	
	List<Account> findAll();
	
	Account save(Account account);
	
	void remove(Long id);
	
//	void remove(Account acc);
	
}
