package com.example.postDo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.FolderDTO;
import com.example.postDo.dto.MessageDTO;
import com.example.postDo.dto.TagDTO;
import com.example.postDo.dto.UserDTO;
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Folder;
import com.example.postDo.entity.Message;
import com.example.postDo.entity.Tag;
import com.example.postDo.entity.User;
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.MessageServiceInterface;
import com.example.postDo.service.TagServiceInterface;
import com.example.postDo.service.UserService;



@RestController
@RequestMapping(value = "api/login")
public class UserController {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	
	@Autowired
	private TagServiceInterface tagService;
	
//	public List<Account> getAccounts(){
//		List<Account> allAccounts = accountsService.findAll();
//		return allAccounts;
//	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(){
		
		logger.info("Request for all users, their associated contacts and accounts, account folers and messages");
		
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
							
							for(Tag tag: tagService.findAll()) {
								if(tag.getMessage() != null) {
									if(tag.getMessage().getId() == msg.getId()) {
										System.out.println("Tag: " + tag.getName() + " was added");
										msg.addTag(tag);
									}
								}
								
							}
							System.out.println("Number of tags: " + msg.getTags().size());
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
	
	public static String toUTC(Date date) {
		  TimeZone tz = TimeZone.getTimeZone("UTC");
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		  df.setTimeZone(tz);
		  return df.format(date);
		}

	public static Date fromUTC(String dateStr) {
		  TimeZone tz = TimeZone.getTimeZone("UTC");
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		  df.setTimeZone(tz);
		  
		  try {
		    return df.parse(dateStr);
		  } catch (ParseException e) {
		    e.printStackTrace();
		  }
		  
		  return null;
		}

	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<UserDTO> doLogin(@RequestBody UserDTO tempUser) {
		
		logger.info("Login method for users");
		
		
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
							
							for(Folder subf : folders) {
								if(subf.getParent().getId() == fol.getId()) {
									fol.addFolder(subf);
								}
							}
							
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
			if(con.getUser() != null) {
				if(userDTO.getId() == con.getUser().getId()) {
					userDTO.addContact(new ContactDTO(con));
				}
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
		
		logger.info("User Registration method");
		
		//check if fields aren't empty 
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
	
	@PutMapping(value="/changePassword/{id}", consumes="application/json")
	public ResponseEntity<UserDTO> changePassword(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
		
		logger.info("Method for changing password");
		
		User user = userService.findById(id); 
		
		if (user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		user.setPassword(userDTO.getPassword());
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);	
	
	}
	
	@PutMapping(value="/changePersonalData/{id}", consumes="application/json")
	public ResponseEntity<UserDTO> changePersonalData(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {
		
		logger.info("Method for changing personal data");
		
		User user = userService.findById(id); 
		
		if (user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setUsername(userDTO.getUsername());
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);	
	
	}
	
}
