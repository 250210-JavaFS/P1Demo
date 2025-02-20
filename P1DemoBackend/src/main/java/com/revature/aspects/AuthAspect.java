package com.revature.aspects;

import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect //This Class is an ASPECT - a class that can trigger functionality at any point in our app runtime
//When a certain method is called, this class can listen for that invocation and trigger some functionality
@Component
public class AuthAspect {

    //2 use cases we'll see
        //1) When any method in a controller OTHER than AuthController is called, make sure the user is logged in
        //2) When any method that's annotated with our custom @AdminOnly annotation is called,
            //...make sure the user has a role = admin


    //@Before allows us to invoke this method BEFORE any method we specify
    //"Invoke the login check before any method in the controllers package BESIDES AuthController""
    @Before("within(com.revature.controllers.*)" +
            "&& !within(com.revature.controllers.AuthController)")
    public void checkLoggedIn(){

        //get access to the session (or lack thereof)
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(false);

        //We're getting an object that has the session, and then trying to extract that session
        //getSession(false)?? Don't make a new session if one doesn't exist

        //If the session is null, the user isn't logged in, throw an exception!!!
        if(session == null || session.getAttribute("userId") == null){
            throw new IllegalArgumentException("User must be logged in to do this!");
        }
    }


}
