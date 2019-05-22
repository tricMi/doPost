package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "message")
public class Message {
    private int id;
    private Contact from;
    private ArrayList<Contact> to;
    private ArrayList<Contact> cc;
    private ArrayList<Contact> bcc;
    private Date dateTime;
    private String subject;
    private String content;
    private ArrayList<Tag> tag;
    private ArrayList<Attachment> attachments;
    private Folder folder;
    private Account account;
    private boolean messageRead = true;

    public Message(int id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public Message(int id, Contact from, ArrayList<Contact> to, ArrayList<Contact> cc, ArrayList<Contact> bcc, Date dateTime, String subject, String content, ArrayList<Tag> tag,
                   ArrayList<Attachment> attachments, Folder folder, Account account, boolean messageRead) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.tag = tag;
        this.attachments = attachments;
        this.folder = folder;
        this.account = account;
        this.messageRead = messageRead;
    }

    public boolean isMessageRead() {
		return messageRead;
	}

	public void setMessageRead(boolean messageRead) {
		this.messageRead = messageRead;
	}

	public Message(Contact from, String subject) {
        this.from = from;
        this.subject = subject;

    }
	
//	@GET
//	@Path("/")
//	public Message getThis() {
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
    
    
    
    
    
    
    public Message() {
    }

    public ArrayList<Tag> getTag() {
        return tag;
    }

    public void setTag(ArrayList<Tag> tag) {
        this.tag = tag;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    @GET
	@Path("/folder")
    public Response getFolder() {
    	Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(folder);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
	@Path("/account")
    public Response getAccount() {
    	Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(account);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @GET
	@Path("/from")
    public Response getFrom() {
    	Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(from);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public ArrayList<Contact> getTo() {
        return to;
    }

    public void setTo(ArrayList<Contact> to) {
        this.to = to;
    }

    public ArrayList<Contact> getCc() {
        return cc;
    }

    public void setCc(ArrayList<Contact> cc) {
        this.cc = cc;
    }

    public ArrayList<Contact> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<Contact> bcc) {
        this.bcc = bcc;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @GET
	@Path("/attachments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContacts() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(attachments);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    @Path("/attachments/{id}")
	public Attachment getAtt(@PathParam("id")int id) {
		for(Attachment it: attachments) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    
    @GET
	@Path("/tags")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTags() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(tag);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    @Path("/tags/{id}")
	public Tag getTagById(@PathParam("id")int id) {
		for(Tag it: tag) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    
    @GET
	@Path("/cc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCC() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(cc);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    
    @Path("/cc/{id}")
	public Contact getCCById(@PathParam("id")int id) {
		for(Contact it: cc) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    
    @GET
	@Path("/bcc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBCC() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(bcc);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    @Path("/bcc/{id}")
	public Contact getBCCById(@PathParam("id")int id) {
		for(Contact it: bcc) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    
    @GET
	@Path("/to")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getToList() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(to);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    @Path("/to/{id}")
	public Contact getToById(@PathParam("id")int id) {
		for(Contact it: to) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    
    
    
}
