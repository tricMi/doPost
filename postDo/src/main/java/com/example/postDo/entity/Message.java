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
@Table(name = "messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "message_content", unique = false, nullable = false)
	private String content;
	
	@Column(name = "message_date_time", unique = false, nullable = false)
    private String dateTime;
	
	@Column(name = "message_subject", unique = false, nullable = false)
    private String subject;
	
	@Column(name = "message_read", unique = false, nullable = false)
    private boolean messageRead;
	
//	@OneToOne(cascade = CascadeType.ALL)
	@OneToOne()
	@JoinColumn(name = "message_account", referencedColumnName = "account_id")
	private Account account;
	
//	@OneToOne(cascade = CascadeType.ALL)
	@OneToOne()
	@JoinColumn(name = "message_folder", referencedColumnName = "folder_id")
	private Folder folder;
	  
	
	@ManyToOne
	@JoinColumn(name="contact_id", referencedColumnName="contact_id", nullable=true)
	private Contact from;
	
//	@ManyToOne
//	@JoinColumn(name="tag_id", referencedColumnName="tag_id", nullable=true)
//	private Tag tag;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
	private Set<Contact> to = new HashSet<Contact>();
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private Set<Contact> cc = new HashSet<Contact>();
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private Set<Contact> bcc = new HashSet<Contact>();
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private Set<Tag> tags = new HashSet<Tag>();
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private Set<Attachment> attachments = new HashSet<Attachment>();
    

	public Message(Long id, String content, String dateTime, String subject, boolean messageRead, Account account,
			Folder folder, Contact from, Set<Contact> to, Set<Contact> cc, Set<Contact> bcc, Set<Tag> tags,
			Set<Attachment> attachments) {
		super();
		this.id = id;
		this.content = content;
		this.dateTime = dateTime;
		this.subject = subject;
		this.messageRead = messageRead;
		this.account = account;
		this.folder = folder;
		this.from = from;
		
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.tags = tags;
		this.attachments = attachments;
	}

	public Message() {
		super();
	}

	public void addTo(Contact con) {
		to.add(con);
	}
	public void addCc(Contact con) {
		cc.add(con);
	}
	public void addBcc(Contact con) {
		bcc.add(con);
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contact getFrom() {
		return from;
	}

	public void setFrom(Contact from) {
		this.from = from;
	}

	public Set<Contact> getTo() {
		return to;
	}

	public void setTo(Set<Contact> to) {
		this.to = to;
	}

	public Set<Contact> getCc() {
		return cc;
	}

	public void setCc(Set<Contact> cc) {
		this.cc = cc;
	}

	public Set<Contact> getBcc() {
		return bcc;
	}

	public void setBcc(Set<Contact> bcc) {
		this.bcc = bcc;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isMessageRead() {
		return messageRead;
	}

	public void setMessageRead(boolean messageRead) {
		this.messageRead = messageRead;
	}

//	public Tag getTag() {
//		return tag;
//	}
//
//	public void setTag(Tag tag) {
//		this.tag = tag;
//	}

	
    
}
