package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.MessageDTO;
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

}
