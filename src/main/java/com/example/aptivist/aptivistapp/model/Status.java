package com.example.aptivist.aptivistapp.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamoDBTable(tableName = "Status")
public class Status {

    private String idCandidate;

    private String idStatus;

    private String Status;
    


}
