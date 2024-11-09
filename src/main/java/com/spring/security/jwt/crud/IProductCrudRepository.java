package com.spring.security.jwt.crud;

import com.spring.security.jwt.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCrudRepository extends JpaRepository<ProductModel,Long> {
}
