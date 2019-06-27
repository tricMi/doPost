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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "folders")
public class Folder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "folder_name", unique = false, nullable = false)
    private String name;
	
	@ManyToOne
	@JoinColumn(name="subfolder_id", referencedColumnName="folder_id", nullable=true)
	private Folder parent;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<Folder> folders = new HashSet<Folder>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
	private Set<Message> messages = new HashSet<Message>();
    
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
	private Set<Rule> rules = new HashSet<Rule>();
	
//	@OneToOne(cascade = CascadeType.ALL)
	@OneToOne()
    @JoinColumn(name = "folder_account", referencedColumnName = "account_id")
    private Account account;

	public Folder(Long id, String name, Folder folder, Set<Folder> folders, Set<Message> messages, Set<Rule> rules,
			Account account) {
		super();
		this.id = id;
		this.name = name;
		this.parent = folder;
		this.folders = folders;
		this.messages = messages;
		this.rules = rules;
		this.account = account;
	}

	public Folder() {
		super();
	}

	public void addFolder(Folder fol) {
		folders.add(fol);
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

	public Set<Folder> getFolders() {
		return folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}


	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

	
    
}
