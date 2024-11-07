package com.spring.security.jwt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    Integer user_id;
    String name;
    String password;
    String phone;
    String role;
}
