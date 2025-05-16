package com.example.bookingsystem.Service;

import com.example.bookingsystem.Entitys.Booking;
import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Entitys.UserEntity;
import com.example.bookingsystem.Repository.BookingRepo;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingService  {
    // Implement the methods defined in BookingServiceInterface
    // For example, you can add methods to create, update, and delete bookings
    // You can also add methods to retrieve bookings for a specific user or event
    @Autowired
    private BookingRepo bookingRepo; // Assuming you have a BookingRepo interface for database operations
    // Example method to create a booking

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }
    // Example method to retrieve all bookings
    public ArrayList<Booking> getAllBookings( UserEntity user) {

        return bookingRepo.findByUser(user);
    }
    public void deleteBooking(Long bookingId) {
        bookingRepo.deleteById(bookingId);
    }
    public boolean bookingExists(UserEntity user, EventsEntity event) {
        return bookingRepo.existsByUserAndEvent(user,event);
    }
}
