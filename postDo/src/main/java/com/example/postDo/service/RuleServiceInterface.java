package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Rule;

public interface RuleServiceInterface {

	Rule findOne(Long id);
	
	List<Rule> findAll();
	
	Rule save(Rule rule);
	
	void remove(Long id);
}
