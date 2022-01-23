package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.pojo.Address;
import com.paypal.bfs.test.bookingserv.pojo.Booking;
import com.paypal.bfs.test.bookingserv.pojo.Bookings;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingService bookingService;

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        // validate
        BookingEntity entity = new BookingEntity();

        entity.setFirstName(booking.getFirstName());
        entity.setLastName(booking.getLastName());
        entity.setDateOfBirth(booking.getDateOfBirth());
        try {
            entity.setCheckinDatetime(DATE_TIME_FORMAT.parse(booking.getCheckinDatetime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            entity.setCheckoutDatetime(DATE_TIME_FORMAT.parse(booking.getCheckoutDatetime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //entity.setCheckoutDatetime(booking.getCheckoutDatetime());
        entity.setTotalPrice(booking.getTotalPrice());
        entity.setDeposit(booking.getDeposit());

        entity.setAddressLine1(booking.getAddress().getLine1());
        entity.setAddressLine2(booking.getAddress().getLine2());
        entity.setAddressCity(booking.getAddress().getCity());
        entity.setAddressState(booking.getAddress().getState());
        entity.setAddressZipCode(booking.getAddress().getZipCode());

        entity = bookingService.createBooking(entity);

        booking.setId(entity.getId());

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Bookings> getAllBookings() {
        List<BookingEntity> bookings = bookingService.getAll();
        return new ResponseEntity<>(toBookings(bookings), HttpStatus.OK);
    }

//    private Timestamp parseDateTime(Date date){
//        try {
//            return new Timestamp(DATE_TIME_FORMAT.parse(date).getTime());
//        } catch (ParseException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

    private Bookings toBookings(List<BookingEntity> bookingEntityList){
        int n = bookingEntityList.size();
        Booking[] items = new Booking[n];
        for(int i = 0 ; i < n ; i++){
            items[i] = toBooking(bookingEntityList.get(i));
        }
        Bookings bookings = new Bookings();
        bookings.setItems(items);

        return bookings;
    }

    private Booking toBooking(BookingEntity bookingEntity){
        Booking booking = new Booking();

        booking.setId(bookingEntity.getId());
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        booking.setDateOfBirth(bookingEntity.getDateOfBirth());
        //booking.setCheckinDatetime(bookingEntity.getCheckinDatetime());
        //booking.setCheckoutDatetime(bookingEntity.getCheckoutDatetime());
        booking.setTotalPrice(bookingEntity.getTotalPrice());
        booking.setDeposit(bookingEntity.getDeposit());
        Address address = new Address();
        address.setLine1(bookingEntity.getAddressLine1());
        address.setLine2(bookingEntity.getAddressLine2());
        address.setCity(bookingEntity.getAddressCity());
        address.setState(bookingEntity.getAddressState());
        address.setZipCode(bookingEntity.getAddressZipCode());

        booking.setAddress(address);


        return booking;
    }
}
