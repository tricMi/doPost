package service;

import java.util.ArrayList;
import java.util.Comparator;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Account;
import model.Attachment;
import model.Condition;
import model.Contact;
import model.Folder;
import model.Format;
import model.Message;
import model.Operation;
import model.Photo;
import model.Rule;
import model.Tag;

@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/service")
public class MainService {

	ArrayList<Message> allMessages = new ArrayList<>();
	ArrayList<Account> accounts = new ArrayList<>();
	ArrayList<Contact> contacts = new ArrayList<>();
	ArrayList<Folder> allfolders = new ArrayList<>();
	
	
	
	public MainService() {
		init();
	}
	
	private void init() {
		
		
		ArrayList<Message> m = new ArrayList<>();
		ArrayList<Message> m2 = new ArrayList<>();
	    ArrayList<Message> m3 = new ArrayList<>();
	    ArrayList<Tag> tags = new ArrayList<>();
	    ArrayList<Tag> tags2 = new ArrayList<>();
	    ArrayList<Tag> tags3 = new ArrayList<>();
	    ArrayList<Folder> folders = new ArrayList<>();
	    ArrayList<Contact> to = new ArrayList<>();
	    ArrayList<Contact> to2 = new ArrayList<>();
	    ArrayList<Contact> to3 = new ArrayList<>();
	    ArrayList<Contact> cc = new ArrayList<>();
	    ArrayList<Contact> cc2 = new ArrayList<>();
	    ArrayList<Contact> bcc = new ArrayList<>();
	    ArrayList<Contact> bcc2 = new ArrayList<>();
	    ArrayList<Attachment> attachments = new ArrayList<>();
	    ArrayList<Attachment> attachments2 = new ArrayList<>();
	    ArrayList<Attachment> attachments3 = new ArrayList<>();

	    Photo photo = new Photo();
	    
	    Contact conTemp = new Contact(1, "Pera", "Peric", "Pex", "pera123@gmail.com", Format.PLAIN, photo);
	    Contact conTemp2 = new Contact(2, "Aleksandar", "Aleksic", "Acoo", "aco123@gmail.com", Format.HTML, photo);
	    Contact conTemp3 = new Contact(3, "Maja", "Maric", "Maki", "maki123@gmail.com", Format.HTML, photo);
	    Contact conTemp4 = new Contact(4, "me", "Stevic", "Stefi", "stefi123@gmail.com", Format.HTML, photo);
	    Contact conTemp5 = new Contact(5, "Emily", "Emmy", "Emily", "emily123@gmail.com", Format.HTML, photo);
	    
	    contacts.add(conTemp);
	    contacts.add(conTemp2);
	    contacts.add(conTemp3);
	    contacts.add(conTemp4);
	    contacts.add(conTemp5);

	    //obrisan m
	    Tag tagTemp = new Tag(1, "First Tag");
	    Tag tagTemp2 = new Tag(2, "Second Tag");
	    Tag tagTemp3 = new Tag(3, "Third Tag");
	    Tag tagTemp4 = new Tag(4, "Fourth Tag");
	    Tag tagTemp5 = new Tag(5, "Fifth Tag");


	    Rule rule = new Rule(1, Condition.TO, Operation.MOVE);
	    Rule rule2 = new Rule(2, Condition.FROM, Operation.DELETE);
	    Rule rule3 = new Rule(3, Condition.SUBJECT, Operation.COPY);

	    Folder folder = new Folder(1, "Drafts", 1,new ArrayList<Message>(),rule3);
	    Folder folder2 = new Folder(2, "Promotions", 2, new ArrayList<Message>(),rule);
	    Folder folder3 = new Folder(3, "Trash", 1, new ArrayList<Message>(),rule2);
	    Folder folder4 = new Folder(4, "Electronics", 1, new ArrayList<Message>(),rule2);
	    Folder folder5 = new Folder(5, "Recent promotions", 2, new ArrayList<Message>(),rule2);

	    //komentar
	    
	    allfolders.add(folder);
	    allfolders.add(folder2);
	    allfolders.add(folder3);
	    allfolders.add(folder4);
	    allfolders.add(folder5);
	    
	    //obrisano m iz konstruktora
	    Account account1 = new Account(1, "smtp1", "pop3", "user", "user");
	    Account account2 = new Account(2, "smtp2", "pop3", "youremail@gmail.com", "1232");
	    Account account3 = new Account(3, "smtp3", "pop3", "theiremail@gmail.com", "1233");
	    Account account4 = new Account(4, "smtp4", "pop3", "ouremail@gmail.com", "1234");

	    accounts.add(account1);
	    accounts.add(account2);
	    accounts.add(account3);
	    accounts.add(account4);

	    Message messageTemp = new Message(1, conTemp, to, cc, bcc,  "2019-02-13 09:50", "Matematika 1" , "This is some message", tags, attachments, folder, account1 );
	    Message messageTemp2 = new Message(2, conTemp2, to2, new ArrayList<Contact>(), bcc2, "2019-01-29 13:24",  "Osnove programiranja", "Just a dumb message",tags2, attachments2, folder2, account2);
	    Message messageTemp3 = new Message(3,  conTemp3, to3, cc2, new ArrayList<Contact>(),"2019-03-19 22:22", "Sistemski softver", "Another dumb message", tags3, attachments3, folder3, account3);

	    //obrisan messageTemp
	    Attachment attachment = new Attachment(1, "some data", "type1", "attachment1");
	    Attachment attachment2 = new Attachment(2, "some data", "type2", "attachment2");
	    Attachment attachment3 = new Attachment(3, "some data", "type3", "attachment3");
	    Attachment attachment4 = new Attachment(4, "some data", "type4", "attachment4");
	    Attachment attachment5 = new Attachment(5, "some data", "type5", "attachment5");
	    
	    m.add(messageTemp);
        m2.add(messageTemp2);
        m3.add(messageTemp3);
        
        allMessages.add(messageTemp3);
        allMessages.add(messageTemp2);
        allMessages.add(messageTemp);
        
        tags.add(tagTemp);
        tags2.add(tagTemp2);
        tags2.add(tagTemp4);
        tags3.add(tagTemp3);
        tags3.add(tagTemp5);

        to.add(conTemp4);
        to2.add(conTemp4);
        to2.add(conTemp5);
        to3.add(conTemp4);
        cc.add(conTemp3);
        cc.add(conTemp5);
        bcc.add(conTemp5);
        cc2.add(conTemp);
        cc2.add(conTemp4);
        bcc2.add(conTemp);
        bcc2.add(conTemp2);

        folders.add(folder4);
        folders.add(folder5);

        attachments.add(attachment);
        attachments.add(attachment4);
        attachments2.add(attachment2);
        attachments3.add(attachment3);
        attachments3.add(attachment5);
		
	}
	
//	@GET
//	@Path("/messages")
//	public ArrayList<Message> getMessages(){
//		
//		
//		return allMessages;
//	}
	
