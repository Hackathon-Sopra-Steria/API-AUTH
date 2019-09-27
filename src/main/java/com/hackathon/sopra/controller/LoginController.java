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

@RestController
@Api(tags = { "Login" }, description = "Access API management resource")
public interface LoginController{

    @ApiOperation(value="Insert credentials ",notes="Insert login credentials.")
    @PostMapping(path="/login", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    ResponseEntity<String> login(@ApiParam(name="User credentials", value="User credentials",required = true)@RequestBody UserCredentials userCredentials);
}


