package com.example.aptivist.aptivistapp.service.impl;

import com.example.aptivist.aptivistapp.dao.CandidateDao;
import com.example.aptivist.aptivistapp.dto.CandidateDto;
import com.example.aptivist.aptivistapp.dto.mapper.CandidateMapper;
import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    private CandidateDao candidateDao;


    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public CandidateDto saveCandidate(CandidateDto candidate) {

        Candidate candidateToSave = null;
        candidateToSave = candidateMapper.toCandidate(candidate);
        candidateDao.save(candidateToSave);

        return candidate;
    }

    @Override
    public CandidateDto getCandidateByFirstAndLastName(String firstName, String lastName) {
        Candidate cand = candidateDao.getCandidateByFirstAndLastName(firstName, lastName);
        return candidateMapper.toCandidateDto(cand);
    }

    @Override
    public List<CandidateDto> getCandidateByTechnology(String technology) {
        List<CandidateDto> cands = new ArrayList<>();
        List<Candidate> result = candidateDao.getCandidateByTechnology(technology);
        if(result != null) {
            for (Candidate c: result){
                cands.add(candidateMapper.toCandidateDto(c));
            }
        }

        return cands;
    }
}
