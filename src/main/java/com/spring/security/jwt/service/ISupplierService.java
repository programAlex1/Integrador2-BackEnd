package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.SupplierDto;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {

    public SupplierDto save(SupplierDto supplierDto);

    public boolean delete(Long id);

    public List<SupplierDto> findAll();

    Optional<SupplierDto> update(Long id, SupplierDto supplierDto);
}
