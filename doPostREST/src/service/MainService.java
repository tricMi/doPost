package service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.ejb.Singleton;
import javax.imageio.ImageIO;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
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
	ArrayList<Tag> allTags = new ArrayList<>();
	ArrayList<Attachment> allAttachments = new ArrayList<>();
	Photo photo = new Photo();
	Folder sent;
	Folder drafts;
	
	
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

	  
	    
	    photo.setPath("pikachu.png");
	    
//	    String imagePath = "path/to/your/image.jpg";
//	    BufferedImage myPicture = ImageIO.read(new File(imagePath));
	    
	    Contact conTemp = new Contact(1, "Pera", "Peric", "Pex", "user@gmail.com", Format.PLAIN, photo);
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

	    drafts = new Folder(1, "Drafts", 1,new ArrayList<Message>(),rule3);
	    Folder folder2 = new Folder(2, "Promotions", 2, new ArrayList<Message>(),rule);
	    Folder folder3 = new Folder(3, "Trash", 1, new ArrayList<Message>(),rule2);
	    Folder folder4 = new Folder(4, "Electronics", 1, new ArrayList<Message>(),rule2);
	    Folder folder5 = new Folder(5, "Recent promotions", 2, new ArrayList<Message>(),rule2);
	    sent = new Folder(6, "Sent", 2, new ArrayList<Message>(),rule2);

	    //komentar
	    
	    allfolders.add(sent);
	    allfolders.add(drafts);
	    allfolders.add(folder2);
	    allfolders.add(folder3);
	    allfolders.add(folder4);
	    allfolders.add(folder5);
	    
	    //obrisano m iz konstruktora
	    Account account1 = new Account(1, "smtp1", "pop3", "user@gmail.com", "user");
	    Account account2 = new Account(2, "smtp2", "pop3", "youremail@gmail.com", "1232");
	    Account account3 = new Account(3, "smtp3", "pop3", "theiremail@gmail.com", "1233");
	    Account account4 = new Account(4, "smtp4", "pop3", "ouremail@gmail.com", "1234");
	    Account account5 = new Account(5, "smtp1", "pop3", "person@gmail.com", "user");

	    accounts.add(account1);
	    accounts.add(account2);
	    accounts.add(account3);
	    accounts.add(account4);
	    accounts.add(account5);


	    Message messageTemp = new Message(1, conTemp, to, cc, bcc,  "2019-02-13 09:50", "Matematika 1" , "This is some message", tags, attachments, sent, account1, true );
	    Message messageTemp2 = new Message(2, conTemp2, to2, new ArrayList<Contact>(), bcc2, "2019-01-29 13:24",  "Osnove programiranja", "Just a dumb message",tags2, attachments2, sent, account2, false);
	    Message messageTemp3 = new Message(3,  conTemp3, to3, cc2, new ArrayList<Contact>(),"2019-03-19 22:22", "Sistemski softver", "Another dumb message", tags3, attachments3, folder3, account3, true);
	    
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
        allTags.add(tagTemp5);
        allTags.add(tagTemp4);
        allTags.add(tagTemp3);
        allTags.add(tagTemp2);
        allTags.add(tagTemp);

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
        allAttachments.add(attachment);
        allAttachments.add(attachment2);
        allAttachments.add(attachment3);
        allAttachments.add(attachment4);
        allAttachments.add(attachment5);
		
	}
	


	
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
       
//        System.out.println(json);
       
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
       
//        System.out.println(json);
       
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
				return Response.ok().entity("Successful").build();
			}
		}
		return Response.status(404).build();
	}
	
