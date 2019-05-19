package service;

import java.util.List;

import entity.Account;

public interface AccountServiceInterface {

	Account findOne(Integer id);
	
	List<Account> findAll();
	
	Account save(Account account);
	
	void remove(Integer id);
	
}
