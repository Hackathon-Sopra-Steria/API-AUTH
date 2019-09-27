package com.hackathon.sopra.controller;

import com.hackathon.sopra.model.security.UserCredentials;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public interface LoginController{


    ResponseEntity<String> login(@RequestBody UserCredentials userCredentials);
}


