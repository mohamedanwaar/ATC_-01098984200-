package com.example.bookingsystem.Service;

import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventService {
    // this is to make event for user
    // this is to make event for
    @Autowired
    private EventRepo eventRepo;   /// this is to connect with database via eventRepo interface

    public ArrayList<EventsEntity> getAllEvents() {
        return eventRepo.getAllByIdIsNotNullOrderByEventDate();
    }
    public ArrayList<EventsEntity> getAllEvent() {
        return (ArrayList<EventsEntity>) eventRepo.findAll();
    }
    public EventsEntity saveEvent(EventsEntity eventsEntity) {
        return eventRepo.save(eventsEntity);
    }

    public  void deleteEvent(Long eventid) {
        eventRepo.deleteById(eventid);
    }

    public EventsEntity getEventById(Long eventid) {
        return eventRepo.findById(eventid).orElse(null);
    }


}
