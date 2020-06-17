package com.example.aptivist.aptivistapp.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.aptivist.aptivistapp.dao.UserDao;
import com.example.aptivist.aptivistapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {


    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserDaoImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    @Override
    public User get(String id) {

        return dynamoDBMapper.load(User.class, id);
    }


    @Override
    public User save(User user) {
        dynamoDBMapper.save(user);
        return user;

    }

    @Override
    public User update(User user, String[] params) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("id", new ExpectedAttributeValue(new AttributeValue().withS(user.getId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(user, saveExpression);
        return user;
    }

    @Override
    public void delete(String id) {

        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(id)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        User user = new User();
        user.setId(id);

        dynamoDBMapper.delete(user, deleteExpression);

    }

    @Override
    public List<User> getUserByFirstName(String firstName) {


        Map<String, AttributeValue> params = new HashMap<String, AttributeValue>();
        params.put(":val1", new AttributeValue().withS(firstName));


        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :val1")
                .withExpressionAttributeValues(params);

        List<User> result = dynamoDBMapper.scan(User.class, scanExpression);
        if (result != null) {
            System.out.println("Usuario encontrado*********************************");
        }


        return result;
    }
}
