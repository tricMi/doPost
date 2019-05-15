package model;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "account")
public class Account  {

    private int id;
    private String smtp;
    private String pop3_imap;
    private String username;
    private String password;
//    private ArrayList<Message> messages;

//    public Account(int id, String smtp, String pop3_imap, String username, String password, ArrayList<Message> message) {
//        this.id = id;
//        this.smtp = smtp;
//        this.pop3_imap = pop3_imap;
//        this.username = username;
//        this.password = password;
//        this.messages = message;
//    }

    
    public Account(int id, String smtp, String pop3_imap, String username, String password) {
		super();
		this.id = id;
		this.smtp = smtp;
		this.pop3_imap = pop3_imap;
		this.username = username;
		this.password = password;
	}
    
    
	@GET
	@Path("/")
	public Response getThis() {
		Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(this);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println("adsasdasdda");
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editaccount")
	public Account editAccount(Account acc) {
		
		this.username = acc.getUsername();
		this.password = acc.getPassword();
		return this;
	}
    
    

	public Account() {
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

//    public ArrayList<Message> getMessage() {
//        return messages;
//    }
//
//    public void setMessage(ArrayList<Message> message) {
//        this.messages = message;
//    }
}
