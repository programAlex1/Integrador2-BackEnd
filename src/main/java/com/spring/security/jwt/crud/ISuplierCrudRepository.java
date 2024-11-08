package com.spring.security.jwt.crud;

import com.spring.security.jwt.model.SupplierModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISuplierCrudRepository extends JpaRepository<SupplierModel,Long> {
}
