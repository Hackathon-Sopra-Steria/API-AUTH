package com.hackathon.sopra.dao.mapper;

import com.hackathon.sopra.model.security.JwtUser;
import com.hackathon.sopra.model.security.UserCredentials;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

public interface UserMapper {
    JwtUser getUserByPassword(@Param("password") String password);
    JwtUser getUserByEmail(@Param("email") String email);
}
