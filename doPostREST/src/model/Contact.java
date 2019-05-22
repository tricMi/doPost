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

@XmlRootElement(name = "contact")
public class Contact implements Cloneable{

    private int id;
    private String firstName;
    private String lastName;
    private String display;
    private String email;
    private Format format;
    private Photo photo;

    

	public Contact(int id, String firstName, String lastName, String display, String email, Format format,
			Photo photo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.display = display;
		this.email = email;
		this.format = format;
		this.photo = photo;
	}

	public Contact(int id, String firstName, String lastName, String display, String email, Format format) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
    }

//	@GET
//	@Path("/")
//	public Contact getThis() {
//		return this;
//	}
	
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
    
    public Contact(String firstName){
        this.firstName = firstName;
    }

    
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/contacts/update")
//    public Contact updateContact(Contact con) {
//    	this.firstName = con.getFirstName();
//    	this.lastName = con.getLastName();
//    	this.display = con.getDisplay();
//    	this.email = con.getEmail();
//    	this.format = con.getFormat();
//    	return this;
//    }
    @GET
	@Path("/photo")
    public Response getPhoto() {
    	Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(photo);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
    }
    

    

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

//    public ArrayList<Message> getFrom() {
//        return from;
//    }
//
//    public ArrayList<Message> getTo() {
//        return to;
//    }
//
//    public ArrayList<Message> getCc() {
//        return cc;
//    }
//
//    public ArrayList<Message> getBcc() {
//        return bcc;
//    }
//
//    public void setFrom(ArrayList<Message> from) {
//        this.from = from;
//    }
//
//    public void setTo(ArrayList<Message> to) {
//        this.to = to;
//    }
//
//    public void setCc(ArrayList<Message> cc) {
//        this.cc = cc;
//    }
//
//    public void setBcc(ArrayList<Message> bcc) {
//        this.bcc = bcc;
//    }
    
    //from to cc bcc
    
//    @GET
//   	@Path("/con-to")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public ArrayList<Message> getToList() {
//   		return to;
//   	}
//       
//    @Path("/con-to/{id}")
//   	public Message getToById(@PathParam("id")int id) {
//   		for(Message it: to) {
//   			if(it.getId() == id) {
//   				return it;
//   			}
//   		}
//   		return null;
//   	}
//    
//    @GET
//   	@Path("/con-cc")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public ArrayList<Message> getCCList() {
//   		return cc;
//   	}
//       
//    @Path("/con-cc/{id}")
//   	public Message getCCById(@PathParam("id")int id) {
//   		for(Message it: cc) {
//   			if(it.getId() == id) {
//   				return it;
//   			}
//   		}
//   		return null;
//   	}
//    
//    @GET
//   	@Path("/con-bcc")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public ArrayList<Message> getBCCList() {
//   		return bcc;
//   	}
//       
//    @Path("/con-bcc/{id}")
//   	public Message getBCCById(@PathParam("id")int id) {
//   		for(Message it: bcc) {
//   			if(it.getId() == id) {
//   				return it;
//   			}
//   		}
//   		return null;
//   	}
//    
//    @GET
//   	@Path("/con-from")
//   	@Produces(MediaType.APPLICATION_JSON)
//   	public ArrayList<Message> getFromList() {
//   		return from;
//   	}
//       
//    @Path("/con-bcc/{id}")
//   	public Message getFromById(@PathParam("id")int id) {
//   		for(Message it: from) {
//   			if(it.getId() == id) {
//   				return it;
//   			}
//   		}
//   		return null;
//   	}
    
    
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    } 
    
}
