package com.hackathon.sopra.service;

import com.hackathon.sopra.model.security.UserCredentials;

public interface LoginService {
    String login(UserCredentials userCredentials);
}
