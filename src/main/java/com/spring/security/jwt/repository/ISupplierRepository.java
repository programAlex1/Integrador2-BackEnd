package com.spring.security.jwt.repository;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.model.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface ISupplierRepository {

    List<SupplierDto> findAll();

    public SupplierDto save(SupplierDto supplierDto);

    public  void delete(Long id);

    public Optional<SupplierDto> findById(Long id);
}
