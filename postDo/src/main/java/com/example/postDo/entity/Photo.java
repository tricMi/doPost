package com.example.postDo.entity;

import java.io.Serializable;

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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "photos")
public class Photo implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "photo_path", unique = false, nullable = false)
    private int path;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_contact", referencedColumnName = "contact_id")
    private Contact contact;

    public Photo() {
    }

    public Photo(int id, int path, Contact contact) {
        this.id = id;
        this.path = path;
        this.contact = contact;
    }

    public Photo(int id, int path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
