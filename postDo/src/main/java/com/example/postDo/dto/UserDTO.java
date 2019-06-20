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
	private ArrayList<AccountDTO> accounts = new ArrayList<>();
	
	public UserDTO() {}
	
	
	
	public UserDTO(Long id, String username, String password, String firstname, String lastname,
			ArrayList<AccountDTO> accounts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.accounts = accounts;
	}



	public UserDTO(User user) {
		this(user.getId(), user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), new ArrayList<AccountDTO>());
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
	
	

}
