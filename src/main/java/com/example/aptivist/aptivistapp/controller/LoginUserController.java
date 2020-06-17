package com.example.aptivist.aptivistapp.controller;


import com.example.aptivist.aptivistapp.dto.UserDto;
import com.example.aptivist.aptivistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUserController {


    @Autowired
    UserService userService;


    @GetMapping(path="/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") String idUser) {
        UserDto foundUser = userService.retrieveUser(idUser);
        if (foundUser == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        }

    }
}
