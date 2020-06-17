package com.example.aptivist.aptivistapp.service;


import com.example.aptivist.aptivistapp.dto.UserDto;

import java.io.Serializable;

public interface UserService extends Serializable {

    UserDto retrieveUser(String userName);
}
