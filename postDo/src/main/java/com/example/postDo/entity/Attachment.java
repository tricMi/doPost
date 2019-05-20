package com.example.postDo.entity;

import javax.persistence.CascadeType;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "attachments")
public class Attachment implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attachment_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "attachment_data", unique = false, nullable = false)
    private String data;
	
	@Column(name = "attachment_type", unique = false, nullable = false)
    private String type;
	
	@Column(name = "attachment_name", unique = false, nullable = false)
    private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_message", referencedColumnName = "message_id")
    private Message message;

    public Attachment(int id, String data, String type, String name, Message message) {
        this.id = id;
        this.data = data;
        this.type = type;
        this.name = name;
        this.message = message;
    }

    public Attachment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
