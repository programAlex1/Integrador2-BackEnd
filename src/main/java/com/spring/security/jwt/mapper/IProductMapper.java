package com.spring.security.jwt.mapper;

import com.spring.security.jwt.dto.ProductDto;
import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.model.ProductModel;
import com.spring.security.jwt.model.SupplierModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    ProductDto toProductDto(ProductModel productModel);

    ProductDto toProductDtoToDto(ProductDto productDto);

    List<ProductDto> toListProductDto(List<ProductModel> list);

    List<ProductModel> toListProductModel(List<ProductDto> list);

    ProductModel toProductModel(ProductDto productDto);
}
