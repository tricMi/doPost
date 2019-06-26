package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.FolderDTO;
import com.example.postDo.dto.MessageDTO;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Message;
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.MessageServiceInterface;


@RestController
@RequestMapping(value = "api/messages")
public class MessageController {
	
	@Autowired
	private MessageServiceInterface messageService;
	
	@Autowired
	private FolderServiceInterface folderService;
	
	@Autowired
	private AccountServiceInterface accountService;
	
	@Autowired
	private ContactServiceInterface contactService;
	
	@GetMapping
	public ResponseEntity<List<MessageDTO>> getMessages() {
		
		List<Message> messages = messageService.findAll();
		
		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
		
		for(Message m: messages) {
			messageDTO.add(new MessageDTO(m));
		}
		
		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MessageDTO> getMessage(@PathVariable("id") Long id) {
		
		Message message = messageService.findOne(id);
		
		if(message == null){
			return new ResponseEntity<MessageDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MessageDTO>(new MessageDTO(message), HttpStatus.OK);
	}
	
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<MessageDTO> updateMessage(@RequestBody MessageDTO messageDTO, @PathVariable("id") Long id) {
		
		
		
		Message message = messageService.findOne(id); 
		
		if (message == null) {
			return new ResponseEntity<MessageDTO>(HttpStatus.BAD_REQUEST);
		}
		
		message.setMessageRead(messageDTO.isMessageRead());
	
		message = messageService.save(message);
		
		return new ResponseEntity<MessageDTO>(new MessageDTO(message), HttpStatus.OK);	
	}

	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id) {
		Message message = messageService.findOne(id);
		if (message != null){
			messageService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value = "/sortByDateAsc")
	public ResponseEntity<List<MessageDTO>> getSortByDateAsc() {
		
		List<Message> messages = messageService.findAll();
		
		//Check if there are messages to sort
		if(messages == null) {
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
		}
		
		//Sort messages by date and time descending values
		messages.sort(Comparator.comparing(Message :: getDateTime));
		
		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
		
		for(Message m: messages) {
			messageDTO.add(new MessageDTO(m));
		}
		
		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/sortByDateDesc")
	public ResponseEntity<List<MessageDTO>> getSortByDateDesc() {
		
		List<Message> messages = messageService.findAll();
		
		//Check if there are messages to sort
		if(messages == null) {
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
		}
		
		//Sort messages by date and time ascending values
		messages.sort(Comparator.comparing(Message :: getDateTime).reversed());
		
		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
		
		for(Message m: messages) {
			messageDTO.add(new MessageDTO(m));
		}
		
		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);

	}
	
	@GetMapping(value = "/sortBySubjectAsc")
	public ResponseEntity<List<MessageDTO>> getSortBySubjectAsc() {
		
		List<Message> messages = messageService.findAll();
		
		//Check if there are messages to sort
		if(messages == null) {
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
		}
		
		//Sort messages by subject ascending values
		messages.sort(Comparator.comparing(Message :: getSubject));
		
		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
		
		for(Message m: messages) {
			messageDTO.add(new MessageDTO(m));
		}
		
		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);

	}
	
	
//	@GetMapping(value = "/sortBySenderDesc")
//	public ResponseEntity<List<MessageDTO>> getSortBySenderDesc() {
//		
//		List<Message> messages = messageService.findAll();
//		
//		//Check if there are messages to sort
//		if(messages == null) {
//			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
//		}
//		
//		//Sort messages by subject descending values
//		
//		messages.sort(Comparator.comparing(Contac ).reversed());
//		
//		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
//		
//		for(Message m: messages) {
//			messageDTO.add(new MessageDTO(m));
//		}
//		
//		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);
//
//	}
	
	@GetMapping(value = "/sortBySubjectDesc")
	public ResponseEntity<List<MessageDTO>> getSortBySubjectDesc() {
		
		List<Message> messages = messageService.findAll();
		
		//Check if there are messages to sort
		if(messages == null) {
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
		}
		
		//Sort messages by subject descending values
		messages.sort(Comparator.comparing(Message :: getSubject).reversed());
		
		List<MessageDTO> messageDTO = new ArrayList<MessageDTO>();
		
		for(Message m: messages) {
			messageDTO.add(new MessageDTO(m));
		}
		
		return new ResponseEntity<List<MessageDTO>>(messageDTO, HttpStatus.OK);

	}
	
//	@PutMapping(value = "/moveMessage/{id}", consumes="application/json")
//	private ResponseEntity<MessageDTO> moveMessage(@PathVariable("id") Long id){
//		
//		
//		Message message = messageService.findOne(id);
//		
//		
//		
//		
//	}
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO) {
		
		Message message = new Message();
		
		message.setFrom(contactService.findOne(messageDTO.getFrom().getId()));
		message.setAccount(accountService.findOne(messageDTO.getAccount().getId()));
		message.setSubject(messageDTO.getSubject());
		message.setDateTime(messageDTO.getDateTime());
		message.setContent(messageDTO.getContent());
		message.setFolder(folderService.findOne(messageDTO.getFolder().getId()));
	
		message = messageService.save(message);

		
		return new ResponseEntity<MessageDTO>(messageDTO, HttpStatus.CREATED);	
	}
	
//	@PostMapping(value = "/checkMail")
//	public ResponseEntity<?> checkMail(@RequestBody AccountDTO account) {
//		System.out.println("Called check");
//		JavaMail jm = new JavaMail();
//		jm.check(account);
//		return new ResponseEntity(HttpStatus.OK);
//
//	}
	
}
