package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.User;


public interface UserService {
	
	User findById(Long id);
	
    User findByUsername(String username);
    
    List<User> findAll ();
    
    User save(User user);
    
    
}
