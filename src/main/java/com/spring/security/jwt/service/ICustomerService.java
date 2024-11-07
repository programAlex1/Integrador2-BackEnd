package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    public CustomerDto save(CustomerDto customerDto);

    public boolean delete(Long id);

    public List<CustomerDto> findAll();

    Optional<CustomerDto> update(Long id, CustomerDto customerDto);
}
