package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String smtp;
    private String pop3_imap;
    private String username;
    private String password;
    private ArrayList<MessageDTO> messages;

    public AccountDTO(Long id, String smtp, String pop3_imap, String username, String password, ArrayList<MessageDTO> message) {
        this.id = id;
        this.smtp = smtp;
        this.pop3_imap = pop3_imap;
        this.username = username;
        this.password = password;
        this.messages = message;
    }

    public AccountDTO() {
    	super();
    }
    
    public AccountDTO(com.example.postDo.entity.Account account) {
    	this(account.getId(), account.getSmtp(), account.getPop3_imap(), account.getUsername(), account.getPassword(), new ArrayList<MessageDTO>());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ArrayList<MessageDTO> getMessage() {
        return messages;
    }

    public void setMessage(ArrayList<MessageDTO> message) {
        this.messages = message;
    }
}
