package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(){
		List<User> users = userService.findAll();
		List<Contact> contacts = contactsService.findAll();
		List<Message> messages = messageService.findAll();
		List<Folder> folders = folderService.findAll();
		List<Account> accounts = accountsService.findAll();
		
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		
		for(User u: users) {
			
			UserDTO userDTO = new UserDTO(u);
			
			for(Account acc : accounts) {
				if(userDTO.getId() == acc.getUser().getId()) {
					AccountDTO accDTO = new AccountDTO(acc);
					for(Folder fol : folders) {
						if(fol.getAccount().getId() == accDTO.getId()) {
							accDTO.addFolder(new FolderDTO(fol));
						}
					}
					for(Message msg : messages) {
						if(msg.getAccount().getId() == accDTO.getId()) {
							accDTO.addMessage(new MessageDTO(msg));
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
			
			usersDTO.add(userDTO);
		}
		
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<UserDTO> doLogin(@RequestBody UserDTO tempUser) {
		
		List<Account> accounts = accountsService.findAll();
		List<Contact> contacts = contactsService.findAll();
		List<Message> messages = messageService.findAll();
		List<Folder> folders = folderService.findAll();
		
		boolean pass = false;
		
		User user = userService.findByUsername(tempUser.getUsername());
		
		UserDTO userDTO = new UserDTO(user);
		
		try {
			for(Account acc : accounts) {
				
				if(userDTO.getId() == acc.getUser().getId()) {
					
					AccountDTO accDTO = new AccountDTO(acc);
					
					for(Folder fol : folders) {
						if(fol.getAccount().getId() == accDTO.getId()) {
							accDTO.addFolder(new FolderDTO(fol));
						}
					}
					
					for(Message msg : messages) {
						if(msg.getAccount().getId() == accDTO.getId()) {
							accDTO.addMessage(new MessageDTO(msg));
						}
					}
					
					userDTO.addAccount(accDTO);
				}
			
			}
		}catch(Exception e) {
			e.printStackTrace();
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
	
	
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
		
		if(userDTO.getFirstname().equals("")) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}else if(userDTO.getLastname().equals("")) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}else if(userDTO.getUsername().equals("")) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}else if(userDTO.getPassword().equals("")) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		User u = new User();
		
		u.setUsername(userDTO.getUsername());
		u.setFirstname(userDTO.getFirstname());
		u.setLastname(userDTO.getLastname());
		u.setPassword(userDTO.getPassword());
		
		System.out.println(u.getFirstname());
		
		u = userService.save(u);
		return new ResponseEntity<UserDTO>(new UserDTO(u),HttpStatus.OK);
	}
	
}
