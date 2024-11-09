package com.spring.security.jwt.repository;

import com.spring.security.jwt.crud.IProductCrudRepository;
import com.spring.security.jwt.dto.ProductDto;
import com.spring.security.jwt.mapper.IProductMapper;
import com.spring.security.jwt.model.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProducRepository implements IProductRepository{

    private final IProductCrudRepository iProductCrudRepository;

    private final IProductMapper iProductMapper;

    @Override
    public List<ProductDto> findAll() {
        return iProductMapper.toListProductDto(iProductCrudRepository.findAll());
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductModel productModel = iProductCrudRepository.save(iProductMapper.toProductModel(productDto));
        return iProductMapper.toProductDto(productModel);
    }

    @Override
    public void delete(Long id) {
        iProductCrudRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return iProductCrudRepository.findById(id).map(iProductMapper::toProductDto);
    }
}
