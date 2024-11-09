package com.spring.security.jwt.controller;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.ProductDto;
import com.spring.security.jwt.service.ICustomerService;
import com.spring.security.jwt.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    private final IProductService iProductService;

    @PostMapping()
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iProductService.save(productDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iProductService.delete(id)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id,@RequestBody ProductDto productDto){
        return ResponseEntity.of(iProductService.update(id,productDto));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(iProductService.findAll());
    }
}
