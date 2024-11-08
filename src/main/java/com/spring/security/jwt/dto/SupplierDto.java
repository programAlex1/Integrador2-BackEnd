package com.spring.security.jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SupplierDto {

    Long id;

    String name;
    String nameContact;
    String phone;
    String email;
    String address;
}
