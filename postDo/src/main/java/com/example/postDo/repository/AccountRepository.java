package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.postDo.entity.Account;


import com.example.postDo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Account findOne(Integer id);

}
