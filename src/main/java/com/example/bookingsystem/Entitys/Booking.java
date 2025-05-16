package com.example.bookingsystem.Entitys;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne     //// ony user can have many booking
    private UserEntity user;

    @ManyToOne     /// many bookings can be for the same event
    private EventsEntity event;

    private LocalDate bookingDate;

    public Booking(UserEntity user, EventsEntity event, LocalDate bookingDate) {
        this.user = user;
        this.event = event;
        this.bookingDate = bookingDate;
    }

    public Booking() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public EventsEntity getEvent() {
        return event;
    }

    public void setEvent(EventsEntity event) {
        this.event = event;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

}
