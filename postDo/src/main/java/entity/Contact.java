package entity;

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
@Table(name = "contact")
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
	
	@Column(name = "contact_photo", unique = false, nullable = false)
    private Photo photo;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "contact")
    private ArrayList<Message> from;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "contact")
    private ArrayList<Message> to;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "contact")
    private ArrayList<Message> cc;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "contact")
    private ArrayList<Message> bcc;


    public Contact(int id, String firstName, String lastName, String display, String email, Format format, Photo photo, ArrayList<Message> from, ArrayList<Message> to, ArrayList<Message> cc, ArrayList<Message> bcc) {
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

    public Contact(int id, String firstName, String lastName, String display, String email, Format format, Photo photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
        this.photo = photo;
    }

    public Contact(int id, String firstName, String lastName, String display, String email, Format format) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
    }

    public Contact(String firstName){
        this.firstName = firstName;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Contact() {
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

    public ArrayList<Message> getFrom() {
        return from;
    }

    public ArrayList<Message> getTo() {
        return to;
    }

    public ArrayList<Message> getCc() {
        return cc;
    }

    public ArrayList<Message> getBcc() {
        return bcc;
    }

    public void setFrom(ArrayList<Message> from) {
        this.from = from;
    }

    public void setTo(ArrayList<Message> to) {
        this.to = to;
    }

    public void setCc(ArrayList<Message> cc) {
        this.cc = cc;
    }

    public void setBcc(ArrayList<Message> bcc) {
        this.bcc = bcc;
    }
}
