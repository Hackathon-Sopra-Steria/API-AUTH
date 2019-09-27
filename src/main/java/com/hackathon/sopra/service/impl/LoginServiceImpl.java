package com.hackathon.sopra.service.impl;

import com.hackathon.sopra.boot.security.JwtGenerator;
import com.hackathon.sopra.dao.UserDao;
import com.hackathon.sopra.model.security.JwtUser;
import com.hackathon.sopra.model.security.UserCredentials;
import com.hackathon.sopra.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private UserDao userDao;
    private JwtGenerator jwtGenerator;

    @Autowired
    public LoginServiceImpl(UserDao userDao,JwtGenerator jwtGenerator){
        this.userDao=userDao;
        this.jwtGenerator=jwtGenerator;
    }

    @Override
    public String login(UserCredentials userCredentials) {
        JwtUser jwtUser = userDao.getUserByPassword(userCredentials.getPassword());
        JwtUser jwtUser2 = userDao.getUserByEmail(userCredentials.getEmail());
        if(jwtUser.getId().equals(jwtUser2.getId())){
            logger.info(" -- Welcome HACKATON SOPRA {}",jwtUser.getEmail());
            return "Bearer "+this.jwtGenerator.generate(jwtUser);
        }
        else{
            logger.info(" -- Bad Credentials {}",jwtUser.getEmail());
            return null;
        }
    }
}
