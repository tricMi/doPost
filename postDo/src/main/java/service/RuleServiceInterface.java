package service;

import java.util.List;

import entity.Rule;

public interface RuleServiceInterface {

	Rule findOne(Integer id);
	
	List<Rule> findAll();
	
	Rule save(Rule rule);
	
	void remove(Integer id);
}
