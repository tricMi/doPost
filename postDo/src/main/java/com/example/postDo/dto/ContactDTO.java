package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Format;


public class ContactDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String firstName;
    private String lastName;
    private String display;
    private String email;
    private Format format;
    private PhotoDTO photo;
    private UserDTO user;
    private ArrayList<MessageDTO> from;
    private ArrayList<MessageDTO> to;
    private ArrayList<MessageDTO> cc;
    private ArrayList<MessageDTO> bcc;
    

    public ContactDTO(Long id, String firstName, String lastName, String display, String email, Format format,
			PhotoDTO photo, UserDTO user, ArrayList<MessageDTO> from, ArrayList<MessageDTO> to,
			ArrayList<MessageDTO> cc, ArrayList<MessageDTO> bcc) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.display = display;
		this.email = email;
		this.format = format;
		this.photo = photo;
		this.user = user;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
	}


	public ContactDTO() {
		super();
	}


    public ContactDTO(Contact contact) {
    	this(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getDisplay(), contact.getEmail(), contact.getFormat(), new PhotoDTO(contact.getPhoto()), new UserDTO(contact.getUser()), new ArrayList<MessageDTO>(), new ArrayList<MessageDTO>(), new ArrayList<MessageDTO>(), new ArrayList<MessageDTO>());
    }

	public ContactDTO(String firstName){
        this.firstName = firstName;
    }

    public PhotoDTO getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDTO photo) {
        this.photo = photo;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ArrayList<MessageDTO> getFrom() {
        return from;
    }

    public ArrayList<MessageDTO> getTo() {
        return to;
    }

    public ArrayList<MessageDTO> getCc() {
        return cc;
    }

    public ArrayList<MessageDTO> getBcc() {
        return bcc;
    }

    public void setFrom(ArrayList<MessageDTO> from) {
        this.from = from;
    }

    public void setTo(ArrayList<MessageDTO> to) {
        this.to = to;
    }

    public void setCc(ArrayList<MessageDTO> cc) {
        this.cc = cc;
    }

    public void setBcc(ArrayList<MessageDTO> bcc) {
        this.bcc = bcc;
    }


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
