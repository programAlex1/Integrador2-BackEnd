package com.spring.security.jwt.controller;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.EventDto;
import com.spring.security.jwt.service.ICustomerService;
import com.spring.security.jwt.service.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/event")
public class EventController {

    private final IEventService iEventService;

    @PostMapping()
    public ResponseEntity<EventDto> save(@RequestBody EventDto eventDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iEventService.save(eventDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(iEventService.delete(id)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> update(@PathVariable Long id,@RequestBody EventDto eventDto){
        return ResponseEntity.of(iEventService.update(id,eventDto));
    }

    @GetMapping("")
    public ResponseEntity<List<EventDto>> findAll(){
        return ResponseEntity.ok(iEventService.findAll());
    }
}
