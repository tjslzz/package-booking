package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Booking;
import com.oocl.packagebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boss")
@CrossOrigin(origins = { "http://localhost:8081", "http://localhost:8888" }, maxAge = 6000)
public class BossBookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBooking(){
        return bookingService.getBookings();
    }

    @PostMapping
    public List<Booking> getAllBooking(@RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }

    @PutMapping("/id/{id}")
    public List<Booking> putAllBooking(@PathVariable("id") String id){
        return bookingService.fetch(id);
    }
}
