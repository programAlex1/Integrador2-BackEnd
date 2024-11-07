package com.spring.security.jwt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String lastname;
    String email;
    String phone;
    String address;

    @CreationTimestamp
    @Column(name = "creation_time", nullable = false, updatable = false)
    LocalDateTime creationTime;
}
