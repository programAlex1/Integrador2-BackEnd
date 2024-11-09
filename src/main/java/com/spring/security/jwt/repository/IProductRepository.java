package com.spring.security.jwt.repository;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.ProductDto;
import com.spring.security.jwt.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<ProductDto> findAll();

    public ProductDto save(ProductDto productDto);

    public  void delete(Long id);

    public Optional<ProductDto> findById(Long id);
}
