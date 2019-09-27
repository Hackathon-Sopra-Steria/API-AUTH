package com.hackathon.sopra.controller.impl;

import com.hackathon.sopra.controller.LoginController;
import com.hackathon.sopra.model.security.UserCredentials;
import com.hackathon.sopra.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.MethodHandles;


public class LoginControllerImpl implements LoginController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private LoginService loginService;

    @Autowired
    public LoginControllerImpl(LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    public ResponseEntity<String> login(UserCredentials userCredentials) {
        logger.info(" -- POST  /login {}",userCredentials.getEmail());
        return new ResponseEntity<>(loginService.login(userCredentials), HttpStatus.OK);
    }
}
