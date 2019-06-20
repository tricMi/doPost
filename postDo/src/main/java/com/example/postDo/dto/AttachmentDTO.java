package com.example.postDo.dto;

import java.io.Serializable;

public class AttachmentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String data;
    private String type;
    private String name;
    private MessageDTO message;

    public AttachmentDTO(Long id, String data, String type, String name, MessageDTO message) {
        this.id = id;
        this.data = data;
        this.type = type;
        this.name = name;
        this.message = message;
    }

    public AttachmentDTO() {
    	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }
}
