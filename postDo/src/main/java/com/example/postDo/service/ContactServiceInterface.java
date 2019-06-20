package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Contact;

public interface ContactServiceInterface {
	
	Contact findOne(Long id);
	
	List<Contact> findAll();
	
	Contact save(Contact contact);
	
	void remove(Long id);
	
}
