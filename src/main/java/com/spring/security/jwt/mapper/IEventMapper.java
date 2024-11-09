package com.spring.security.jwt.mapper;

import com.spring.security.jwt.dto.EventDto;
import com.spring.security.jwt.model.EventModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface IEventMapper {

    EventDto toEventDto(EventModel eventModel);

    List<EventDto> toListEventDto(List<EventModel> list);

    List<EventModel> toListEventModel(List<EventDto> list);

    EventModel toEventModel(EventDto eventDto);
}
