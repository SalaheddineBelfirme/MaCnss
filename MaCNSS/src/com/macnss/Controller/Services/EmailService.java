package com.macnss.Controller.Services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;



public class EmailService {
    public static void sendEmail(String body,String subject ,String email) {
        final String username = System.getenv("MACNSS_EMAIL"); // environment variable
        final String password = System.getenv("MACNSS_PASSWORD"); // environment variable
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Email send successfully");
        } catch (MessagingException e) {
            System.out.println("something went wrong while sending email to client");
            e.printStackTrace();
        }
    }
}
