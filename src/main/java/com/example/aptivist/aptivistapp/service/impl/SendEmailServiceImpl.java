package com.example.aptivist.aptivistapp.service.impl;

import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.service.SendEmailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    Properties properties = System.getProperties();




    @Override
    public String sendInvitationEmail(Candidate candidate) {

        // Recipient's email ID needs to be mentioned.
        String to = "jesus.lp.ag@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "jesussaffiro@gmail.com";


        //  sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("jesus.lp.ag@gmail.com", "34343");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);



        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // Set From: header field of the header.
        try {

            message.setFrom(new InternetAddress(from));


            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

           // Now set the actual message
           message.setText("This is actual message");

           System.out.println("sending...");

           // Send message
           Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }




        return "Mensaje Enviado";
    }



}
