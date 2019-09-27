package com.hackathon.sopra.dao.impl;

import com.hackathon.sopra.dao.UserDao;
import com.hackathon.sopra.dao.mapper.UserMapper;
import com.hackathon.sopra.model.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDaoImpl implements UserDao {
    private UserMapper userMapper;
    @Autowired
    public UserDaoImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }



    @Override
    public JwtUser getUserByPassword(String password) {
        return userMapper.getUserByPassword(password);
    }

    @Override
    public JwtUser getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}
