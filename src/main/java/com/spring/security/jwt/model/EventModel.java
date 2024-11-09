package com.spring.security.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String type;
    String numberAssistants;
    String description;
    Double price;
    LocalDate date;
    String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    CustomerModel idCustomer;

    @ManyToMany
    @JoinTable(
            name = "event_product",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<ProductModel> productsList;
}
