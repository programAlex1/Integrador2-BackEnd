package com.spring.security.jwt.mapper;

import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.SupplierModel;
import com.spring.security.jwt.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISupplierMapper {

    SupplierDto toSupplierDto(SupplierModel supplierModel);

    SupplierDto toSupplierDtoToDto(SupplierDto supplierDto);

    List<SupplierDto> toListSupplierDto(List<SupplierModel> list);

    List<SupplierModel> toListSupplierModel(List<SupplierDto> list);

    SupplierModel toSupplierModel(SupplierDto supplierDto);

}
