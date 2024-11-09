package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public ProductDto save(ProductDto productDto);

    public boolean delete(Long id);

    public List<ProductDto> findAll();

    Optional<ProductDto> update(Long id, ProductDto productDto);
}
