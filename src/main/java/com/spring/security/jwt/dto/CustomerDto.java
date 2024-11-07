package com.spring.security.jwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class CustomerDto {

    Long id;

    String name;
    String lastname;
    String email;
    String phone;
    String address;
    LocalDateTime creationTime;
}
