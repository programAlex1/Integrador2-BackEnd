package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.mapper.IUserMapper;
import com.spring.security.jwt.model.UserModel;
import com.spring.security.jwt.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    public final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private  final IUserMapper iUserMapper;
    @Override
    public UserDto save(UserDto userDto) {
        String password = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(password);
        return iUserRepository.save(userDto);
    }

    @Override
    public boolean delete(Integer idUser) {
        if(iUserRepository.findById(idUser).isEmpty()){
            return false;
        }
        iUserRepository.delete(idUser);
        return true;
    }

    @Override
    public List<UserDto> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<UserDto> update(Integer userid,UserDto userDto) {
        if(iUserRepository.findById(userid).isEmpty()){
            return Optional.empty();
        }
        String password = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(password);
        userDto.setUser_id(userid);
        UserDto update = iUserMapper.toUserDtoToDto(userDto);
        return Optional.of(iUserRepository.save(update));
    }
}
