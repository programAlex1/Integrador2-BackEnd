package com.spring.security.jwt.repository;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository{

 public UserModel findByName(String user);

 List<UserDto> findAll();

 public UserDto save(UserDto userDto);

 public void delete(Integer id);

 public Optional<UserDto> findById(Integer id);


}
