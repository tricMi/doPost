package com.example.postDo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.dto.AttachmentDTO;
import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.MessageDTO;
import com.example.postDo.dto.TagDTO;
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Format;
import com.example.postDo.entity.Tag;
import com.example.postDo.entity.User;
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.MessageServiceInterface;
import com.example.postDo.service.TagServiceInterface;
import com.example.postDo.service.UserService;



@RestController
@RequestMapping(value = "api/javaMail")
public class JavaMail {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountServiceInterface accountsService;
	
	
	@Autowired
	private ContactServiceInterface contactsService;
	
	@Autowired
	private MessageServiceInterface messageService;
	
	@Autowired
	private FolderServiceInterface folderService;
	
	@Autowired
	private TagServiceInterface tagService;
	
	public Properties propvals = new Properties();
	public Session emailSessionObj = null;
	
	
	public JavaMail() {
		
		
		String hostval = "pop.gmail.com";
	    String mailStrProt = "pop3";
	    String host ="smtp.gmail.com" ;
		
//		Properties propvals = new Properties();
	    propvals.put("mail.pop3.host", hostval);
	    propvals.put("mail.pop3.port", "995");
	    propvals.put("mail.pop3.starttls.enable", "true");
	    propvals.put("mail.smtp.starttls.enable", "true");
	    propvals.put("mail.smtp.host", host);
	    propvals.put("mail.smtp.port", "587");
	    propvals.put("mail.smtp.auth", "true");
	    propvals.put("mail.smtp.starttls.required", "true");
	    
	    emailSessionObj = Session.getDefaultInstance(propvals);  
	    
	}
	
	
	

	@PostMapping(value = "/check")
	public void check(@RequestBody AccountDTO account) {
		
		System.out.println("Starting check");
		
			//Set mail properties and configure accordingly
		      String hostval = "pop.gmail.com";
		      String mailStrProt = "pop3";
//		      String uname = "dopost123@gmail.com";
//		      String pwd = "sfdopost2019";
		     
		      
		      String uname = account.getUsername();
		      String pwd = account.getPassword();
		      List<Account> allAccounts = accountsService.findAll();
	     
	      
	    // Calling checkMail method to check received emails
	      checkMail(hostval, mailStrProt, uname, pwd, allAccounts);
	      System.out.println("Check ended");
	   }
	
	public static String toUTC(Date date) {
		  TimeZone tz = TimeZone.getTimeZone("UTC");
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		  df.setTimeZone(tz);
		  return df.format(date);
		}
	
