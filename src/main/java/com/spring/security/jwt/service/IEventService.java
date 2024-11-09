package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.CustomerDto;
import com.spring.security.jwt.dto.EventDto;
import com.spring.security.jwt.model.EventModel;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    public EventDto save(EventDto eventDto);

    public boolean delete(Long id);

    public List<EventDto> findAll();

    Optional<EventDto> update(Long id, EventDto eventDto);
}
