package com.spring.security.jwt.mapper;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.CustomerModel;
import com.spring.security.jwt.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {
    CustomerDto toCustomerDto(CustomerModel customerModel);

    CustomerModel toCustomerModel(CustomerDto customerDto);

    List<CustomerDto> toListCustomerDto(List<CustomerModel> list);

    List<CustomerModel> toListCustomerModel(List<CustomerDto> list);

    CustomerDto toDtoToDto(CustomerDto customerDto);
}
