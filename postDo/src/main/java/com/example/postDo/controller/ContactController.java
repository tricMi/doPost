package com.example.postDo.controller;

import java.util.ArrayList;

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


import com.example.postDo.dto.ContactDTO;
import com.example.postDo.entity.Contact;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.PhotoServiceInterface;


@RestController
@RequestMapping(value = "api/contacts")
public class ContactController {
	
	@Autowired
	private ContactServiceInterface contactsService;
	
	@Autowired
	private PhotoServiceInterface photoService;
	
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> getContacts() {
		
		List<Contact> contacts = contactsService.findAll();
		
		List<ContactDTO> contactDTO = new ArrayList<ContactDTO>();
		
		for(Contact c: contacts) {
			contactDTO.add(new ContactDTO(c));
		}
		
		return new ResponseEntity<List<ContactDTO>>(contactDTO, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContactDTO> getContact(@PathVariable("id") Long id) {
		
		Contact contact = contactsService.findOne(id);
		
		if(contact == null){
			return new ResponseEntity<ContactDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ContactDTO>(new ContactDTO(contact), HttpStatus.OK);
	}
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<ContactDTO> saveContact(@RequestBody ContactDTO contactDTO) {
		
		Contact contact = new Contact();
		
		contact.setFirstName(contactDTO.getFirstName());
		contact.setLastName(contact.getLastName());
		contact.setEmail(contact.getEmail());
		contact.setDisplay(contact.getDisplay());
		contact.setPhoto(photoService.findOne(contact.getId()));
	
		contact = contactsService.save(contact);
		return new ResponseEntity<ContactDTO>(new ContactDTO(contact), HttpStatus.CREATED);	
	}
	
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO contactDTO, @PathVariable("id") Long id) {
		
		Contact contact = contactsService.findOne(id); 
		
		if (contact == null) {
			return new ResponseEntity<ContactDTO>(HttpStatus.BAD_REQUEST);
		}
		
		contact.setFirstName(contactDTO.getFirstName());
		contact.setLastName(contact.getLastName());
		contact.setEmail(contact.getEmail());
		contact.setDisplay(contact.getDisplay());
		contact.setPhoto(photoService.findOne(contact.getId()));
	
		contact = contactsService.save(contact);
		
		return new ResponseEntity<ContactDTO>(new ContactDTO(contact), HttpStatus.OK);	
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {
		Contact contact = contactsService.findOne(id);
		if (contact != null){
			contactsService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
