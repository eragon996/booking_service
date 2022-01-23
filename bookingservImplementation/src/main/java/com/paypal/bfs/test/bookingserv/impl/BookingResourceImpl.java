package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.pojo.Booking;
import com.paypal.bfs.test.bookingserv.pojo.Bookings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        return null;
    }

    @Override
    public ResponseEntity<Bookings> getAllBookings() {
        return null;
    }
}
