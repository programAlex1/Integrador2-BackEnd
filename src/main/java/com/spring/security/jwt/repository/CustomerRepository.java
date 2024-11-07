package com.spring.security.jwt.repository;

import com.spring.security.jwt.crud.ICustomerCrudRepository;
import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.mapper.ICustomerMapper;
import com.spring.security.jwt.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository{

    private final ICustomerCrudRepository iCustomerCrudRepository;
    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> findAll() {
        return iCustomerMapper.toListCustomerDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerModel customerModel = iCustomerCrudRepository.save(iCustomerMapper.toCustomerModel(customerDto));
        return iCustomerMapper.toCustomerDto(customerModel);
    }

    @Override
    public void delete(Long id) {
        iCustomerCrudRepository.deleteById(id);
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        return iCustomerCrudRepository.findById(id).map(iCustomerMapper::toCustomerDto);
    }
}
