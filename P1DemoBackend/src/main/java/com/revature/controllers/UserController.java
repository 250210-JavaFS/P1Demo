package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Make this class a bean and turn HTTP response bodies into JSON
@RequestMapping("/users") //Requests ending in /users will go to this Controller
public class UserController {

    //Autowire the UserService to use its methods
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Return all users to the client
    public ResponseEntity<List<User>> getAllUsers(){

        //Let's return the Users in one line
        return ResponseEntity.ok(userService.getAllUsers());
        
    }


}