	   public void checkMail(String hostval, String mailStrProt, String uname,String pwd, List<Account> allAccounts) 
	   {
		   
	      try {
	      //Set property values
	      Properties propvals = new Properties();
	      propvals.put("mail.pop3.host", hostval);
	      propvals.put("mail.pop3.port", "995");
	      propvals.put("mail.pop3.starttls.enable", "true");
//	      propvals.put("mail.pop3.timeout", 10000);
	      
	      
	      
//	      Session emailSessionObj = Session.getDefaultInstance(propvals);  
	      
	      //Create POP3 store object and connect with the server
	      Store storeObj = emailSessionObj.getStore("pop3s");
	      storeObj.connect(hostval, uname, pwd);
	      
	      
	      //Create folder object and open it in read-only mode
	      Folder emailFolderObj = storeObj.getFolder("INBOX");
	      emailFolderObj.open(Folder.READ_ONLY);
	      //Fetch messages from the folder and print in a loop
	      Message[] messageobjs = emailFolderObj.getMessages(); 
	      

	      

	      
	      
	      
	      
	      ArrayList<AccountDTO> accounts = new ArrayList<>();
	      
//	      System.out.println("Length is " + messageobjs.length);
	      
	      for (int i = 0, n = messageobjs.length; i < n; i++) {
	         Message javaMailMsg = messageobjs[i];
	         
	         com.example.postDo.entity.Message msg = new com.example.postDo.entity.Message();
	         
	         String temp = javaMailMsg.getFrom().toString();
	         
//	         List<Account> allAccounts = accountService.findAll();

	         
	         for(Account acc : allAccounts) {
	        	 if(javaMailMsg.getFrom().equals(acc.getUsername())) {
	        		 msg.setAccount(acc);
	        	 }
	         }

	         
//	         msg.setId(hashCode());
	         
	         Set<Tag> tempTags = new HashSet<>();
	         String tagsString = javaMailMsg.getDescription();
	         System.out.println("Tag stringcina: " + tagsString);
	         if(tagsString != null) {
	        	 String[] splitTagsString = tagsString.split("\\|");
		         for(String tagString : splitTagsString) {
		        	 Tag tag = new Tag();
//		        	 tag.setId(hashCode());
		        	 tag.setName(tagString);
		       
		        	 tempTags.add(tag);
		         }
		         msg.setTags(tempTags);
	         }
	         
	         
	         
	         String wholeFrom = InternetAddress.toString(javaMailMsg.getFrom());
	         String realFrom = "";
	         try {
	        	 String[] splitFrom = wholeFrom.split(" ");
		         realFrom = splitFrom[2].substring(1, splitFrom[2].length()-1);
	         }catch(Exception ex) {
	        	 realFrom = wholeFrom;
	         }
	         
	         
	         
	         Contact tempContact1 = new Contact();
	         tempContact1.setEmail(realFrom);
	         tempContact1.setFirstName("Unknown");
	         tempContact1.setLastName("Unknown");
	         tempContact1.setDisplay("Unknown");
	         tempContact1.setFormat(Format.HTML);
	         
	         
	         
	         
	         msg.setFrom(tempContact1);
	         
	         for(User user : userService.findAll()) {
        		 for(Account acc : user.getAccounts()) {
        			 if(acc.getUsername().equals(msg.getFrom().getEmail())) {
        				tempContact1.setUser(user);
        				for(com.example.postDo.entity.Folder fol : folderService.findAll()) {
        					if(fol.getName().equals("INBOX")) {
        						msg.setFolder(fol);
        					}
        				}
        			 }
        			 
        		 }
        	 }
	         
	         if(javaMailMsg.getRecipients(Message.RecipientType.TO) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.TO)).split(", ");
	         		for(String str : stringAdr) {
	         			tempContact1.setEmail(str);
	         			msg.addTo(tempContact1);
	         		}
	         }
	         
	         Account tempAcc = new Account();
	         
	         for(Account acc : accountsService.findAll()) {
	        	 if(acc.getUsername().equals(msg.getFrom().getEmail())) {
	        		 tempAcc = acc;
	        	 }
	         }
	         
	         msg.setAccount(tempAcc);
	         
	         if(javaMailMsg.getRecipients(Message.RecipientType.CC) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.CC)).split(", ");
	         		for(String str : stringAdr) {
	         			tempContact1.setEmail(str);
	         			msg.addCc(tempContact1);
	         		}
	         }
	         if(javaMailMsg.getRecipients(Message.RecipientType.BCC) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.BCC)).split(", ");
	         		for(String str : stringAdr) {
	         			tempContact1.setEmail(str);
	         			msg.addBcc(tempContact1);
	         		}
	         }
	         String utcDate = toUTC(javaMailMsg.getSentDate());
	         msg.setDateTime(utcDate);
	         msg.setSubject(javaMailMsg.getSubject());
	         System.out.println("Almost done");
	         String realContent = "";
	         
	         Object obj = javaMailMsg.getContent();

	         try {
	        	 Multipart mp = (Multipart) javaMailMsg.getContent();
		         
		         for(int j=0;i<mp.getCount();i++) {
		        	    BodyPart bodyPart = mp.getBodyPart(j);
		        	    if (bodyPart.isMimeType("text/*")) {
		        	    	realContent = (String) bodyPart.getContent();
		        	    }
		        	    
		        }
		         msg.setContent(realContent);
	         }catch(Exception ex) {
	        	 realContent = javaMailMsg.getContent().toString();
	         }
	         if(msg.getContent() == null) {
	        	 msg.setContent(javaMailMsg.getContent().toString());
	         }
	         
	         
	         boolean alreadyAdded = false;
	         for(com.example.postDo.entity.Message messy : messageService.findAll()) {
	        	 if(msg.getSubject().equals(messy.getSubject()) && msg.getFrom().equals(messy.getFrom())) {
	        		 alreadyAdded = true;
	        	 }
	         }
	         
	         if(alreadyAdded == false) {
	        	 messageService.save(msg);
	        	 
	        	 for(User user : userService.findAll()) {
	        		 for(Account acc : user.getAccounts()) {
	        			 if(acc.getUsername().equals(msg.getFrom().getEmail())) {
	        				 acc.addMessage(msg);
	        			 }
	        		 }
	        	 }
	        	 
	        	 for(Tag tag : msg.getTags()) {
	        		 System.out.println("Tag: " + tag.getName());
	        		 tag.setMessage(msg);
	        		 tagService.save(tag);
	        	 }
	         }
	      }
	      if(emailFolderObj.isOpen()) {
	        	 emailFolderObj.close(true);
	         }
	         if(storeObj.isConnected()) {
	        	 storeObj.close();
	         }
	      //Now close all the objects
	      
	      } catch (NoSuchProviderException exp) {
	         exp.printStackTrace();
	      } catch (MessagingException exp) {
	         exp.printStackTrace();
	      } catch (Exception exp) {
	         exp.printStackTrace();
	      }
