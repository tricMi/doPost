package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Contact;

public interface ContactServiceInterface {
	
	Contact findOne(Integer id);
	
	List<Contact> findAll();
	
	Contact save(Contact contact);
	
	void remove(Integer id);
	
}
