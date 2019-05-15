package model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "attachment")
public class Attachment {

    private int id;
    private String data;
    private String type;
    private String name;
//    private Message message;

//    public Attachment(int id, String data, String type, String name, Message message) {
//        this.id = id;
//        this.data = data;
//        this.type = type;
//        this.name = name;
//        this.message = message;
//    }
    

    public Attachment() {
    }

    public Attachment(int id, String data, String type, String name) {
	super();
	this.id = id;
	this.data = data;
	this.type = type;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Message getMessage() {
//        return message;
//    }
//
//    public void setMessage(Message message) {
//        this.message = message;
//    }
}
