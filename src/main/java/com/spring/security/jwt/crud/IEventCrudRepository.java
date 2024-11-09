package com.spring.security.jwt.crud;

import com.spring.security.jwt.model.EventModel;
import com.spring.security.jwt.repository.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventCrudRepository extends JpaRepository<EventModel,Long> {
}
