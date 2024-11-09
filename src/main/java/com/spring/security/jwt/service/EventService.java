package com.spring.security.jwt.service;

import com.spring.security.jwt.dto.EventDto;
import com.spring.security.jwt.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService implements IEventService{

    private final IEventRepository iEventRepository;

    @Override
    public EventDto save(EventDto eventDto) {
        return iEventRepository.save(eventDto);
    }

    @Override
    public boolean delete(Long id) {
        if(iEventRepository.findById(id).isEmpty()){
            return false;
        }
        iEventRepository.delete(id);
        return true;
    }

    @Override
    public List<EventDto> findAll() {
        return iEventRepository.findAll();
    }

    @Override
    public Optional<EventDto> update(Long id, EventDto eventDto) {
        if(iEventRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        eventDto.setId(id);
        return Optional.of(iEventRepository.save(eventDto));
    }
}
