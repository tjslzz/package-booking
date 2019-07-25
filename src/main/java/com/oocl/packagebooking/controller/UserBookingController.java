package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserBookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping("/book-id/{id}")
    public String bookBooking(@PathVariable("id") String id, @RequestBody String date){
        return bookingService.book(id,date);
    }

}
