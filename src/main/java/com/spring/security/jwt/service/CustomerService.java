package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.mapper.ICustomerMapper;
import com.spring.security.jwt.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService{

    private final ICustomerRepository iCustomerRepository;
    private final ICustomerMapper iCustomerMapper;
    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return iCustomerRepository.save(customerDto);
    }

    @Override
    public boolean delete(Long id) {
        if(iCustomerRepository.findById(id).isEmpty()){
            return false;
        }
        iCustomerRepository.delete(id);
        return true;
    }

    @Override
    public List<CustomerDto> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<CustomerDto> update(Long id, CustomerDto customerDto) {
        if(iCustomerRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        CustomerDto dto = iCustomerRepository.findById(id).get();
        customerDto.setCreationTime(dto.getCreationTime());
        customerDto.setId(id);
        CustomerDto customerDto1 = iCustomerMapper.toDtoToDto(customerDto);
        return Optional.of(iCustomerRepository.save(customerDto1));
    }
}
