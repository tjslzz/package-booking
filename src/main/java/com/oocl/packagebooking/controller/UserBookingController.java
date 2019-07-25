package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Booking;
import com.oocl.packagebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:8081", "http://localhost:8888" }, maxAge = 6000)
public class UserBookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping("/book-id/{id}")
    public List<Booking> bookBooking(@PathVariable("id") String id, @RequestParam(value = "time",defaultValue = "",required = false) String date){
        return bookingService.book(id,date);
    }

}
