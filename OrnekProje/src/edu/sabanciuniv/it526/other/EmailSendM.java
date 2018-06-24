package edu.sabanciuniv.it526.other;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


public class EmailSendM {

    public void sendEmail(String inviteeEmails, String name, String lastName, String eventName, String eventCode){
        try{
        	
        	String[] emails = inviteeEmails.split("\n");
        	
        	for (String email : emails) {
        		
        		email = email.trim();
        		
        		String host ="smtpout.secureserver.net" ;
                String user = "ayben.erdogan@arinnas.com";
                String pass = "vertigo8$";
                String to = email;
                String from = name + " " + lastName +" <ayben.erdogan@arinnas.com>";
                String subject = "Gift Registry Invite From " + name + " " + lastName;
                String messageText = "You are invited to my "+ eventName + " event. \n"
                		+ "Please go to www.giftregistry.com and join my event by using this code: " + eventCode + "\n Thank you!";
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "80");
                //props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                //props.put("mail.smtp.starttls.required", "true");
                props.put("mail.smtp.starttls.required", "false");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject); msg.setSentDate(new Date());
                msg.setText(messageText);
                

               Transport transport=mailSession.getTransport("smtp");
               transport.connect(host, user, pass);
               transport.sendMessage(msg, msg.getAllRecipients());
               transport.close();
               System.out.println("message send successfully");
			}
        	
            /*String host ="smtp.gmail.com" ;
            String user = "onur.gw2@gmail.com";
            String pass = "onko174.";
            String to = inviteeEmail;
            String from = "onur.gw2@gmail.com";
            String subject = "Gift Registry Invite From " + name + " " + lastName;
            String messageText = "You are invited to my "+ eventName + " event. \n"
            		+ "Please go to www.giftregistry.com and join my event by using this code: " + eventCode + "\n Thank you!";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");*/
        	
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
