package com.example.aptivist.aptivistapp.service;


import com.example.aptivist.aptivistapp.model.Candidate;

import java.io.Serializable;

public interface SendEmailService extends Serializable {

    String sendInvitationEmail(Candidate candidate);
}
