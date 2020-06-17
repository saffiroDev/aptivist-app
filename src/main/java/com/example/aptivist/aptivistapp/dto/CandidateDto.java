package com.example.aptivist.aptivistapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateDto {


    private String idCandidate;
    private String firstName;
    private String lastName;
    private String technology;
    private String email;
    private String phoneNumber;
    private String dob;
    private String status;


}
