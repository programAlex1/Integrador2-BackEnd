package com.spring.security.jwt.crud;

import com.spring.security.jwt.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerCrudRepository extends JpaRepository<CustomerModel,Long> {
}
