package com.hackathon.sopra.boot.security;

import com.hackathon.sopra.boot.properties.Properties;
import com.hackathon.sopra.model.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    private Properties properties;

    @Autowired
    public JwtGenerator(Properties properties){
        this.properties=properties;
    }

    public String generate(JwtUser jwtUser){
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
         claims.put(this.properties.getId(),String.valueOf(jwtUser.getId()));
         claims.put(this.properties.getRole(),jwtUser.getRole());
         return Jwts.builder()
                 .setClaims(claims)
                 .signWith(SignatureAlgorithm.HS256,this.properties.getBitSecret())
                 .compact();
    }
}
