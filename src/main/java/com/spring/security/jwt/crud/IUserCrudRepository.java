package com.spring.security.jwt.crud;

import com.spring.security.jwt.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserCrudRepository extends JpaRepository<UserModel,Integer> {

    UserModel findByName(String name);
}
