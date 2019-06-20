package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.Folder;


public class FolderDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private FolderDTO parentFolder;
    private ArrayList<MessageDTO> messages;
    private RuleDTO rule;


    public FolderDTO(Long id, String name, FolderDTO parentFolder, ArrayList<MessageDTO> messages, RuleDTO rule) {
		super();
		this.id = id;
		this.name = name;
		this.parentFolder = parentFolder;
		this.messages = messages;
		this.rule = rule;
	}

    public FolderDTO(Folder folder){
		this(folder.getId(), folder.getName(), (folder.getFolder() != null && folder.getFolder().getId() != null)?new FolderDTO(folder.getFolder()):new FolderDTO(), new ArrayList<MessageDTO>(), new RuleDTO(folder.getRule()));
	}
	public FolderDTO(){
    	super();

    }

    public Long getId() {
        return id;
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


	public FolderDTO getParentFolder() {
		return parentFolder;
	}

	public void setParentFolder(FolderDTO parentFolder) {
		this.parentFolder = parentFolder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RuleDTO getRule() {
		return rule;
	}


	public void setRule(RuleDTO rule) {
		this.rule = rule;
	}
}
