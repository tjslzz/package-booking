package com.oocl.packagebooking.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.oocl.packagebooking.entity.Booking;
import com.oocl.packagebooking.repo.BookingRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BossBookingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookingRepo bookingRepo;

    private List<Booking> bookings;
    @Before
    public void setUp(){
        Booking booking = new Booking("0001","jerryLi","18229797216","未取件","2019-01-01");
    }


    @Test
    public void should_return_list_when_get_list() throws Exception {
        when(bookingRepo.findAll()).thenReturn(bookings);
        mockMvc.perform(get("/boss").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void should_return_list_when_put_book() throws Exception {
        when(bookingRepo.findAll()).thenReturn(bookings);
        mockMvc.perform(put("/boss/id/0001").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}