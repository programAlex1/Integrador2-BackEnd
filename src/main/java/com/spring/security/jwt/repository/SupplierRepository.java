package com.spring.security.jwt.repository;

import com.spring.security.jwt.crud.ISuplierCrudRepository;
import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.mapper.ISupplierMapper;
import com.spring.security.jwt.model.SupplierModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class SupplierRepository implements ISupplierRepository{

    private final ISupplierMapper iSupplierMapper;

    private final ISuplierCrudRepository iSuplierCrudRepository;


    @Override
    public List<SupplierDto> findAll() {
        return iSupplierMapper.toListSupplierDto(iSuplierCrudRepository.findAll());
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        SupplierModel supplierModel = iSuplierCrudRepository.save(iSupplierMapper.toSupplierModel(supplierDto));
        return iSupplierMapper.toSupplierDto(supplierModel);
    }

    @Override
    public void delete(Long id) {
        iSuplierCrudRepository.deleteById(id);
    }

    @Override
    public Optional<SupplierDto> findById(Long id) {
        return iSuplierCrudRepository.findById(id).map(iSupplierMapper::toSupplierDto);
    }
}
