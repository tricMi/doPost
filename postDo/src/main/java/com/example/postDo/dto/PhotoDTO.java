package com.example.postDo.dto;


import java.io.Serializable;

import com.example.postDo.entity.Photo;


public class PhotoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String path;
  //  private ContactDTO contact;

    public PhotoDTO() {
    	super();
    }

    public PhotoDTO(Long id, String path) {
        this.id = id;
        this.path = path;
    }
    
    public PhotoDTO(Photo photo) {
    	this(photo.getId(), photo.getPath());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public ContactDTO getContact() {
//        return contact;
//    }
//
//    public void setContact(ContactDTO contact) {
//        this.contact = contact;
//    }
}
