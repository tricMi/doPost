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
    private FolderDTO folder;

    public RuleDTO(Long id, Condition condition, Operation operation, FolderDTO folder) {
		super();
		this.id = id;
		this.condition = condition;
		this.operation = operation;
		this.folder = folder;
	}

	public RuleDTO(Rule rule) {
    	this(rule.getId(), rule.getCondition(), rule.getOperation(), new FolderDTO(rule.getFolder()));
    }
    
    public RuleDTO(){
    	super();
    }
    
    

    public FolderDTO getFolder() {
		return folder;
	}

	public void setFolder(FolderDTO folder) {
		this.folder = folder;
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
