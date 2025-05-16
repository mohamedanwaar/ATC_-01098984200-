package com.example.bookingsystem.Controller;

import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Entitys.UserEntity;
import com.example.bookingsystem.Service.BookingService;
import com.example.bookingsystem.Service.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;   /// this is to connect with database via eventRepo interface
    @Autowired
    private BookingService bookingService; // Assuming you have a BookingService class for booking operations
    /// get all event

    @GetMapping("/home")
    public String getAllEvents(Model model , HttpSession session) {
        ArrayList<EventsEntity> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        UserEntity user = (UserEntity) session.getAttribute("user");
        Map<Long, Boolean> bookedMap = new HashMap<>();
        for (EventsEntity event : events) {
            boolean isBooked = bookingService.bookingExists(user, event);
            bookedMap.put(event.getId(), isBooked);
        }
        model.addAttribute("bookedMap", bookedMap);
        return "/home"   ;  /// this is to show all events


    }


}
