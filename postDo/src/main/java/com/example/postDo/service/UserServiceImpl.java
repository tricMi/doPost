package com.example.postDo.service;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.User;
import com.example.postDo.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername( String username ){
        User u = userRepository.findByUsername( username );
        return u;
    }

    @Override
    public User findById( Long id ){
        User u = userRepository.findById(id).orElse(null);
        return u;
    }

    @Override
    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        return result;
    }
    
    @Override 
    public User save(User user) {
    	return userRepository.save(user);
    }
}
