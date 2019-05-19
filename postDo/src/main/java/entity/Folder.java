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
@Table(name = "folder")
public class Folder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "folder_name", unique = false, nullable = false)
    private String name;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
    private ArrayList<Folder> folders;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "folder")
    private ArrayList<Message> messages;
    
    @Column(name = "folder_rule", unique = false, nullable = false)
    private Rule rule;

    public Folder(int id, String name, ArrayList<Folder> folders, ArrayList<Message> messages, Rule rule) {
        this.id = id;
        this.name = name;
        this.folders = folders;
        this.messages = messages;
        this.rule = rule;
    }

    public Folder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Folder(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }
}
