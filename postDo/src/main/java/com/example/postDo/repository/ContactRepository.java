package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.postDo.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{


}
