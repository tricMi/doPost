package com.example.postDo.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rules")
public class Rule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rule_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "rule_condition", unique = false, nullable = false)
    private Condition condition;
	
	@Column(name = "rule_operation", unique = false, nullable = false)
    private Operation operation;

    public Rule(Long id, Condition condition, Operation operation) {
        this.id = id;
        this.condition = condition;
        this.operation = operation;
    }

    public Rule(){

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
