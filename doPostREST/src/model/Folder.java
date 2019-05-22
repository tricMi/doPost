package model;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;

@XmlRootElement(name = "folder")
public class Folder implements Cloneable{

    private int id;
    private String name;
    private int inFolder;
    private ArrayList<Message> messages;
    private Rule rule;



    public Folder(int id, String name, int inFolder, ArrayList<Message> messages, Rule rule) {
		super();
		this.id = id;
		this.name = name;
		this.inFolder = inFolder;
		this.messages = messages;
		this.rule = rule;
	}

	public Folder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Folder(){

    }

	public int getInFolder() {
		return inFolder;
	}

	public void setInFolder(int inFolder) {
		this.inFolder = inFolder;
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
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    
	public Rule getRuleBasic() {
    	return rule;
	}

	
    
    @GET
	@Path("/rule")
	public Response getRule() {
    	Gson json = new Gson();
	    
	    String response;
	   
	    try {
	    	response = json.toJson(rule);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return Response.status(500).build();
	    }
	    System.out.println(json);
	   
	    return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
//	@GET
//	@Path("/subfolders")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getSubfolderList() {
//    	Gson json = new Gson();
//	       
//        String response;
//       
//        try {
//        	response = json.toJson(folders);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return Response.status(500).build();
//        }
//       
//        System.out.println(json);
//       
//        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
//	}
    
//    @Path("/subfolders/{id}")
//	public Folder getSubfolderById(@PathParam("id")int id) {
//		for(Folder it: folders) {
//			if(it.getId() == id) {
//				return it;
//			}
//		}
//		return null;
//	}
    
    @GET
	@Path("/foldermessages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFolderMessageList() {
    	Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(messages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
    
    @Path("/foldermessages/{id}")
	public Message getFolderMessageById(@PathParam("id")int id) {
		for(Message it: messages) {
			if(it.getId() == id) {
				return it;
			}
		}
		return null;
	}
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    } 
    
}
