package com.example.aptivist.aptivistapp.dao;

import com.example.aptivist.aptivistapp.model.User;

import java.util.List;

public interface UserDao extends Dao<User>{


    List<User> getUserByFirstName(String firstName);


}
