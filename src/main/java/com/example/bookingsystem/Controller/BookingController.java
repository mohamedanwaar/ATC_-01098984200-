package com.example.bookingsystem.Controller;

import com.example.bookingsystem.Entitys.Booking;
import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Entitys.UserEntity;
import com.example.bookingsystem.Service.BookingService;
import com.example.bookingsystem.Service.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.lang.model.type.ArrayType;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class BookingController {
    // Add your methods here to handle booking-related requests
    @Autowired
    BookingService bookingService; // Assuming you have a BookingService class for booking operations
    @Autowired
    EventService eventService; // Assuming you have an EventService class for event operations
    @Autowired
    BookingService bookingService1; // Assuming you have a BookingService class for booking operations

    @GetMapping("home/mybooking")
    public String viewMyBookings(HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        ArrayList<Booking> bookings = bookingService.getAllBookings(user);
        model.addAttribute("bookings", bookings);
        for (Booking booking : bookings) {
            EventsEntity event = booking.getEvent();
            String eventName = event.getEventName();
            System.out.println("Event Name: " + eventName);
        }
        return "myBookings"; // Thymeleaf template to display bookings
    }

    @PostMapping("Booking")
    public String booking(HttpSession session, Model model,
                          @RequestParam("eventId") Long eventId) {

        {
            UserEntity user = (UserEntity) session.getAttribute("user");
            if (user == null) {
                return "redirect:/login";
            }
            // Check if the user has already booked this event

            EventsEntity event = eventService.getEventById(eventId);
            if(!bookingService.bookingExists(user, event)) {
                Booking booking = new Booking(user, event, LocalDate.now());
                bookingService.createBooking(booking);
                return "redirect:home/mybooking"; // Redirect to the bookings page after creating a booking
            }
            else {
                model.addAttribute("error", "You have already booked this event.");
                return "redirect:/home"; // Redirect to the events page with an error message
            }

        }
    }
    @PostMapping("Bookings/cancle")
    public String deleteBooking(@RequestParam Long bookingId, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        bookingService.deleteBooking(bookingId);
        return "redirect:/home/mybooking"; // Redirect to the bookings page after deleting a booking
    }
}
