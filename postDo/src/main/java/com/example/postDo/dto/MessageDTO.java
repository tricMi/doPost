package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.Message;

public class MessageDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;	
    private ContactDTO from;
    private ArrayList<ContactDTO> to;
    private ArrayList<ContactDTO> cc;
    private ArrayList<ContactDTO> bcc;
    private String dateTime;
    private String subject;
    private String content;
    private ArrayList<TagDTO> tag;
    private ArrayList<AttachmentDTO> attachments;
    private FolderDTO folder;
    private AccountDTO account;


    public MessageDTO(Long id, ContactDTO from, ArrayList<ContactDTO> to, ArrayList<ContactDTO> cc, ArrayList<ContactDTO> bcc, String dateTime, String subject, String content, ArrayList<TagDTO> tag,
                   ArrayList<AttachmentDTO> attachments, FolderDTO folder, AccountDTO account) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.tag = tag;
        this.attachments = attachments;
        this.folder = folder;
        this.account = account;
    }

    public MessageDTO(Message message) {
    	this(message.getId(), new ContactDTO(message.getFrom()), new ArrayList<ContactDTO>(), new ArrayList<ContactDTO>(), new ArrayList<ContactDTO>()
    			,message.getDateTime(), message.getSubject(), message.getContent(), new ArrayList<TagDTO>(), new ArrayList<AttachmentDTO>(),
    			new FolderDTO(message.getFolder()), new AccountDTO(message.getAccount()));
    }

    public MessageDTO() {
    	super();
    }

    public ArrayList<TagDTO> getTag() {
        return tag;
    }

    public void setTag(ArrayList<TagDTO> tag) {
        this.tag = tag;
    }

    public ArrayList<AttachmentDTO> getAttachments() {
        return attachments;
    }

    public FolderDTO getFolder() {
        return folder;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAttachments(ArrayList<AttachmentDTO> attachments) {
        this.attachments = attachments;
    }

    public void setFolder(FolderDTO folder) {
        this.folder = folder;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactDTO getFrom() {
        return from;
    }

    public void setFrom(ContactDTO from) {
        this.from = from;
    }

    public ArrayList<ContactDTO> getTo() {
        return to;
    }

    public void setTo(ArrayList<ContactDTO> to) {
        this.to = to;
    }

    public ArrayList<ContactDTO> getCc() {
        return cc;
    }

    public void setCc(ArrayList<ContactDTO> cc) {
        this.cc = cc;
    }

    public ArrayList<ContactDTO> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<ContactDTO> bcc) {
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
}
