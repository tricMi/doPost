/*
package com.example.postDo.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
 
import com.example.postDo.entity.Account;
import com.example.postDo.entity.Contact;
import com.example.postDo.entity.Message;
import com.example.postDo.entity.Attachment;
import com.example.postDo.entity.Tag;
//import com.example.postDo.helper.Helper;
import com.example.postDo.service.*;
import org.apache.tomcat.util.codec.binary.Base64;

public class JavaMailApi {
	 
    private final String TMP_PATH = Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResource(""))
            .getPath().substring(1)
            + ".." + File.separator
            + ".." + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "tmp" + File.separator;
 
    private final MessageServiceInterface messageService;
    private final ContactServiceInterface contactService;
    private final FolderServiceInterface folderService;
    private final TagServiceInterface tagService;
    private final AttachmentServiceInterface attachmentService;
 
    public JavaMailApi(MessageServiceInterface messageService,
                   ContactServiceInterface contactService,
                   FolderServiceInterface folderService,
                   TagServiceInterface tagService,
                   AttachmentServiceInterface attachmentService) {
        this.messageService = messageService;
        this.contactService = contactService;
        this.folderService = folderService;
        this.tagService = tagService;
        this.attachmentService = attachmentService;
    }
 
 
    public void sendEmail(Message message) {
 
        //Declare to
        StringBuilder builder = new StringBuilder();
        for (Contact t : message.getTo()) {
            builder.append(t.getEmail());
            builder.append(",");
        }
        String EMAIL_TO = builder.toString();
 
        //Declare cc
        builder.setLength(0);
        for (Contact t : message.getCc()) {
            builder.append(t.getEmail());
            builder.append(",");
        }
        String EMAIL_CC = builder.toString();
 
        //Declare bcc
        builder.setLength(0);
        for (Contact t : message.getBcc()) {
            builder.append(t.getEmail());
            builder.append(",");
        }
        String EMAIL_BCC = builder.toString();
 
        //Declare sender
        String EMAIL_FROM = message.getFrom().getEmail();
 
        //Mention user name and password as per your configuration
        final String username = message.getAccount().getUsername();
        final String password = message.getAccount().getPassword();
 
        //Set properties and their values
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        prop.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        prop.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "465"); //SMTP Port
        prop.put("mail.smtp.ssl.enable", "true");
 
        //Create a Session object & authenticate uid and pwd
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            //Create MimeMessage object & set values
            MimeMessage messageObj = new MimeMessage(session);
 
 
            messageObj.setFrom(new InternetAddress(EMAIL_FROM));
            messageObj.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
            messageObj.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(EMAIL_CC));
            messageObj.setRecipients(javax.mail.Message.RecipientType.BCC, InternetAddress.parse(EMAIL_BCC));
            messageObj.setSubject(message.getSubject());
 
            builder.setLength(0);
            for (Tag tag : message.getTags()
            ) {
                builder.append(tag.getName());
            }
            String messageContent = builder.toString();
            Multipart mp = new MimeMultipart();
            BodyPart messageBody = new MimeBodyPart();
 
            for (Attachment attachment : message.getAttachments()) {
                MimeBodyPart mbp2 = new MimeBodyPart();
//                mbp2.setContent(attachment.getBase64(), "image/*");
                mbp2.setFileName(attachment.getName());
                mp.addBodyPart(mbp2);
            }
 
            messageBody.setText(messageContent);
            mp.addBodyPart(messageBody);
            messageObj.setContent(mp);
            Transport.send(messageObj);
            contactService.save(message.getFrom());
            for (Tag tag : message.getTags()
            ) {
                tagService.save(tag);
            }
            message = messageService.save(message);
            for (Attachment attachment : message.getAttachments()
            ) {
                attachment.setMessage(message);
                attachmentService.save(attachment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void loadEmails(Account account) {
        try {
 
            Properties prop = new Properties();
            prop.put("mail.imap.host", "imap.gmail.com");
            prop.put("mail.imap.port", "993");
            prop.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.imap.socketFactory.fallback", "false");
            prop.setProperty("mail.imap.socketFactory.port", "993");
            Session session = Session.getDefaultInstance(prop, null);
            Store store = session.getStore("imaps");
            store.connect("imap.googlemail.com", 993, account.getUsername(), account.getPassword());
            Folder emailFolder = store.getFolder("inbox");
            emailFolder.open(Folder.READ_ONLY);
            javax.mail.Message[] messages = emailFolder.getMessages();
//            Date lastDate = messageService.findLastDate();
 
            for (javax.mail.Message message : messages) {
//                if (message.getSentDate().after(lastDate)) {
                    Message temp = new Message();
//                    Contact tempContact = new Contact(message.getFrom()[0].toString());
//                    tempContact = contactService.save(tempContact);
//                    temp.setFrom(tempContact);
//                    Set<Contact> tempContatsSet = Helper.fromAddressestoContacts(message.getReplyTo());
                    Set<Contact> tempContacts = new HashSet<>();
//                    for (Contact c : tempContatsSet)
                     {
//                        tempContacts.add(contactService.save(c));
                    }
                    temp.setTo(tempContacts);
                    temp.setCc(new HashSet<>());
                    temp.setBcc(new HashSet<>());
//                    temp.setDateTime(message.getSentDate());
                    temp.setSubject(message.getSubject());
                    temp.setAttachments(new HashSet<>());
                    String result = "";
                    try {
                        MimeMultipart body = (MimeMultipart) message.getContent();
                        for (int j = 0; j < body.getCount(); j++) {
                            MimeBodyPart bodyPart = (MimeBodyPart) body.getBodyPart(j);
                            if (bodyPart.isMimeType("text/plain")) {
                                result += "\n" + bodyPart.getContent();
                                break; // without break same text appears twice in my tests
                            } else if (bodyPart.isMimeType("text/html")) {
                                result = (String) bodyPart.getContent();
                            }
                            if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                                String fileName = bodyPart.getFileName();
                                bodyPart.saveFile(TMP_PATH + File.separator + fileName);
                                byte[] bFile = Files.readAllBytes(new File(TMP_PATH + fileName).toPath());
                                String sFile = Base64.encodeBase64String(bFile);
                                Attachment attachment = new Attachment();
                                attachment.setName(fileName);
//                                attachment.setBase64(sFile);
                                attachment.setMessage(temp);
                                attachment.setType("image/*");
                                System.out.println(attachment.getName());
                                temp.getAttachments().add(attachment);
                            }
                        }
 
                    } catch (Exception e) {
                        result = message.getContent().toString();
                    }
                    temp.setContent(result);
                    temp.setTags(new HashSet<>());
//                    temp.setFolder(folderService.findOne(2));
                    temp.setAccount(account);
//                    temp.setRead(false);
                    messageService.save(temp);
                }
//            }
//            emailFolder.close(false);
//            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
*/