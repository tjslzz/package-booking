package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Booking;
import com.oocl.packagebooking.exception.BookingException;
import com.oocl.packagebooking.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public List<Booking> book(String id, String date) throws Exception {
        try{
            Integer number = Integer.valueOf(date.substring(11,13));
            if(number >= 9 && number <= 20){
                Booking booking = bookingRepo.findById(id).orElse(null);
                booking.setTime(date);
                booking.setState("已预约");
                bookingRepo.save(booking);
            }
            return bookingRepo.findAll();
        }
        catch (Exception e){
            throw new BookingException("很酷的异常！");
        }
    }

    public List<Booking> fetch(String id) throws Exception {
        try{
            Booking booking = bookingRepo.findById(id).orElse(null);
            booking.setState("已取件");
            booking.setTime("");
            bookingRepo.save(booking);
            return bookingRepo.findAll();
        }
        catch (Exception e){
            throw new BookingException("很酷的异常！");
        }
    }
}
