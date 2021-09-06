package com.timetabling.demo.service;

import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
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
        prop.put("mail.smtp.host", Host);
        prop.put("mail.smtp.port", "587");
        prop.put(" mail.smtp.ssl.protocols","TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        theAuthenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(companyEmail, password);
            }
        };

        session = Session.getDefaultInstance(prop, theAuthenticator);
    }

    public void EmailToStudents(String recepientEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
            message.setSubject("----------" +
                    "Enrolled Successfully!" +
                    "----------");

            String msg = "Dear Student,<br/><br/>" +

                    "You have been registered in Our College successfully!.<br/>" +
                    "Now you have the access to Timetable portal.<br/>" +
                    "Now you can find your weekly timetable there.<br/>" +
                    "Your default password would be 'User1234'.<br/>" +
                    "----------------------------------------------------------------<br/><br/>" +
                    "Best Regards,<br/>" +
                    "System Admin.";

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

    public void EmailToLecturers(String recepientEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
            message.setSubject("Thanking for Joining Us!");

            String msg = "Dear Lecturer, <br/><br/>" +

                    "You have been successfully registered in our Timetabling Portal." +
                    "Now you have the access to Timetable portal.<br/>" +
                    "Now you can find your weekly timetable there.<br/>" +
                    "Your default password would be 'Lecturer1234'.<br/>" +
                    "---------------------------------------------------------------- <br/><br/>" +
                    "Thanking You,<br/>" +
                    "System Admin.";
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

    public void EmailToLecWhenModuleIsAssigned(String recepientEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
            message.setSubject("Assigned to a Module");

            String msg = "Dear Lecturer, <br/><br/>" +

                    "You have been assigned to teach a module to our students." +
                    "Please check your Account for more Information!"+
                    "---------------------------------------------------------------- <br/><br/>" +
                    "Thanking You,<br/>" +
                    "System Admin.";
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
