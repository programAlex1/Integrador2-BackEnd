package com.spring.security.jwt.dto;

import com.spring.security.jwt.model.CustomerModel;
import com.spring.security.jwt.model.ProductModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
public class EventDto {

    Long id;
    String name;
    String type;
    String numberAssistants;
    String description;
    Double price;
    LocalDate date;
    String location;
    CustomerModel idCustomer;
    Set<ProductModel> productsList;
}
