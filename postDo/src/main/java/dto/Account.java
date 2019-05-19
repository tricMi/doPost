package dto;

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


public class Account {
	
	private int id;
    private String smtp;
    private String pop3_imap;
    private String username;
    private String password;
    private ArrayList<Message> messages;

    public Account(int id, String smtp, String pop3_imap, String username, String password, ArrayList<Message> message) {
        this.id = id;
        this.smtp = smtp;
        this.pop3_imap = pop3_imap;
        this.username = username;
        this.password = password;
        this.messages = message;
    }

    public Account() {
    	super();
    }
    
    public Account(entity.Account account) {
    	this(account.getId(), account.getSmtp(), account.getPop3_imap(), account.getUsername(), account.getPassword(), new ArrayList<Message>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getPop3_imap() {
        return pop3_imap;
    }

    public void setPop3_imap(String pop3_imap) {
        this.pop3_imap = pop3_imap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Message> getMessage() {
        return messages;
    }

    public void setMessage(ArrayList<Message> message) {
        this.messages = message;
    }
}
