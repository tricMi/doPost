package com.example.postDo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Account;
import com.example.postDo.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account findOne(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void remove(Long id) {
		System.out.println("Removing in Account service...");
		accountRepository.deleteById(id);
	}
	
//	@Override
//	public void remove(Account acc) {
//		accountRepository.delete(acc);
//	}
	

}
