package com.spring.security.jwt.dto;

import com.spring.security.jwt.model.SupplierModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
public class ProductDto {

    Long id;
    String name;
    String type;
    Integer stock;
    Double priceUnit;
    SupplierModel idSupplier;
    LocalDateTime creationTime;
    LocalDateTime updateTime;
}
