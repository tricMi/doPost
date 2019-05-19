package entity;

import java.io.Serializable;
import java.util.ArrayList;

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

@XmlRootElement
@Entity
@Table(name = "message")
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "message_from", unique = false, nullable = false)
    private Contact from;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private ArrayList<Contact> to;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private ArrayList<Contact> cc;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private ArrayList<Contact> bcc;
    
    @Column(name = "message_dateTime", unique = false, nullable = false)
    private String dateTime;
    
    @Column(name = "message_subject", unique = false, nullable = false)
    private String subject;
    
    @Column(name = "message_content", unique = false, nullable = false)
    private String content;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private ArrayList<Tag> tag;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "message")
    private ArrayList<Attachment> attachments;
    
    @Column(name = "message_folder", unique = false, nullable = false)
    private Folder folder;
    
    @Column(name = "message_account", unique = false, nullable = false)
    private Account account;

    public Message(int id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public Message(int id, Contact from, ArrayList<Contact> to, ArrayList<Contact> cc, ArrayList<Contact> bcc, String dateTime, String subject, String content, ArrayList<Tag> tag,
                   ArrayList<Attachment> attachments, Folder folder, Account account) {
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

    public Message(Contact from, String subject) {
        this.from = from;
        this.subject = subject;

    }


    public Message() {
    }

    public ArrayList<Tag> getTag() {
        return tag;
    }

    public void setTag(ArrayList<Tag> tag) {
        this.tag = tag;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public Folder getFolder() {
        return folder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public ArrayList<Contact> getTo() {
        return to;
    }

    public void setTo(ArrayList<Contact> to) {
        this.to = to;
    }

    public ArrayList<Contact> getCc() {
        return cc;
    }

    public void setCc(ArrayList<Contact> cc) {
        this.cc = cc;
    }

    public ArrayList<Contact> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<Contact> bcc) {
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
