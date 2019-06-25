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
import com.example.postDo.dto.FolderDTO;
import com.example.postDo.dto.MessageDTO;
import com.example.postDo.dto.UserDTO;
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Folder;
import com.example.postDo.entity.Message;
import com.example.postDo.entity.User;
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.MessageServiceInterface;
import com.example.postDo.service.UserService;

@RestController
@RequestMapping(value = "api/login")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountServiceInterface accountsService;
	
	@Autowired
	private ContactServiceInterface contactsService;
	
	@Autowired
	private MessageServiceInterface messageService;
	
	@Autowired
	private FolderServiceInterface folderService;
	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<UserDTO> doLogin(@RequestBody UserDTO tempUser) {
		
		List<Account> accounts = accountsService.findAll();
		List<Contact> contacts = contactsService.findAll();
		List<Message> messages = messageService.findAll();
		List<Folder> folders = folderService.findAll();
		
		boolean pass = false;
		
		User user = userService.findByUsername(tempUser.getUsername());
		
		UserDTO userDTO = new UserDTO(user);
		
		for(Account acc : accounts) {
			if(userDTO.getId() == acc.getUser().getId()) {
				
				AccountDTO accDTO = new AccountDTO(acc);
				
				for(Folder fol : folders) {
					if(fol.getAccount().getId() == accDTO.getId()) {
						accDTO.addFolder(new FolderDTO(fol));
					}
				}
				
				for(Message msg : messages) {
					System.out.println("Running messages...");
					if(msg.getAccount().getId() == accDTO.getId()) {
						accDTO.addMessage(new MessageDTO(msg));
						System.out.println("Added " + new MessageDTO(msg).getContent());
					}
				}
				
				userDTO.addAccount(accDTO);
			}
		}
		
		for(Contact con : contacts) {
			if(userDTO.getId() == con.getUser().getId()) {
				userDTO.addContact(new ContactDTO(con));
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
