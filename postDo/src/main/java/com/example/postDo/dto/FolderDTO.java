package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class FolderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private ArrayList<FolderDTO> folders;
    private ArrayList<MessageDTO> messages;
    private RuleDTO rule;

    public FolderDTO(Long id, String name, ArrayList<FolderDTO> folders, ArrayList<MessageDTO> messages, RuleDTO rule) {
        this.id = id;
        this.name = name;
        this.folders = folders;
        this.messages = messages;
        this.setRule(rule);
    }


    public FolderDTO(){
    	super();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDTO> messages) {
        this.messages = messages;
    }

    public ArrayList<FolderDTO> getFolders() {
        return folders;
    }


	public RuleDTO getRule() {
		return rule;
	}


	public void setRule(RuleDTO rule) {
		this.rule = rule;
	}
}
