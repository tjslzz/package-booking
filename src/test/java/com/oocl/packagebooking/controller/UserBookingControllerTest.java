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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserBookingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookingRepo bookingRepo;

    @Test
    public void should_return_list_when_get_list() throws Exception {
        Booking temp = new Booking("0001","jerryLi","18229797216","未取件","2019-01-01");
        Optional<Booking> booking = Optional.of(temp);
        when(bookingRepo.findById("0001")).thenReturn(booking);
        mockMvc.perform(put("/user/book-id/0001").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("2019-01-02"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}