	@GET
	@Path("/accounts")
	public Response getAccounts(){
		
		Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(accounts);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
		
	}
	
	@GET
	@Path("/folders")
	public Response getFolders(){
		Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(allfolders);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
		
	}
	
	@Path("/folders/{id}")
	public Folder getFolderById(@PathParam("id")int id) {
		
		try {
			for(Folder m: allfolders) {
				if(m.getId() == id) {
					return m;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/contacts")
	public Response getContacts(){
		
		Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(contacts);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
		
	}
	
	@Path("/contacts/{id}")
	public Contact getContactById(@PathParam("id")int id) {
		
		try {
			for(Contact m: contacts) {
				if(m.getId() == id) {
					return m;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/login/{username}/{password}")
	public Response login(@PathParam("username")String username, @PathParam("password")String password){
		for(Account a: accounts) {
			if(a.getUsername() == username && a.getPassword() == password) {
				Gson json = new Gson();
			       
		        String response;
		       
		        try {
		        	response = json.toJson(a);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            return Response.status(500).build();
		        }
		       
		        System.out.println(json);
		       
		        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
			}
		}
		return null;
		
	}
	
	@GET
	@Path("/messages")
	public Response getMessages(){
		
		Gson json = new Gson();
	       
        String response;
       
        try {
        	response = json.toJson(allMessages);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(500).build();
        }
       
        System.out.println(json);
       
        return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();
		
	}
	
	@Path("/messages/{id}")
	public Message getMessageById(@PathParam("id")int id) {
		
		try {
			for(Message m: allMessages) {
				if(m.getId() == id) {
					return m;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editaccount/{id}/{username}/{passowrd}")
	public void editaccount(@PathParam("id")int id, @PathParam("username")String username, @PathParam("passowrd")String password) {
		for(Account a: accounts) {
			
			if(a.getId() == id) {
				a.setUsername(username);
				a.setPassword(password);
			}
		}
	}
	
	

	@POST
	@Path("/contacts/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact addContact(Contact contact) {
		contact.setId(hashCode());
		contacts.add(contact);
		return contact;
	}
	
	@DELETE
	@Path("/contacts/{id}")
	public Response deleteContact(@PathParam("id") int id) {
		Contact activeContact = null;
		for(Contact c: contacts) {
			if(c.getId() == id) {
				activeContact = c;
			}
		}
		if(activeContact != null) {
			contacts.remove(activeContact);
			
			return Response.ok().entity("Successful").build();
		}else {
			return Response.status(404).build();
		}
	}
	

	@GET
	@Path("/sortAsc")
	public Response getSortAsc() {
		allMessages.sort(Comparator.comparing(Message :: getDateTime));
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(allMessages);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/sortDesc")
	public Response getSortDesc() {
		allMessages.sort(Comparator.comparing(Message :: getDateTime).reversed());
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(allMessages);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		return Response.status(200).entity(json).type(MediaType.APPLICATION_JSON).build();
	}
	
	//Folder --------------------------------------

	@DELETE
	@Path("/folders/{id}")
	public Response deleteFolder(@PathParam("id") int id) {
		
		for(Folder f: allfolders) {
			if(f.getId() == id) {
				allfolders.remove(f);
				System.out.println("Deleted folder");
				return Response.ok().entity("Successful").build();
			}
		}
		return Response.status(404).build();
	}
	
	@POST
	@Path("/folders/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Folder addFolder(Folder folder) {
		//contact.setId(hashCode());
		allfolders.add(folder);
		return folder;
	}
	
//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/folders/edit")
//	public void editFolder(Folder folder) {
//		for(Folder f: allfolders) {
//			
//			if(f.getId() == folder.getId()) {
//				f.setName(folder.getName());
//				f.setRule(folder.getRuleBasic());
//				f.setMessages(folder.getMessages());
//				f.setInFolder(folder.getInFolder());
//			}
//		}
//	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/folders/edit")
	
	public void editFolder(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		int id;
		String name;
		System.out.println(strSplit);
		id = Integer.parseInt(strSplit[0]);
		name = strSplit[1];
		for(Folder f: allfolders) {
			
			if(f.getId() == id) {
				f.setName(name);
			}
		}
	}
	
	
	

}
