package com.spring.security.jwt.repository;

import com.spring.security.jwt.crud.IEventCrudRepository;
import com.spring.security.jwt.dto.EventDto;
import com.spring.security.jwt.mapper.IEventMapper;
import com.spring.security.jwt.model.EventModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class EventRepository implements IEventRepository {

    private final IEventCrudRepository iEventCrudRepository;
    private final IEventMapper iEventMapper;


    @Override
    public List<EventDto> findAll() {
        return iEventMapper.toListEventDto(iEventCrudRepository.findAll());
    }

    @Override
    public EventDto save(EventDto eventDto) {
        EventModel eventModel = iEventCrudRepository.save(iEventMapper.toEventModel(eventDto));
        return iEventMapper.toEventDto(eventModel);
    }

    @Override
    public void delete(Long id) {
        iEventCrudRepository.deleteById(id);
    }

    @Override
    public Optional<EventDto> findById(Long id) {
        return iEventCrudRepository.findById(id).map(iEventMapper::toEventDto);
    }
}
