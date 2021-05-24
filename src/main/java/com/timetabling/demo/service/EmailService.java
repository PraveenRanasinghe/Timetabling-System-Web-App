package com.timetabling.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

@Service
public class EmailService {

    private final String companyEmail="timetabler4@gmail.com";
    private final String password="timetabler@12345";
    private final String Host = "smtp.gmail.com";
    private Properties property;
    private Session session;
    private Authenticator theAuthenticator;

    private static EmailService theEmail= new EmailService();

    public void Email(String recepientEmail){
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", false);
            prop.put("mail.smtp.starttls.enable", "false");
            prop.put("mail.smtp.host", "localhost");
            prop.put("mail.smtp.port", "2500");
//            prop.put("mail.smtp.ssl.trust", "localhost");



            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
            message.setSubject("Successfully Registered!");

            String msg = "You have been registered in Our Collage successfully!";
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);

        }
        catch (Exception ex){
            System.out.println("");
        }
    }


}
