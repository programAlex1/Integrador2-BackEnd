package com.spring.security.jwt.repository;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface IEventRepository {

    List<EventDto> findAll();

    public EventDto save(EventDto eventDto);

    public  void delete(Long id);

    public Optional<EventDto> findById(Long id);
}
