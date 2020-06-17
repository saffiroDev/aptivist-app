package com.example.aptivist.aptivistapp.dto.mapper;

import com.example.aptivist.aptivistapp.dto.CandidateDto;
import com.example.aptivist.aptivistapp.model.Candidate;
import org.springframework.stereotype.Component;


@Component
public class CandidateMapper {


    public static CandidateDto toCandidateDto(Candidate candidate) {
        CandidateDto candDto = new CandidateDto();
        candDto.setFirstName(candidate.getFirstName());
        candDto.setLastName(candidate.getLastName());
        candDto.setTechnology(candidate.getEmail());
        candDto.setPhoneNumber(candidate.getPhoneNumber());
        candDto.setDob(candidate.getDob());
        candDto.setStatus(candidate.getStatus());
        return candDto;
    }


    public static Candidate toCandidate(CandidateDto candidate) {
        Candidate cand = new Candidate();
        cand.setFirstName(candidate.getFirstName());
        cand.setLastName(candidate.getLastName());
        cand.setTechnology(candidate.getEmail());
        cand.setPhoneNumber(candidate.getPhoneNumber());
        cand.setDob(candidate.getDob());
        cand.setStatus(candidate.getStatus());
        return cand;
    }
}
