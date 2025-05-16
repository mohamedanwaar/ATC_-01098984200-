package com.example.bookingsystem.Entitys;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   /// this is primary key
    private String eventName;   /// name of the event
    private LocalDate eventDate;    /// date and time of the event
    private String eventLocation;    /// location of the event
    @Column(length = 500)
    private String eventDescription;    /// brief description of the event
    private String eventImage; /// URL or path to the image
    private String eventType; /// type of the event (e.g., concert, conference, etc.)
    private  double eventPrice; /// price of the event


    public EventsEntity(String eventName, LocalDate eventDate, String eventLocation, String eventDescription, String eventImage, String eventType, double eventPrice) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventImage = eventImage;
        this.eventType = eventType;
        this.eventPrice = eventPrice;
    }

    public EventsEntity(String eventName, LocalDate eventDate, String eventLocation, String eventDescription, String eventType, double eventPrice) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.eventPrice = eventPrice;
    }

    public EventsEntity() {

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(double eventPrice) {
        this.eventPrice = eventPrice;
    }
}
