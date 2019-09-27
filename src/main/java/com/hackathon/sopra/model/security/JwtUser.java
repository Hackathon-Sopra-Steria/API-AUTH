package com.hackathon.sopra.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser {
    private Long id;
    private String username;
    private String role;
    private String email;
}
