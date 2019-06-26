package com.example.postDo.entity;

import java.io.Serializable;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "acc_smtp_address", unique = false, nullable = true)
    private String smtp_address;
	
	@Column(name = "acc_smtp_port", unique = false, nullable = true)
    private Integer smtp_port;
	
	@Column(name = "acc_inserver_type", unique = false, nullable = true)
    private Short inserver_type;
	
	@Column(name = "acc_inserver_address", unique = false, nullable = true)
    private String inserver_address;
	
	@Column(name = "acc_inserver_port", unique = false, nullable = true)
    private Integer inserver_port;
    
	@Column(name = "acc_username", unique = false, nullable = false)
    private String username;
    
	@Column(name = "acc_password", unique = false, nullable = false)
    private String password;
	
	@Column(name = "acc_displayname", unique = false, nullable = false)
    private String displayname;
	
	@OneToOne()
    @JoinColumn(name = "acc_user", referencedColumnName = "user_id")
    private User user;
    
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Message> messages = new HashSet<Message>();

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Folder> folders = new HashSet<Folder>();
	
	

	public Account(Long id, String smtp_address, Integer smtp_port, Short inserver_type, String inserver_address,
			Integer inserver_port, String username, String password, String displayname, User user,
			Set<Message> messages, Set<Folder> folders) {
		super();
		this.id = id;
		this.smtp_address = smtp_address;
		this.smtp_port = smtp_port;
		this.inserver_type = inserver_type;
		this.inserver_address = inserver_address;
		this.inserver_port = inserver_port;
		this.username = username;
		this.password = password;
		this.displayname = displayname;
		this.user = user;
		this.messages = messages;
		this.folders = folders;
	}

	public Account() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSmtp_address() {
		return smtp_address;
	}

	public void setSmtp_address(String smtp_address) {
		this.smtp_address = smtp_address;
	}

	public Integer getSmtp_port() {
		return smtp_port;
	}

	public void setSmtp_port(Integer smtp_port) {
		this.smtp_port = smtp_port;
	}

	public Short getInserver_type() {
		return inserver_type;
	}

	public void setInserver_type(Short inserver_type) {
		this.inserver_type = inserver_type;
	}

	public String getInserver_address() {
		return inserver_address;
	}

	public void setInserver_address(String inserver_address) {
		this.inserver_address = inserver_address;
	}

	public Integer getInserver_port() {
		return inserver_port;
	}

	public void setInserver_port(Integer inserver_port) {
		this.inserver_port = inserver_port;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Folder> getFolders() {
		return folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}
	
	

	
    
}
