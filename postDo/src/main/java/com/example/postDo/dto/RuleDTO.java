package com.example.postDo.dto;

import java.io.Serializable;

public class RuleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private ConditionDTO condition;
    private OperationDTO operation;

    public RuleDTO(Long id, ConditionDTO condition, OperationDTO operation) {
        this.id = id;
        this.condition = condition;
        this.operation = operation;
    }

    public RuleDTO(){
    	super();
    }

    public Long getId() {
        return id;
    }

    public ConditionDTO getCondition() {
        return condition;
    }

    public OperationDTO getOperation() {
        return operation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCondition(ConditionDTO condition) {
        this.condition = condition;
    }

    public void setOperation(OperationDTO operation) {
        this.operation = operation;
    }
}
