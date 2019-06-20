package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Message;

public interface MessageServiceInterface {
	
	Message findOne(Long id);
	
	List<Message> findAll();
	
	Message save(Message message);
	
	void remove(Long id);
	

}
