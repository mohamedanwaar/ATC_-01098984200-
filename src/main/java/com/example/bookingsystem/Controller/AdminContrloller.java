package com.example.bookingsystem.Controller;

import com.example.bookingsystem.Entitys.EventsEntity;
import com.example.bookingsystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminContrloller {

    @Autowired
    private EventService eventService;   /// this is to connect with database via eventRepo interface
    @Autowired
    private FilesController filesController; /// this is to upload file

     /// first we apper admin dshpord
    /// then we can add event or delete event or update event
    @GetMapping("/admin")
    public String getAdminDashboard()
    {
        return "/adminDashboard";  /// this is to show admin dashboard
    }
    @GetMapping("/admin/addEvent")
    public String getAddEvent()
    {
        return "/AdminAddPage";  /// this is to show add event page
    }
    @PostMapping("/admin/addEvent")
    public String addEvent
    (
            @RequestParam String eventName,
            @RequestParam String eventDate,
            @RequestParam String eventLocation,
            @RequestParam String eventDescription,
            @RequestParam double eventPrice,
            @RequestParam MultipartFile eventImage,
            @RequestParam String eventCategory


    )
    {
        /// this is to upload file
        String fileUrl = filesController.uploadFile(eventImage);
        /// this is to add event
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate eventDateTime = LocalDate.parse(eventDate ,dateTimeFormatter);  /// this is to convert string to date
        // create event object
        EventsEntity eventsEntity=new EventsEntity(eventName, eventDateTime, eventLocation, eventDescription, fileUrl, eventCategory, eventPrice);
        /// this is to save event in database
        eventService.saveEvent(eventsEntity);
        /// this is to show all events
        System.out.println("Event added successfully");
        return "redirect:/admin";  /// this is to show admin dashboard


    }
    @PostMapping("/admin/deleteEvent")
    public String deleteEvent (@RequestParam Long eventId , Model model)
    {
        /// this is to delete event
        eventService.deleteEvent(eventId);
        System.out.println("Event deleted successfully");
        return "redirect:/admin/viewEvents";  /// this is to show admin dashboard
    }

    @GetMapping("/admin/viewEvents")
    public String viewEvents(Model model) {
        ArrayList<EventsEntity> events = eventService.getAllEvent(); // Fetch all events
        model.addAttribute("events", events); // Add events to the model
        return "adminDashboard"; // Return the template name
    }
    @GetMapping("admin/edit/{id}")
    public String updateEvent(@PathVariable Long id, Model model )
    {
        /// this is to get event by id
        EventsEntity eventsEntity=eventService.getEventById(id);
        model.addAttribute("event",eventsEntity);  /// this is to add event to model
        if(eventsEntity==null)
        {
            System.out.println("Event not found");
            return "redirect:/admin/viewEvents";  /// this is to show admin dashboard
        }
        else
        {
            return "UpdatePage";  /// this is to show update event page
        }
    }
    @PostMapping("/admin/updateEvent")
    public String updateEvent(@ModelAttribute EventsEntity event , @RequestParam("newEventImage") MultipartFile newEventImage)
    {
        /// if the admin upload new image then this is to upload new image
        if (!newEventImage.isEmpty())
        {
            String fileUrl = filesController.uploadFile(newEventImage);
            event.setEventImage(fileUrl);  /// this is to set new image
        }
        eventService.saveEvent(event);
        System.out.println("Event updated successfully");
        return "redirect:/admin/viewEvents";  /// this is to show admin dashboard
    }


}
