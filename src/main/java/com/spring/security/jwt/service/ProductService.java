package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.ProductDto;
import com.spring.security.jwt.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService{

    private final IProductRepository iProductRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        return iProductRepository.save(productDto);
    }

    @Override
    public boolean delete(Long id) {
        if(iProductRepository.findById(id).isEmpty()){
            return false;
        }
        iProductRepository.delete(id);
        return true;
    }

    @Override
    public List<ProductDto> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<ProductDto> update(Long id, ProductDto productDto) {
        if(iProductRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        productDto.setId(id);
        return Optional.of(iProductRepository.save(productDto));
    }

    @Override
    public Optional<ProductDto> updateStock(Long id, ProductDto productDto) {
        if(iProductRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        ProductDto productDto1 = iProductRepository.findById(id).get();
        productDto1.setStock(productDto.getStock() + productDto1.getStock());
        return Optional.of(iProductRepository.save(productDto1));
    }
}
