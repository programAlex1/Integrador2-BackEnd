package com.spring.security.jwt.mapper;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.UserModel;

import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDto toUserDto(UserModel userModel);

    List<UserDto> toListUsersDto(List<UserModel> list);

    List<UserModel> toListUsersModel(List<UserDto> list);

    UserModel toUserModel(UserDto userDto);
}
