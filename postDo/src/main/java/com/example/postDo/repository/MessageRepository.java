package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{


}
