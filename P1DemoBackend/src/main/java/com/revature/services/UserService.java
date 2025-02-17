package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Make this class a bean
public class UserService {

    //Autowire the DAO so we can use its method
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    //Get all users from the DB
    public List<User> getAllUsers(){

        //For get all, we don't have to do much user input validation
        //There's no user input! We just want to get all the data
        return userDAO.findAll();

    }

}
