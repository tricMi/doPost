package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.Account;

public class AccountDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String smtp_address;
    private Integer smtp_port;
    private Short inserver_type;
    private String inserver_address;
    private Integer inserver_port;
    private String username;
    private String password;
    private String displayname;
    private ArrayList<MessageDTO> messages = new ArrayList<MessageDTO>();
    private ArrayList<FolderDTO> folders = new ArrayList<FolderDTO>();

   
    

	public AccountDTO(Long id, String smtp_address, Integer smtp_port, Short inserver_type, String inserver_address,
			Integer inserver_port, String username, String password, String displayname, ArrayList<MessageDTO> messages,
			ArrayList<FolderDTO> folders) {
		super();
		this.id = id;
		this.smtp_address = smtp_address;
		this.smtp_port = smtp_port;
		this.inserver_type = inserver_type;
		this.inserver_address = inserver_address;
		this.inserver_port = inserver_port;
		this.username = username;
		this.password = password;
		this.displayname = displayname;
		this.messages = messages;
		this.folders = folders;
	}


	public AccountDTO() {
    	super();
    }
	
    
    public AccountDTO(Account account) {
    	this(account.getId(), account.getSmtp_address(), account.getSmtp_port(), account.getInserver_type(), account.getInserver_address(), account.getInserver_port(), account.getUsername(), account.getPassword(), account.getDisplayname(), new ArrayList<MessageDTO>(), new ArrayList<FolderDTO>());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public String getSmtp_address() {
		return smtp_address;
	}

	public void setSmtp_address(String smtp_address) {
		this.smtp_address = smtp_address;
	}

	public Integer getSmtp_port() {
		return smtp_port;
	}

	public void setSmtp_port(Integer smtp_port) {
		this.smtp_port = smtp_port;
	}

	public Short getInserver_type() {
		return inserver_type;
	}

	public void setInserver_type(Short inserver_type) {
		this.inserver_type = inserver_type;
	}

	public String getInserver_address() {
		return inserver_address;
	}

	public void setInserver_address(String inserver_address) {
		this.inserver_address = inserver_address;
	}

	public Integer getInserver_port() {
		return inserver_port;
	}

	public void setInserver_port(Integer inserver_port) {
		this.inserver_port = inserver_port;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public ArrayList<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<MessageDTO> messages) {
		this.messages = messages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ArrayList<FolderDTO> getFolders() {
		return folders;
	}


	public void setFolders(ArrayList<FolderDTO> folders) {
		this.folders = folders;
	}
    
	
    
}
