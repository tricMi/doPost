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
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
	private Set<Folder> folders = new HashSet<Folder>();
	
	@ManyToOne
	@JoinColumn(name="subfolder_id", referencedColumnName="folder_id", nullable=true)
	private Folder folder;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
	private Set<Message> messages = new HashSet<Message>();
    
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_rule", referencedColumnName = "rule_id")
    private Rule rule;

	public Folder(Long id, String name, Set<Folder> folders, Set<Message> messages, Rule rule) {
		super();
		this.id = id;
		this.name = name;
		this.folders = folders;
		this.messages = messages;
		this.rule = rule;
	}

	public Folder() {
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

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

    
}
