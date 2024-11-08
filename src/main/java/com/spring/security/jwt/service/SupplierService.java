package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.mapper.ISupplierMapper;
import com.spring.security.jwt.repository.ISupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplierService implements ISupplierService{
    private final ISupplierRepository iSupplierRepository;
    private final ISupplierMapper iSupplierMapper;

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        return iSupplierRepository.save(supplierDto);
    }

    @Override
    public boolean delete(Long id) {
        if(iSupplierRepository.findById(id).isEmpty()){
            return false;
        }
        iSupplierRepository.delete(id);
        return true;
    }

    @Override
    public List<SupplierDto> findAll() {
        return iSupplierRepository.findAll();
    }

    @Override
    public Optional<SupplierDto> update(Long id, SupplierDto supplierDto) {
        if(iSupplierRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        supplierDto.setId(id);
        return Optional.of(iSupplierRepository.save(supplierDto));
    }
}
