package com.example.postDo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "acc_smtp", unique = false, nullable = false)
    private String smtp;
	
	@Column(name = "acc_pop3_imap", unique = false, nullable = false)
    private String pop3_imap;
    
	@Column(name = "acc_username", unique = false, nullable = false)
    private String username;
    
	@Column(name = "acc_password", unique = false, nullable = false)
    private String password;
    
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Message> messages = new HashSet<Message>();

	public Account(int id, String smtp, String pop3_imap, String username, String password, Set<Message> messages) {
		super();
		this.id = id;
		this.smtp = smtp;
		this.pop3_imap = pop3_imap;
		this.username = username;
		this.password = password;
		this.messages = messages;
	}

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPop3_imap() {
		return pop3_imap;
	}

	public void setPop3_imap(String pop3_imap) {
		this.pop3_imap = pop3_imap;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

    
}
