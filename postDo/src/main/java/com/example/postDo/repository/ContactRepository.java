package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

//	Contact findOne(Integer id);

}
