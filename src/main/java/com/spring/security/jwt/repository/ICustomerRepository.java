package com.spring.security.jwt.repository;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> findAll();

    public CustomerDto save(CustomerDto customerDto);

    public  void delete(Long id);

    public Optional<CustomerDto> findById(Long id);

}
