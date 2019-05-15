package model;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "tag")
public class Tag  {

    private int id;
    private String name;
//    private ArrayList<Message> messages;

//    public Tag(int id, String name, ArrayList<Message> messages) {
//        this.id = id;
//        this.name = name;
//        this.messages = messages;
//    }
    
    

    public Tag() {
    }

    public Tag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
        return id;
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
	   
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ArrayList<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(ArrayList<Message> messages) {
//        this.messages = messages;
//    }
}
