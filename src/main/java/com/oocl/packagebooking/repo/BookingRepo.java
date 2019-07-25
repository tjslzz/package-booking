package com.oocl.packagebooking.repo;

import com.oocl.packagebooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
