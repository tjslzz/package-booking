package com.oocl.packagebooking.repo;

import com.oocl.packagebooking.entity.Booking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BookingRepoTest {

    @Autowired
    private BookingRepo bookingRepo;

    private Booking booking;
    @Before
    public void setUp(){
        booking = new Booking("0001","jerryLi","18229797216","未取件","2019-01-01");
    }

    @Test
    public void should_return_list_when_get_all_list(){
        bookingRepo.save(booking);
        List<Booking> bookingList = bookingRepo.findAll();
        assertEquals(1,bookingList.size());
    }

    @Test
    public void should_return_true_info_when_one_book(){
        bookingRepo.save(booking);
        Booking result = bookingRepo.findById("0001").orElse(null);
        result.setState("已取件");
        List<Booking> bookingList = bookingRepo.findAll();
        assertEquals("已取件",bookingList.get(0).getState());
    }
}