package com.example.postDo.dto;

import java.io.Serializable;

import com.example.postDo.entity.Condition;
import com.example.postDo.entity.Operation;
import com.example.postDo.entity.Rule;



public class RuleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private Condition condition;
    private Operation operation;

    public RuleDTO(Long id, Condition condition, Operation operation) {
        this.id = id;
        this.condition = condition;
        this.operation = operation;
    }

    public RuleDTO(Rule rule) {
    	this(rule.getId(), rule.getCondition(), rule.getOperation());
    }
    
    public RuleDTO(){
    	super();
    }

    public Long getId() {
        return id;
    }

    public Condition getCondition() {
        return condition;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
