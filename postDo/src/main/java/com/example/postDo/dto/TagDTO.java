package com.example.postDo.dto;
import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.Tag;

public class TagDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private ArrayList<MessageDTO> messages;

    public TagDTO(Long id, String name, ArrayList<MessageDTO> messages) {
        this.id = id;
        this.name = name;
        this.messages = messages;
    }
    
    public TagDTO(Tag tag) {
    	this(tag.getId(), tag.getName(), new ArrayList<MessageDTO>());
    }

    public TagDTO() {
    	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}
