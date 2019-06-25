package com.example.postDo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "username", unique = false, nullable = false)
    private String username;
	
	@Column(name = "password", unique = false, nullable = false)
    private String password;
	
	@Column(name = "firstname", unique = false, nullable = false)
    private String firstname;
	
	@Column(name = "lastname", unique = false, nullable = false)
    private String lastname;
	
//	 @Column(name = "enabled")
//	 private boolean enabled;
//
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_authority",
//            joinColumns = @JoinColumn(name = "u_id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "a_id", referencedColumnName = "authority_id"))
//    private List<Authority> authorities;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Account> accounts = new HashSet<Account>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Tag> tags = new HashSet<Tag>();
	

//	public User(Long id, String username, String password, String firstname, String lastname, boolean enabled,
//			List<Authority> authorities, Set<Account> accounts) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.enabled = enabled;
//		this.authorities = authorities;
//		this.accounts = accounts;
//	}
	
	

//
//	public User(Long id, String username, String password, String firstname, String lastname, Set<Account> accounts) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.accounts = accounts;
//	}
	
//	<dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
	
	public User() {
		super();
	}


	public User(Long id, String username, String password, String firstname, String lastname, Set<Account> accounts,
			Set<Contact> contacts, Set<Tag> tags) {
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Set<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}


	public Set<Tag> getTags() {
		return tags;
	}


	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	

//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//
//	public void setAuthorities(List<Authority> authorities) {
//		this.authorities = authorities;
//	}
	
	

}
