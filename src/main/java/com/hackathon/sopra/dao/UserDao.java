package com.hackathon.sopra.dao;

import com.hackathon.sopra.model.security.JwtUser;
import com.hackathon.sopra.model.security.UserCredentials;
import org.springframework.http.ResponseEntity;

public interface UserDao {
    JwtUser getUserByPassword(String password);
    JwtUser getUserByEmail(String email);
}
