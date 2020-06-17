package com.example.aptivist.aptivistapp.service.impl;

import com.example.aptivist.aptivistapp.dao.UserDao;
import com.example.aptivist.aptivistapp.dto.UserDto;
import com.example.aptivist.aptivistapp.dto.mapper.UserMapper;
import com.example.aptivist.aptivistapp.model.User;
import com.example.aptivist.aptivistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDto retrieveUser(String id) {

        List<User> user = userDao.getUserByFirstName(id);
        return  mapper.toUserDto(user.get(0));

    }



}
