package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD:postDo/src/main/java/com/example/postDo/repository/AccountRepository.java
import com.example.postDo.entity.Account;
=======

import entity.Account;
>>>>>>> 5ea0f2674b01a9cace8f495680391368222dc6d0:postDo/src/main/java/repository/AccountRepository.java

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Account findOne(Integer id);

}
