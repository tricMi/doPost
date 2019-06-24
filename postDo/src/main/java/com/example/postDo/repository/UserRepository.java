package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername( String username );
}
