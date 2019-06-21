package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.postDo.dto.RuleDTO;
import com.example.postDo.entity.Rule;
import com.example.postDo.service.RuleServiceInterface;

@RestController
@RequestMapping(value = "/api/rules")
public class RuleController {
	
	@Autowired
	private RuleServiceInterface ruleService;
	
	@GetMapping
	public ResponseEntity<List<RuleDTO>> getRules() {
		
		List<Rule> rules = ruleService.findAll();
		
		List<RuleDTO> ruleDTO = new ArrayList<RuleDTO>();
		
		for(Rule r: rules) {
			ruleDTO.add(new RuleDTO(r));
		}
		
		return new ResponseEntity<List<RuleDTO>>(ruleDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RuleDTO> getRule(@PathVariable("id") Long id) {
		
		Rule rule = ruleService.findOne(id);
		
		if(rule == null){
			return new ResponseEntity<RuleDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<RuleDTO>(new RuleDTO(rule), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<RuleDTO> saveRule(@RequestBody RuleDTO ruleDTO) {
		
		Rule rule = new Rule();
		
		rule.setCondition(ruleDTO.getCondition());
		rule.setOperation(ruleDTO.getOperation());
		
		rule = ruleService.save(rule);
		return new ResponseEntity<RuleDTO>(new RuleDTO(rule), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<RuleDTO> updateRule(@RequestBody RuleDTO ruleDTO, @PathVariable("id") Long id) {
		
		Rule rule = ruleService.findOne(id); 
		
		if (rule == null) {
			return new ResponseEntity<RuleDTO>(HttpStatus.BAD_REQUEST);
		}
		
		rule.setCondition(ruleDTO.getCondition());
		rule.setOperation(ruleDTO.getOperation());
		
		rule = ruleService.save(rule);
		return new ResponseEntity<RuleDTO>(new RuleDTO(rule), HttpStatus.OK);		
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteRule(@PathVariable("id") Long id) {
		Rule rule = ruleService.findOne(id);
		if (rule != null){
			ruleService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
