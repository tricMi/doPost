package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Rule;
import repository.RuleRepository;

@Service
public class RuleService implements RuleServiceInterface {
	
	@Autowired
	RuleRepository ruleRepository;

	@Override
	public Rule findOne(Integer id) {
		return ruleRepository.findOne(id);
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
	public void remove(Integer id) {
		ruleRepository.deleteById(id);
		
	}

}
