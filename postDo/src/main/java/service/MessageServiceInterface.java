package service;

import java.util.List;

import entity.Message;

public interface MessageServiceInterface {
	
	Message findOne(Integer id);
	
	List<Message> findAll();
	
	Message save(Message message);
	
	void remove(Integer id);
	

}
