package com.example.aptivist.aptivistapp.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.aptivist.aptivistapp.dao.CandidateDao;
import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CandidateDaoImpl implements CandidateDao {


    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public CandidateDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    @Override
    public Candidate get(String id) {


        return null;
    }


    @Override
    public Candidate save(Candidate candidate) {
        dynamoDBMapper.save(candidate);
        return candidate;

    }

    @Override
    public Candidate update(Candidate candidate, String[] params) {
        return null;

    }

    @Override
    public void delete(String candidate) {

    }

    @Override
    public Candidate getCandidateByFirstAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Candidate> getCandidateByTechnology(String technology) {

        Map<String, AttributeValue> params = new HashMap<String, AttributeValue>();
        params.put(":val1", new AttributeValue().withS(technology));


        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("technology = :val1")
                .withExpressionAttributeValues(params);

        List<Candidate> result = dynamoDBMapper.scan(Candidate.class, scanExpression);
        if (result != null) {
            System.out.println("Candidatos encontrados*********************************");
        }


        return result;

    }
}
