package com.spring.security.jwt.controller;


import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.SupplierDto;
import com.spring.security.jwt.service.ICustomerService;
import com.spring.security.jwt.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/supplier")
public class SupplierController {

    private final ISupplierService iSupplierService;

    @PostMapping()
    public ResponseEntity<SupplierDto> save(@RequestBody SupplierDto supplierDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iSupplierService.save(supplierDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iSupplierService.delete(id)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> update(@PathVariable Long id,@RequestBody SupplierDto supplierDto){
        return ResponseEntity.of(iSupplierService.update(id,supplierDto));
    }

    @GetMapping("")
    public ResponseEntity<List<SupplierDto>> findAll(){
        return ResponseEntity.ok(iSupplierService.findAll());
    }
}
