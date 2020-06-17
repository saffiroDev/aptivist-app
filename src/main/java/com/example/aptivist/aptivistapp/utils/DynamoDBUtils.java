package com.example.aptivist.aptivistapp.utils;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamoDBUtils implements  DynamoDBUtil{


    DynamoDBMapper dynamoDBMapper;

    @Autowired
    AmazonDynamoDB amazonDynamoDB;




    public static void main(String args []){


        DynamoDBUtils db = new DynamoDBUtils();
        Candidate candidate = new Candidate();
        candidate.setFirstName("Jesus");
        candidate.setLastName("Lopez");
        candidate.setTechnology("Java");
        candidate.setEmail("correo@email.com");
        candidate.setPhoneNumber("342342422233");
        candidate.setDob("08/29/1990");
        candidate.setStatus("INVITATION_SEND");

        db.createTable(candidate);

    }

    @Override
    public <T> void createTable(Object T) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        ListTablesResult names = new ListTablesResult();
        names =  amazonDynamoDB.listTables();
        // PRUEBA SI NO EXISTE LA TABLA***********************+"
        List<String> tblnms = names.getTableNames();
        System.out.println(tblnms.toString());
        System.out.println(T.getClass().toString());

        if (!tblnms.contains(T.getClass().toString())) {
            CreateTableRequest tableRequest = dynamoDBMapper
                        .generateCreateTableRequest(T.getClass());
            tableRequest.setProvisionedThroughput(
                        new ProvisionedThroughput(1L, 1L));
                        amazonDynamoDB.createTable(tableRequest);


        }

    }

}
