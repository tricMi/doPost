package com.example.postDo.controller;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.MessageServiceInterface;
import com.example.postDo.service.UserService;
import com.example.postDo.dto.AccountDTO;
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Folder;
import com.example.postDo.entity.Message;
import com.example.postDo.entity.User;


@RestController
@RequestMapping(value = "api/accounts")
public class AccountController {
	
	
	@Autowired
	private AccountServiceInterface accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageServiceInterface messageService;
	
	@Autowired
	private FolderServiceInterface folderService;
	
	
	
	
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAccounts(){
		List<Account> accounts = accountService.findAll();
		
		
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		
		for(Account a: accounts) {
			
			AccountDTO accDTO = new AccountDTO(a);
			
			
			
			accountsDTO.add(accDTO);
		}
		
		return new ResponseEntity<List<AccountDTO>>(accountsDTO, HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<AccountDTO> getAccount(@PathVariable("id") Long id) {
		
		Account account = accountService.findOne(id);
		
		
		
		if(account == null){
			return new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
		
		Account account = new Account();
		
		account.setDisplayname(accountDTO.getPassword());
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		account.setInserver_address(accountDTO.getInserver_address());
		account.setInserver_port(accountDTO.getInserver_port());
		account.setInserver_type(accountDTO.getInserver_type());
		account.setSmtp_address(accountDTO.getSmtp_address());
		account.setSmtp_port(accountDTO.getSmtp_port());
		account.setFolders(createInitialFolders(account));
		account.setUser(userService.findById(accountDTO.getUser().getId()));
		
		account = accountService.save(account);
		return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.CREATED);	
	}
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<AccountDTO> editAccount(@RequestBody AccountDTO accountDTO, @PathVariable("id") Long id) {
		
		Account account = accountService.findOne(id); 
		
		if (account == null) {
			return new ResponseEntity<AccountDTO>(HttpStatus.BAD_REQUEST);
		}
		
		account.setDisplayname(accountDTO.getPassword());
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
//		account.setInserver_address(accountDTO.getInserver_address());
//		account.setInserver_port(accountDTO.getInserver_port());
//		account.setInserver_type(accountDTO.getInserver_type());
//		account.setSmtp_address(accountDTO.getSmtp_address());
//		account.setSmtp_port(accountDTO.getSmtp_port());
		
		
		account = accountService.save(account);
		return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
		Account acc = accountService.findOne(id);
		if (acc != null){
			System.out.println("acc nije null");
			List<User> users = userService.findAll();
			List<Message> messages = messageService.findAll();
			List<Folder> folders = folderService.findAll();
			
//			for(User user : users) {
//				for(Account account : user.getAccounts()) {
//					if(id == account.getId()) {
//						user.getAccounts().remove(account);
//					}
//				}
//			}
//			for(Message msg : messages) {
//				if(acc.getId() == msg.getAccount().getId()) {
//					messages.remove(msg);
//				}
//			}
			
//			for(Folder fol : folders) {
//				if(acc.getId() == fol.getAccount().getId()) {
//					messages.remove(fol);
//				}
//			}
			
			System.out.println("Id je: " + id);
			
			accountService.remove(id);
			System.out.println("removed");
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			System.out.println("Not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	private Set<Folder> createInitialFolders(Account account) {
		Set<Folder> folders = new HashSet<Folder>();
		
		Folder inbox = new Folder();
		
		inbox.setName("Inbox");
		inbox.setAccount(account);
		
		folders.add(inbox);
		
		Folder drafts = new Folder();
		
		drafts.setName("Drafts");
		drafts.setAccount(account);
		
		folders.add(drafts);
		
		Folder outbox = new Folder();
		
		outbox.setName("Sent");
		outbox.setAccount(account);
		
		folders.add(outbox);
	
		
		return folders;
	}
}

