package com.example.postDo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.AccountDTO;
import com.example.postDo.dto.AttachmentDTO;
import com.example.postDo.dto.ContactDTO;
import com.example.postDo.dto.MessageDTO;
import com.example.postDo.dto.TagDTO;



public class JavaMail {

	public Properties propvals = new Properties();
	public Session emailSessionObj = null;
	
	
	public CheckEmail() {
		
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
	
	
	
//	@RequestMapping(value = "check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void check(AccountDTO account) {
		
			//Set mail properties and configure accordingly
		      String hostval = "pop.gmail.com";
		      String mailStrProt = "pop3";
//		      String uname = "dopost123@gmail.com";
//		      String pwd = "sfdopost2019";
		     
		      
		      String uname = account.getUsername();
		      String pwd = account.getPassword();
		
	     
	      
	    // Calling checkMail method to check received emails
	      checkMail(hostval, mailStrProt, uname, pwd);
	   }
	
		
	
	   public void checkMail(String hostval, String mailStrProt, String uname,String pwd) 
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
	      
	      
	      
	 
	      
	      
	      for (int i = 0, n = messageobjs.length; i < n; i++) {
	         Message javaMailMsg = messageobjs[i];
	         
	         MessageDTO msg = new MessageDTO();
	         
	         String temp = javaMailMsg.getFrom().toString();
	         
	         for(AccountDTO acc : MessageController.getAccounts()) {
	        	 if(javaMailMsg.getFrom().equals(acc.getUsername())) {
	        		 msg.setAccount(acc);
	        	 }
	         }
	         
	         msg.setId(Long.valueOf(hashCode()));
	         if(javaMailMsg.getDescription() != null) {
	        	 ArrayList<TagDTO> tempTags = new ArrayList<>();
		         
		         String tagsString = javaMailMsg.getDescription();
		         
//		         System.out.println("1 " + tagsString.substring(0, tagsString.length()-1));
		         
//		         String[] splitTagsString = tagsString.substring(0, tagsString.length()-1).split("|");
		         
		         String[] splitTagsString = tagsString.split("\\|");
		         
		         
		         for(String tagString : splitTagsString) {
		        	 System.out.println("2 " + tagString);
		        	 TagDTO tag = new TagDTO();
		        	 tag.setId(Long.valueOf(hashCode()));
		        	 tag.setName(tagString);
		        	 tempTags.add(tag);
		         }
		         msg.setTag(tempTags);
	         }
	         
	         
	         String wholeFrom = InternetAddress.toString(javaMailMsg.getFrom());
	         String realFrom = "";
	         try {
	        	 String[] splitFrom = wholeFrom.split(" ");
		         realFrom = splitFrom[2].substring(1, splitFrom[2].length()-1);
	         }catch(Exception ex) {
	        	 realFrom = wholeFrom;
	         }
	         
	         ContactDTO contactFrom = new ContactDTO();
	         contactFrom.setEmail(realFrom);
	         msg.setFrom(contactFrom);
	         if(javaMailMsg.getRecipients(Message.RecipientType.TO) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.TO)).split(", ");
	         		for(String str : stringAdr) {
//	         			System.out.println(str);
	         			ContactDTO contactTo = new ContactDTO();
	         			contactTo.setEmail(str);
	         			msg.addTo(contactTo);
	         		}
	         }
	         if(javaMailMsg.getRecipients(Message.RecipientType.CC) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.CC)).split(", ");
	         		for(String str : stringAdr) {
//	         			System.out.println(str);
	         			ContactDTO contactCc = new ContactDTO();
	         			contactCc.setEmail(str);
	         			msg.addCc(contactCc);
	         		}
	         }
	         if(javaMailMsg.getRecipients(Message.RecipientType.BCC) != null) {
	         		String[] stringAdr = InternetAddress.toString(javaMailMsg.getRecipients(Message.RecipientType.BCC)).split(", ");
	         		for(String str : stringAdr) {
	         			ContactDTO contactBcc = new ContactDTO();
	         			contactBcc.setEmail(str);
	         			msg.addBcc(contactBcc);
	         		}
	         }
	         String utcDate = MessageController.toUTC(javaMailMsg.getSentDate());
	         msg.setDateTime(utcDate);
	         msg.setSubject(javaMailMsg.getSubject());
	         
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
	         for(MessageDTO messy : MessageController.getMessages()) {
	        	 if(msg.getSubject().equals(messy.getSubject()) && msg.getFrom().equals(messy.getFrom())) {
	        		 alreadyAdded = true;
	        	 }
	         }
	         
//	         System.out.println(msg.getContent() + " from check");
	         
	         if(alreadyAdded == false) {
	        	 MessageController.addNewMessage(msg);
	         }
	         
	         
	         
	         
	         
//	         System.out.println("My message: " + msg.getSubject() + ", " + realContent + ", " + msg.getDateTime() + ", " + msg.getFrom() + ", " + msg.getTo().get(0));
	 
	      }
//	      emailFolderObj.close(true);
//	      storeObj.close();
	      
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
	   
	   
	   
	   
	   
	   
	   
	   
	   @RequestMapping(value = "send",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public MessageDTO send(@RequestBody MessageDTO mes){
			
			System.out.println("send pozvan");
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
	            
	            
	        	for(AccountDTO acc : MessageController.getAccounts()) {
	        		if(acc.getUsername().equals(mes.getFrom())) {
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
	            ContactDTO from = mes.getFrom();
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
	            msg.setFrom(new InternetAddress(from.getEmail()));
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
	           return mes;
	        }catch(Exception ex)
	        {
	            System.out.println(ex);
	            return null;
	        }

	    }
	
}