//	      finally {
//	    	  return null;
//	      }
	      
	   }
	   
	   
	   
	   
	   @PostMapping(value = "/send", consumes="application/json")
		public ResponseEntity<?> send(@RequestBody MessageDTO mes){
			
		   System.out.println("Sending message");
//			System.out.println("message " + mes.getContent());
			
	        try{
//	            String host ="smtp.gmail.com" ;
//	            String user = "dopost123@gmail.com";
//	            String pass = "sfdopost2019";
//	            String to = "dopost123@gmail.com";
//	            String from = "dopost123@gmail.com";
//	            String subject = "This is stuff.";
//	            String messageText = "Your Is Test Email :";
	        	
	        	String user = "";
	            String pass = "";
	            
	            
	        	for(Account acc : accountsService.findAll()) {
	        		if(acc.getUsername().equals(mes.getFrom().getEmail())) {
	        			
	        			user = acc.getUsername();
	        			pass = acc.getPassword();
	        		}
	        	}
	        	String host ="smtp.gmail.com" ;
	            
	            ArrayList<ContactDTO> to = mes.getTo();
	            ArrayList<ContactDTO> cc = mes.getCc();
	            ArrayList<ContactDTO> bcc = mes.getBcc();
	            ArrayList<TagDTO> tags = mes.getTag();
	            ArrayList<AttachmentDTO> attachments = mes.getAttachments();
	            String from = mes.getFrom().getEmail();
	            String messageText = mes.getContent();
	            String subject = mes.getSubject();
	            
	            
	            
	            
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

//	            props.put("mail.smtp.starttls.enable", "true");
//	            props.put("mail.smtp.host", host);
//	            props.put("mail.smtp.port", "587");
//	            props.put("mail.smtp.auth", "true");
//	            props.put("mail.smtp.starttls.required", "true");
//	            props.put("mail.smtp.timeout", 10000);
//	            props.put("mail.smtp.connectiontimeout", "2000");
	            
//	            message.addRecipient(Message.RecipientType.CC, InternetAddress.parse("abc@abc.com"));
	            
//	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//	            Session mailSession = Session.getDefaultInstance(props, null);
	            
	            emailSessionObj.setDebug(sessionDebug);
	            Message msg = new MimeMessage(emailSessionObj);
	            msg.setFrom(new InternetAddress(from));
	            msg.setSentDate(new Date());
	            
	            String allTags = "";
	            for(TagDTO tag : mes.getTag()) {
	            	allTags += tag.getName() + "|";
	            }
	            
	            msg.setDescription(allTags);
	            
	            for(ContactDTO con : to) {
	            	String toTemp = con.getEmail();
	            	InternetAddress[] address = {new InternetAddress(toTemp)};
	                msg.setRecipients(Message.RecipientType.TO, address);
	                msg.setSubject(subject); 
	                msg.setSentDate(new Date());
	                msg.setText(messageText);

	               Transport transport=emailSessionObj.getTransport("smtp");
	               transport.connect(host, user, pass);
	               
	               transport.sendMessage(msg, msg.getAllRecipients());
	               transport.close();
	            }
	            for(ContactDTO con : cc) {
	            	String ccTemp = con.getEmail();
	            	InternetAddress[] address = {new InternetAddress(ccTemp)};
	                msg.setRecipients(Message.RecipientType.CC, address);
	                msg.setSubject(subject); 
	                msg.setSentDate(new Date());
	                msg.setText(messageText);

	               Transport transport=emailSessionObj.getTransport("smtp");
	               transport.connect(host, user, pass);
	               
	               transport.sendMessage(msg, msg.getAllRecipients());
	               transport.close();
	            }
	            for(ContactDTO con : bcc) {
	            	String bccTemp = con.getEmail();
	            	InternetAddress[] address = {new InternetAddress(bccTemp)};
	                msg.setRecipients(Message.RecipientType.BCC, address);
	                msg.setSubject(subject); 
	                msg.setSentDate(new Date());
	                msg.setText(messageText);

	               Transport transport=emailSessionObj.getTransport("smtp");
	               transport.connect(host, user, pass);
	               
	               transport.sendMessage(msg, msg.getAllRecipients());
	               transport.close();
	            }
	            
	           
//	           System.out.println(msg.getContent() + "from send");
	           System.out.println("messages sent successfully");
	           
	           return new ResponseEntity(HttpStatus.OK);
	        }catch(Exception ex)
	        {
	            System.out.println(ex);
	            return null;
	        }

	    }
	   
	   
}


