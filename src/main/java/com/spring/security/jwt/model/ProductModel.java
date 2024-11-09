package com.spring.security.jwt.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String type;
    Integer stock;
    Double priceUnit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_supplier")
    SupplierModel idSupplier;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "creation_time", nullable = false, updatable = false)
    LocalDateTime creationTime;

    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updateTime;
}
