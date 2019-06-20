package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Rule;
import com.example.postDo.repository.RuleRepository;

@Service
public class RuleService implements RuleServiceInterface {
	
	@Autowired
	RuleRepository ruleRepository;

	@Override
	public Rule findOne(Long id) {
		return ruleRepository.findById(id).orElse(null);
	}

	@Override
	public List<Rule> findAll() {
		return ruleRepository.findAll();
	}

	@Override
	public Rule save(Rule rule) {
		return ruleRepository.save(rule);
	}

	@Override
	public void remove(Long id) {
		ruleRepository.deleteById(id);
		
	}

}
