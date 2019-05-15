package model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "photo")
public class Photo  {
    private int id;
    private int path;
    private Contact contact;

    public Photo() {
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
    
    public Photo(int id, int path, Contact contact) {
        this.id = id;
        this.path = path;
        this.contact = contact;
    }

    public Photo(int id, int path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
