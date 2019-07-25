package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Booking;
import com.oocl.packagebooking.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<Booking> getBookings(){
        return bookingRepo.findAll();
    }

    public List<Booking> addBooking(Booking booking) {
        bookingRepo.save(booking);
        return bookingRepo.findAll();
    }

    public String book(String id, String date) {
        try{
            Booking booking = bookingRepo.findById(id).orElse(null);
            booking.setTime(date);
            booking.setState("已预约");
            bookingRepo.save(booking);
            return "预约成功";
        }
        catch (Exception e){}
        return "预约失败";
    }

    public List<Booking> fetch(String id) {
        try{
            Booking booking = bookingRepo.findById(id).orElse(null);
            booking.setState("已取件");
            booking.setTime("");
            bookingRepo.save(booking);
            return bookingRepo.findAll();
        }
        catch (Exception e){}
        return null;
    }
}
