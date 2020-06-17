package com.example.aptivist.aptivistapp.dao;

import com.example.aptivist.aptivistapp.model.Candidate;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CandidateDao extends Dao<Candidate> {


    Candidate getCandidateByFirstAndLastName(String firstName, String lastName);


    List<Candidate> getCandidateByTechnology(String technology);





}
