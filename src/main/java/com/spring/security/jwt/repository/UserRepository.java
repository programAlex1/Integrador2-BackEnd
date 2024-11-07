package com.spring.security.jwt.repository;

import com.spring.security.jwt.crud.IUserCrudRepository;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.mapper.IUserMapper;
import com.spring.security.jwt.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepository implements IUserRepository {


    private final IUserCrudRepository iUserCrudRepository;
    private final IUserMapper iUserMapper;

    @Override
    public UserModel findByName(String user) {
        return iUserCrudRepository.findByName(user);
    }

    @Override
    public List<UserDto> findAll() {
        return iUserMapper.toListUsersDto(iUserCrudRepository.findAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserModel userModel =iUserCrudRepository.save(iUserMapper.toUserModel(userDto));
        return iUserMapper.toUserDto(userModel);
    }

    @Override
    public void delete(Integer id) {
        iUserCrudRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findById(Integer id) {
        return iUserCrudRepository.findById(id).map(iUserMapper::toUserDto);
    }

}
