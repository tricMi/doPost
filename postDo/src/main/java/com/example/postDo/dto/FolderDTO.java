package com.example.postDo.dto;

import java.io.Serializable;

import java.util.ArrayList;

import com.example.postDo.entity.Folder;


public class FolderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private FolderDTO parent;
    private ArrayList<FolderDTO> folders;
    private ArrayList<MessageDTO> messages;
    private ArrayList<RuleDTO> rules = new ArrayList<RuleDTO>();
    private AccountDTO account;	
	
	
    public FolderDTO(Long id, String name, FolderDTO parent, ArrayList<FolderDTO> folders,
			ArrayList<MessageDTO> messages, ArrayList<RuleDTO> rules, AccountDTO account) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.folders = folders;
		this.messages = messages;
		this.rules = rules;
		this.account = account;
	}


	public FolderDTO(Folder folder){
		this(folder.getId(), folder.getName(), (folder.getParent() != null && folder.getParent().getId() != null)?new FolderDTO(folder.getParent()):new FolderDTO(),
				
				new ArrayList<FolderDTO>(), new ArrayList<MessageDTO>(), new ArrayList<RuleDTO>(), new AccountDTO(folder.getAccount()));
	}
	
	
	public FolderDTO(){
    	super();

    }
	
	public void addFolder(FolderDTO folder) {
	    folders.add(folder);
	}

    public ArrayList<FolderDTO> getFolders() {
		return folders;
	}
	public void setFolders(ArrayList<FolderDTO> folders) {
		this.folders = folders;
	}
	public Long getId() {
        return id;
    }
    
    public ArrayList<RuleDTO> getRules() {
		return rules;
	}
	public void setRules(ArrayList<RuleDTO> rules) {
		this.rules = rules;
	}

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDTO> messages) {
        this.messages = messages;
    }


	public FolderDTO getParent() {
		return parent;
	}

	public void setParent(FolderDTO parentFolder) {
		this.parent = parentFolder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	
	
}
