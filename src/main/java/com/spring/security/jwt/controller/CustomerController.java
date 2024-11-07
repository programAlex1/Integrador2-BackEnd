package com.spring.security.jwt.controller;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.UserDto;
import com.spring.security.jwt.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final ICustomerService iCustomerService;

    @PostMapping()
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerService.save(customerDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iCustomerService.delete(id)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable Long id,@RequestBody CustomerDto customerDto){
        return ResponseEntity.of(iCustomerService.update(id,customerDto));
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> findAll(){
        return ResponseEntity.ok(iCustomerService.findAll());
    }
}
