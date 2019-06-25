package com.example.postDo.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.postDo.entity.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
//	private boolean enabled = true;
//	private ArrayList<AuthorityDTO> authorities = new ArrayList<>();
	private ArrayList<AccountDTO> accounts = new ArrayList<>();
	private ArrayList<ContactDTO> contacts = new ArrayList<>();
	private ArrayList<TagDTO> tags = new ArrayList<>();
	
	public UserDTO() {}

	public UserDTO(Long id, String username, String password, String firstname, String lastname,
			ArrayList<AccountDTO> accounts, ArrayList<ContactDTO> contacts, ArrayList<TagDTO> tags) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accounts = accounts;
		this.contacts = contacts;
		this.tags = tags;
	}





	public UserDTO(User user) {
		this(user.getId(), user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), new ArrayList<AccountDTO>(), new ArrayList<ContactDTO>(), new ArrayList<TagDTO>());
	}
	
	
	public ArrayList<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<AccountDTO> accounts) {
		this.accounts = accounts;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<ContactDTO> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<TagDTO> getTags() {
		return tags;
	}

	public void setTags(ArrayList<TagDTO> tags) {
		this.tags = tags;
	}

	


//	public boolean isEnabled() {
//		return enabled;
//	}
//
//
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//
//
//	public ArrayList<AuthorityDTO> getAuthorities() {
//		return authorities;
//	}
//
//
//
//	public void setAuthorities(ArrayList<AuthorityDTO> authorities) {
//		this.authorities = authorities;
//	}
	
	

}
