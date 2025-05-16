package com.example.bookingsystem.Repository;

import com.example.bookingsystem.Entitys.Booking;
import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    // You can add custom query methods here if needed
    // For example, find bookings by user or event
    ArrayList<Booking> findByUser(UserEntity user);
    Booking save(Booking booking);  /// this to save booking in database
    void deleteById(Long id);  /// this to delete booking in database
    boolean existsByUserAndEvent(UserEntity user, EventsEntity event);

}
