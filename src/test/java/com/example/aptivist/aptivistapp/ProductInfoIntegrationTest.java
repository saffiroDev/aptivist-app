package com.example.aptivist.aptivistapp;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.example.aptivist.aptivistapp.dao.CandidateDao;
import com.example.aptivist.aptivistapp.model.Candidate;
import com.example.aptivist.aptivistapp.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AptivistAppApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=Lamisma1+",
        "amazon.aws.secretkey=Lamisma2+" })
public class ProductInfoIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    UserService userService;


    @Autowired
    CandidateDao candidateDao;



    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";

    private static final String EXPECTED_USER_NAME = "yisus19";
    private static final String EXPECTED_PASSWORD = "Lamisma";

    private static final String CANDIDATE_NAME = "Aldo";
    private static final String CANDIDATE_FIRSTNAME = "Mancinas";
    private static final String CANDIDATE_LASTNAME = "M";
    private static final String CANDIDATE_EMAIL = "correo@email.com";
    private static final String CANDIDATE_PNUMBER = "4342221122";
    private static final String CANDIDATE_TECH = "Java";
    private static final String CANDIDATE_DOB= "08/29/1990";



    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        ListTablesResult names = amazonDynamoDB.listTables();
        System.out.println("PRUEBA SI NO EXISTE LA TABLA***********************+");
        List<String> tblnms = names.getTableNames();

        System.out.println(tblnms.toString());
        if (!tblnms.contains("Candidate")) {
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Candidate.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        }






    }


    /**@Test
    public void testInsertCandidate() {


        Candidate candidate = new Candidate();
        candidate.setFirstName("Jesus");
        candidate.setLastName("Lopez");
        candidate.setTechnology("Java");
        candidate.setEmail("correo@email.com");
        candidate.setPhoneNumber("342342422233");
        candidate.setDob("08/29/1990");
        candidate.setStatus("INVITATION_SEND");


        candidateDao.save(candidate);
    }**/


    @Test
    public void testRetrieveCandidate(){

        List<Candidate> candidates = candidateDao.getCandidateByTechnology(CANDIDATE_TECH);
        assertThat(candidates.get(0).getTechnology(), is(equalTo(CANDIDATE_TECH)));
    }



/**
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        ListTablesResult names =  amazonDynamoDB.listTables();
        System.out.println("PRUEBA SI NO EXISTE LA TABLA***********************+");
        List<String> tblnms = names.getTableNames();
        boolean ans = tblnms.isEmpty();
        if(ans == true){
            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(User.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);

        }

        CreateTableRequest tableRequest_b = dynamoDBMapper
                .generateCreateTableRequest(Candidate.class);
        tableRequest_b.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest_b);

        //...

        //dynamoDBMapper.batchDelete(
        //        (List<ProductInfo>)repository.findAll());
        //dynamoDBMapper.batchDelete((List<User>)userRepo.findAll());
    } **/


   /** @Test
    public void givenUserNameWithExpectedPassword_validate_login() {

        User us = new User(UUID.randomUUID().toString(), EXPECTED_USER_NAME, EXPECTED_PASSWORD);
        userRepo.save(us);
        UserDto res = userService.retrieveUser(EXPECTED_USER_NAME);
        System.out.println(res.toString());
        System.out.println("PRUEBA SERVICIO USER **********************************");
        //assertThat(res.size(), is(greaterThan(0)));
        assertThat(res.getUserNameDto(), is(equalTo(EXPECTED_USER_NAME)));
        assertThat(res.getPasswordDto(), is(equalTo(EXPECTED_PASSWORD)));
    }**/

/**
    @Test
    public void insertCandidate(){
        Candidate candidate = new Candidate(UUID.randomUUID().toString(), CANDIDATE_FIRSTNAME, CANDIDATE_LASTNAME, CANDIDATE_TECH, CANDIDATE_EMAIL,
                CANDIDATE_PNUMBER, CANDIDATE_DOB);
        candRepository.save(candidate);

        assertThat(candidate.getFirstName(), is(equalTo(CANDIDATE_FIRSTNAME)));

    } **/




}
