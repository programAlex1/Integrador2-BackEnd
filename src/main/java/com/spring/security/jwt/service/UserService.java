package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.model.UserModel;
import com.spring.security.jwt.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    public final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
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
}
