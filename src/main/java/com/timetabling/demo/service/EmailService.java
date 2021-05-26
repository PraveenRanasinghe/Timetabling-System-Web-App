package com.timetabling.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class EmailService {

    private final String companyEmail = "timetabler4@gmail.com";
    private final String password = "timetabler@12345";
    private final String Host = "smtp.gmail.com";
    private Properties property;
    private Session session;
    private Authenticator theAuthenticator;
    Properties prop;

    private static EmailService theEmail = new EmailService();

    public EmailService() {
        prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");


        theAuthenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(companyEmail, password);
            }
        };

        session = Session.getDefaultInstance(prop, theAuthenticator);
    }

    public void Email(String recepientEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
            message.setSubject("Successfully Registered!");

            String msg = "You have been registered in Our College successfully!";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }

}
