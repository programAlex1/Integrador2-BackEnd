package com.spring.security.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class SupplierModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String nameContact;
    String phone;
    String email;
    String address;
}