//	@POST
//	@Path("/folders/add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Folder addFolder(Folder folder) {
//		//contact.setId(hashCode());
//		allfolders.add(folder);
//		return folder;
//	}
	
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
		
		id = Integer.parseInt(strSplit[0].substring(1));
		name = strSplit[1].substring(0, strSplit[1].length() - 1);
		

		
		for(Folder f: allfolders) {
			
			if(f.getId() == id) {
				f.setName(name);
			}
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/contacts/edit")
	public void editContact(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		
		int id;
		String firstName;
		String lastName;
		String display;
		String email;
		String formatStr;
		
		id = Integer.parseInt(strSplit[0].substring(1));
		firstName = strSplit[1];
		lastName = strSplit[2];
		display = strSplit[3];
		email = strSplit[4];
		formatStr = strSplit[1].substring(0, strSplit[1].length() - 1);
		Format format;
		if(formatStr.equals("HTML")) {
			format = Format.HTML;
		}else {
			format = Format.PLAIN;
		}
		

		
		for(Contact c: contacts) {
			
			if(c.getId() == id) {
				c.setFirstName(firstName);
				c.setLastName(lastName);
				c.setDisplay(display);
				c.setEmail(email);
				c.setFormat(format);
			}
		}
	}
	
	@POST
	@Path("/folders/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Folder addFolder(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		
		int id;
		String name;
		Condition condition = Condition.TO;
		Operation operation = Operation.MOVE;
		

		
		name = strSplit[0].substring(1, strSplit[0].length());

		String operationString = strSplit[1];
		String conditionString = strSplit[2].substring(0, strSplit[2].length()-1);
		
		if(conditionString.equals("TO")) {
			condition = Condition.TO;
		}else if(conditionString.equals("FROM")){
			condition = Condition.FROM;
		}else if(conditionString.equals("CC")){
			condition = Condition.CC;
		}else if(conditionString.equals("SUBJECT")){
			condition = Condition.SUBJECT;
		}
		
		if(operationString.equals("MOVE")) {
			operation = Operation.MOVE;
		}else if(operationString.equals("COPY")){
			operation = Operation.COPY;
		}else if(operationString.equals("DELETE")){
			operation = Operation.DELETE;
		}
		Rule rule = new Rule(hashCode(), condition, operation);
		
		id = hashCode();
		

		
		Folder newFolder = new Folder();
		newFolder.setId(id);
		newFolder.setName(name);
		newFolder.setRule(rule);
		
		allfolders.add(newFolder);
		return newFolder;
	}
	
	@POST
	@Path("/contacts/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact addContact(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		
		int id;
		String firstName;
		String lastName;
		String display;
		String email;
		String formatStr;
		
		id = hashCode();
		firstName = strSplit[0].substring(1);
		lastName = strSplit[1];
		display = strSplit[2];
		email = strSplit[3];
		formatStr = strSplit[4].substring(0, strSplit[1].length() - 1);;
		Format format;
		
		if(formatStr.equals("HTML")) {
			format = Format.HTML;
		}else {
			format = Format.PLAIN;
		}
		
		Contact newContact = new Contact();
		newContact.setId(id);
		newContact.setFirstName(firstName);
		newContact.setLastName(lastName);
		newContact.setDisplay(display);
		newContact.setEmail(email);
		newContact.setFormat(format);
		
		contacts.add(newContact);
		return newContact;
	}
	

	@DELETE
	@Path("/messages/{id}")
	public Response deleteMessage(@PathParam("id") int id) {
		
		for(Message m: allMessages) {
			if(m.getId() == id) {
				allMessages.remove(m);
				System.out.println("Deleted message");
				return Response.ok().entity("Successful").build();
			}
		}
		return Response.status(404).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/messages/edit")
	public void editMessage(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
	
		
		int id;
		boolean messageRead;
		
		id = Integer.parseInt(strSplit[0].substring(1));

		messageRead = Boolean.parseBoolean(strSplit[1].substring(0, strSplit[1].length() -1));
		messageRead = true;

		
		for(Message m: allMessages) {
			
			if(m.getId() == id) {
				m.setMessageRead(messageRead);
			}
		}
	}
	
	@POST
	@Path("/messages/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		
		Contact from = new Contact();
		ArrayList<Contact> to = new ArrayList<>();
		ArrayList<Contact> cc = new ArrayList<>();
		ArrayList<Contact> bcc = new ArrayList<>();
		ArrayList<Tag> tags = new ArrayList<>();
		ArrayList<Attachment> attachments = new ArrayList<>();
		Folder folder = new Folder();
		Account account = new Account();
		boolean read;
		
		int id = hashCode();
		//-----------
				try {
					int fromId = Integer.parseInt(strSplit[0].substring(1));
					for(Contact con : contacts) {
						if(con.getId() == fromId) {
							try {
								from = (Contact)con.clone();
							}catch(CloneNotSupportedException c){} 
							
						}
					}
				}catch(Exception ex) {
					from = new Contact();
				}
				
		//------------------
				try {
					String[] toSplit = strSplit[1].split("|");
					for(String conId : toSplit) {
						for(Contact con : contacts) {
							if(con.getId() == Integer.parseInt(conId)) {
//								System.out.println(con.getId() + " " + conId);
								to.add(con);
							}
						}
					}
				}catch(Exception ex) {
					
				}
				
		//--------------------------
				try {
					String[] ccSplit = strSplit[2].split("|");
					for(String conId : ccSplit) {
						for(Contact con : contacts) {
							if(con.getId() == Integer.parseInt(conId)) {
//								System.out.println(con.getId() + " " + conId);
								cc.add(con);
							}
						}
					}
					
					
				}catch(Exception ex) {
					
				}
				
		//----------------------------
				try {
					String[] bccSplit = strSplit[3].split("|");
					for(String conId : bccSplit) {
						for(Contact con : contacts) {
							if(con.getId() == Integer.parseInt(conId)) {
//								System.out.println(con.getId() + " " + conId);
								bcc.add(con);
							}
						}
					}
				}catch(Exception ex) {
					
				}
				
		//-------------------
				String dateTime="", subject="", content="";
				try {
					dateTime = strSplit[4];
					subject = strSplit[5];
					content = strSplit[6];
					
				}catch(Exception ex) {
					dateTime = "";
					subject = "";
					content = "";
					
				}
		//------------------------

				try {
					String[] tagsSplit = strSplit[7].split(".");
					for(String tagString : tagsSplit) {
						Tag newTag = new Tag();
						newTag.setId(hashCode());
						newTag.setName(tagString);
						tags.add(newTag);
					}
				}catch(Exception ex) {
					
				}
				
				
		//---------------------
				try {
					String[] attachmentsSplit = strSplit[8].split(".");
					ArrayList<Integer> attachmentsIdList = new ArrayList<>();
					for(String str : attachmentsSplit) {
						attachmentsIdList.add(Integer.parseInt(str));
					}
					for(String attString : attachmentsSplit) {
						String[] attSplit = attString.split("|");
						
						Attachment att = new Attachment();
						att.setId(hashCode());
						att.setData(attachmentsSplit[0]);
						att.setType(attachmentsSplit[1]);
						att.setName(attachmentsSplit[2]);
						attachments.add(att);
					}
				}catch(Exception ex) {
					
				}
				
		//-------------------------
				try {
					int folderId = Integer.parseInt(strSplit[9]);
					for(Folder fol : allfolders) {
						if(fol.getId() == folderId) {
							try {
								folder = (Folder)fol.clone();
							}catch(CloneNotSupportedException c){} 
							
						}
					}
				}catch(Exception ex) {
					folder = new Folder();
				}
				
		//----------------------
				try {
					int accountId = Integer.parseInt(strSplit[10].substring(0, strSplit[10].length() - 1));
					for(Account acc : accounts) {
						if(acc.getId() == accountId) {
							try {
								account = (Account)acc.clone();
							}catch(CloneNotSupportedException c){} 
							
						}
					}
				}catch(Exception ex) {
					account = new Account();
				}
		read = false;
				
		Message newMessage = new Message();
		newMessage.setId(id);
		newMessage.setFrom(from);
		newMessage.setTo(to);
		newMessage.setCc(cc);
		newMessage.setBcc(bcc);
		newMessage.setDateTime(dateTime);
		newMessage.setSubject(subject);
		newMessage.setContent(content);
		newMessage.setTag(tags);
		newMessage.setAttachments(attachments);
		newMessage.setFolder(folder);
		newMessage.setAccount(account);
		newMessage.setMessageRead(read);
		
		
		allMessages.add(newMessage);
		sent.addMessage(newMessage);
		
		return newMessage;
	}
	
	@POST
	@Path("/messages/draft")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message draftMessage(String params) {
		System.out.println(params);
		String[] strSplit = params.split(",");
		
		Contact from = new Contact();
		ArrayList<Contact> to = new ArrayList<>();
		ArrayList<Contact> cc = new ArrayList<>();
		ArrayList<Contact> bcc = new ArrayList<>();
		ArrayList<Tag> tags = new ArrayList<>();
		ArrayList<Attachment> attachments = new ArrayList<>();
		Folder folder = new Folder();
		Account account = new Account();
		boolean read;
		
		int id = hashCode();
//-----------
		try {
			int fromId = Integer.parseInt(strSplit[0].substring(1));
			for(Contact con : contacts) {
				if(con.getId() == fromId) {
					try {
						from = (Contact)con.clone();
					}catch(CloneNotSupportedException c){} 
					
				}
			}
		}catch(Exception ex) {
			from = new Contact();
		}
		
//------------------
		try {
			String[] toSplit = strSplit[1].split("|");
			for(String conId : toSplit) {
				for(Contact con : contacts) {
					if(con.getId() == Integer.parseInt(conId)) {
//						System.out.println(con.getId() + " " + conId);
						to.add(con);
					}
				}
			}
		}catch(Exception ex) {
			
		}
		
//--------------------------
		try {
			String[] ccSplit = strSplit[2].split("|");
			for(String conId : ccSplit) {
				for(Contact con : contacts) {
					if(con.getId() == Integer.parseInt(conId)) {
//						System.out.println(con.getId() + " " + conId);
						cc.add(con);
					}
				}
			}
			
			
		}catch(Exception ex) {
			
		}
		
//----------------------------
		try {
			String[] bccSplit = strSplit[3].split("|");
			for(String conId : bccSplit) {
				for(Contact con : contacts) {
					if(con.getId() == Integer.parseInt(conId)) {
//						System.out.println(con.getId() + " " + conId);
						bcc.add(con);
					}
				}
			}
		}catch(Exception ex) {
			
		}
		
//-------------------
		String dateTime="", subject="", content="";
		try {
			dateTime = strSplit[4];
			subject = strSplit[5];
			content = strSplit[6];
			
		}catch(Exception ex) {
			dateTime = "";
			subject = "";
			content = "";
		}

		
//------------------------
		try {
			String[] tagsSplit = strSplit[7].split(".");
			for(String tagString : tagsSplit) {
				Tag newTag = new Tag();
				newTag.setId(hashCode());
				newTag.setName(tagString);
				tags.add(newTag);
			}
		}catch(Exception ex) {
			
		}
		
		
//---------------------
		try {
			String[] attachmentsSplit = strSplit[8].split(".");
			ArrayList<Integer> attachmentsIdList = new ArrayList<>();
			for(String str : attachmentsSplit) {
				attachmentsIdList.add(Integer.parseInt(str));
			}
			for(String attString : attachmentsSplit) {
				String[] attSplit = attString.split("|");
				
				Attachment att = new Attachment();
				att.setId(hashCode());
				att.setData(attachmentsSplit[0]);
				att.setType(attachmentsSplit[1]);
				att.setName(attachmentsSplit[2]);
				attachments.add(att);
			}
		}catch(Exception ex) {
			
		}
		
//-------------------------
		try {
			int folderId = Integer.parseInt(strSplit[9]);
			for(Folder fol : allfolders) {
				if(fol.getId() == folderId) {
					try {
						folder = (Folder)fol.clone();
					}catch(CloneNotSupportedException c){} 
					
				}
			}
		}catch(Exception ex) {
			folder = new Folder();
		}
		
//----------------------
		try {
			int accountId = Integer.parseInt(strSplit[10].substring(0, strSplit[10].length() - 1));
			for(Account acc : accounts) {
				if(acc.getId() == accountId) {
					try {
						account = (Account)acc.clone();
					}catch(CloneNotSupportedException c){} 
					
				}
			}
		}catch(Exception ex) {
			account = new Account();
		}
		
//--------------------------

		read = false;
				
		Message newMessage = new Message();
		newMessage.setId(id);
		newMessage.setFrom(from);
		newMessage.setTo(to);
		newMessage.setCc(cc);
		newMessage.setBcc(bcc);
		newMessage.setDateTime(dateTime);
		newMessage.setSubject(subject);
		newMessage.setContent(content);
		newMessage.setTag(tags);
		newMessage.setAttachments(attachments);
		newMessage.setFolder(folder);
		newMessage.setAccount(account);
		newMessage.setMessageRead(read);
		
		
		
		drafts.addMessage(newMessage);
		
		return newMessage;
	}
}
