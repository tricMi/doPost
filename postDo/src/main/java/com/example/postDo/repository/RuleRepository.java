package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Account;
import com.example.postDo.entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, Integer>{

//	Rule findOne(Integer id);

}
