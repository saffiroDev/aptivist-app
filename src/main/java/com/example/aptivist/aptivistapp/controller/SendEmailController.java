package com.example.aptivist.aptivistapp.controller;


import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SendEmailController {


    @Autowired
    private SendEmailService sendEmailService;



    @GetMapping("/recruitment/send/invitation/{candidate}")
    public void sendInvitationEmail(@PathVariable String candidate) {

        Candidate c = new Candidate();
        c.setFirstName(candidate);
        sendEmailService.sendInvitationEmail(c);
        System.out.println("Correo enviado correctamente...");
    }




}
