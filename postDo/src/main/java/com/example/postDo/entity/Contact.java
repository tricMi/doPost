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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "contact_firstname", unique = false, nullable = false)
    private String firstName;
	
	@Column(name = "contact_lastname", unique = false, nullable = false)
    private String lastName;
	
	@Column(name = "contact_display", unique = false, nullable = false)
    private String display;
	
	@Column(name = "contact_email", unique = false, nullable = false)
    private String email;
	
	@Column(name = "contact_format", unique = false, nullable = false)
    private Format format;
	
//	@Column(name = "contact_photo", unique = false, nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_photo", referencedColumnName = "photo_id")
    private Photo photo;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "from")
	private Set<Message> from = new HashSet<Message>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "from")
	private Set<Message> to = new HashSet<Message>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "from")
	private Set<Message> cc = new HashSet<Message>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "from")
    private Set<Message> bcc = new HashSet<Message>();
	
	@ManyToOne
	@JoinColumn(name="message_id", referencedColumnName="message_id", nullable=true)
	private Message message;
	
	
//	@ManyToOne
//	  @JoinColumn(name="parent_cat_id", referencedColumnName="category_id", nullable=true)
//	  private Category parent;
//	  
//	  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="parent")
//	  private Set<Category> children = new HashSet<Category>();

	public Contact(int id, String firstName, String lastName, String display, String email, Format format, Photo photo,
			Set<Message> from, Set<Message> to, Set<Message> cc, Set<Message> bcc) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.display = display;
		this.email = email;
		this.format = format;
		this.photo = photo;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
	}

	public Contact() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Set<Message> getFrom() {
		return from;
	}

	public void setFrom(Set<Message> from) {
		this.from = from;
	}

	public Set<Message> getTo() {
		return to;
	}

	public void setTo(Set<Message> to) {
		this.to = to;
	}

	public Set<Message> getCc() {
		return cc;
	}

	public void setCc(Set<Message> cc) {
		this.cc = cc;
	}

	public Set<Message> getBcc() {
		return bcc;
	}

	public void setBcc(Set<Message> bcc) {
		this.bcc = bcc;
	}

	
//	 private Set<Product> products = new HashSet<Product>();

    
}
