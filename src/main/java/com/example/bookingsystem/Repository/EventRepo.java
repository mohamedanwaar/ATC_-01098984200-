package com.example.bookingsystem.Repository;

import com.example.bookingsystem.Entitys.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.Link;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public interface EventRepo extends JpaRepository<EventsEntity,Long> {

    ArrayList<EventsEntity> getAllByIdIsNotNullOrderByEventDate();
    EventsEntity findAllByEventDate(LocalDate eventDate);
    Optional<EventsEntity> findById(Long id);
    void deleteById(Long id);
    EventsEntity save (EventsEntity eventsEntity);  /// this to save event in database
    EventsEntity findByEventName(String eventName);
    EventsEntity findByEventLocation(String eventLocation);
    EventsEntity findByEventType(String eventType);



}
