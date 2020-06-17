package com.example.aptivist.aptivistapp.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamoDBTable(tableName = "Candidate")
public class Candidate {



    @DynamoDBAttribute
    private String firstName;

    @DynamoDBHashKey
    private String lastName;

    @DynamoDBRangeKey
    @DynamoDBAttribute
    private String technology;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String phoneNumber;

    @DynamoDBAttribute
    private String dob;

    @DynamoDBAttribute
    private String status;


}
