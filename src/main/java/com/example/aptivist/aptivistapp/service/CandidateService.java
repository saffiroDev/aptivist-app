package com.example.aptivist.aptivistapp.service;

import com.example.aptivist.aptivistapp.dto.CandidateDto;
import com.example.aptivist.aptivistapp.model.Candidate;

import java.io.Serializable;
import java.util.List;

public interface CandidateService extends Serializable  {


    CandidateDto saveCandidate(CandidateDto candidate);

    CandidateDto getCandidateByFirstAndLastName(String firstName, String lastName);

    List<CandidateDto> getCandidateByTechnology(String technology);


}
