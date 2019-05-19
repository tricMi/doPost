package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Message;
import repository.MessageRepository;

@Service
public class MessageService implements MessageServiceInterface{
	
	@Autowired
	MessageRepository messageRepository;

	@Override
	public Message findOne(Integer id) {
		return messageRepository.findOne(id);
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
