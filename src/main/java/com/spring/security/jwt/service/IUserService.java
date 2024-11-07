package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public UserDto save(UserDto userDto);

    public boolean delete(Integer idUser);

    public List<UserDto> findAll();

    Optional<UserDto> update(Integer userId,UserDto userDto);

}
