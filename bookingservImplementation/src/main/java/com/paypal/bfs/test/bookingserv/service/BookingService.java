package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public List<BookingEntity> getAll() {
        return repository.findAll();
    }

    public BookingEntity createBooking(BookingEntity bookingEntity){
        return repository.save(bookingEntity);
    }
}
