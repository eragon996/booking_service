package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exceptions.ConflictException;
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
        BookingEntity entity = repository.findByFirstAndLastName(bookingEntity.getFirstName(),bookingEntity.getLastName());
        if(entity != null){
            throw new ConflictException("Booking already exist for "+bookingEntity.getFirstName()+" "+bookingEntity.getLastName());
        }
        return repository.save(bookingEntity);
    }
}
