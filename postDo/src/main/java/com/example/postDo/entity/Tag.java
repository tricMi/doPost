package com.example.postDo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "tag_name", unique = false, nullable = false)
    private String name;
	
//	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "tag")
//	private Set<Message> messages = new HashSet<Message>();
	
	@ManyToOne
	@JoinColumn(name="tag_message", referencedColumnName="message_id", nullable=true)
	private Message message;

//	public Tag(Long id, String name, Set<Message> messages) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.messages = messages;
//	}
	
	

	public Tag() {
		super();
	}

	public Tag(Long id, String name, Message message) {
	super();
	this.id = id;
	this.name = name;
	this.message = message;
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	

//	public Set<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(Set<Message> messages) {
//		this.messages = messages;
//	}

    
}
