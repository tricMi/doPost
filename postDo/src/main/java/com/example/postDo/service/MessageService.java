package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Message;
import com.example.postDo.repository.MessageRepository;

@Service
public class MessageService implements MessageServiceInterface{
	
	@Autowired
	MessageRepository messageRepository;

	@Override
	public Message findOne(Integer id) {
		return messageRepository.findById(id).orElse(null);
	}

	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@Override
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public void remove(Integer id) {
		messageRepository.deleteById(id);
		
	}

}
