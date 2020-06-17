package com.example.aptivist.aptivistapp.controller;


import com.example.aptivist.aptivistapp.dto.CandidateDto;
import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.*;

import java.util.List;


@RestController
public class CandidateController {


    @Autowired
    CandidateService candidateService;



    @PostMapping("/data/candidates")
    public void saveCandidate(@RequestBody CandidateDto candidate) {

        CandidateDto cand = candidateService.saveCandidate(candidate);
        if (cand != null) {
            new ResponseEntity<>(cand, HttpStatus.OK);
        }else {
            new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }


    @GetMapping("/data/candidates/technology/{technology}")
    public List<CandidateDto> retrieveCandidateByTechnology(@PathVariable String technology) {
        List<CandidateDto> candidates = candidateService.getCandidateByTechnology(technology);
        if (candidates != null) {
            new ResponseEntity<>(candidates, HttpStatus.OK);
        } else {
            new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return candidates;

    }

}
