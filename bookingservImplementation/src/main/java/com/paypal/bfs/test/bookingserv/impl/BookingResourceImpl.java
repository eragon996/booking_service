package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exceptions.BadRequestException;
import com.paypal.bfs.test.bookingserv.exceptions.ServiceException;
import com.paypal.bfs.test.bookingserv.pojo.Address;
import com.paypal.bfs.test.bookingserv.pojo.Booking;
import com.paypal.bfs.test.bookingserv.pojo.Bookings;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        validateBookingInput(booking);
        BookingEntity entity = new BookingEntity();

        entity.setFirstName(booking.getFirstName());
        entity.setLastName(booking.getLastName());
        entity.setDateOfBirth(booking.getDateOfBirth());
        entity.setCheckinDatetime(parseDateTime(booking.getCheckinDatetime()));
        entity.setCheckoutDatetime(parseDateTime(booking.getCheckoutDatetime()));
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
        //TODO: pagination and query params etc can be done here
        List<BookingEntity> bookings = bookingService.getAll();
        return new ResponseEntity<>(toBookings(bookings), HttpStatus.OK);
    }

    private Date parseDateTime(String date) {
        try {
            return DATE_TIME_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new BadRequestException("Wrongly formatted date. Expected format is " + DATE_TIME_FORMAT.toPattern());
        }
    }

    private String convertDateTimeToString(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    private Bookings toBookings(List<BookingEntity> bookingEntityList) {
        int n = bookingEntityList.size();
        Booking[] items = new Booking[n];
        for (int i = 0; i < n; i++) {
            items[i] = toBooking(bookingEntityList.get(i));
        }
        Bookings bookings = new Bookings();
        bookings.setItems(items);

        return bookings;
    }

    private Booking toBooking(BookingEntity bookingEntity) {
        Booking booking = new Booking();

        booking.setId(bookingEntity.getId());
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        booking.setDateOfBirth(bookingEntity.getDateOfBirth());
        booking.setCheckinDatetime(convertDateTimeToString(bookingEntity.getCheckinDatetime()));
        booking.setCheckoutDatetime(convertDateTimeToString(bookingEntity.getCheckoutDatetime()));
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

    private void validateBookingInput(Booking booking) {
        if (
                StringUtils.isNullOrEmpty(booking.getFirstName()) ||
                        StringUtils.isNullOrEmpty(booking.getLastName()) ||
                        booking.getTotalPrice() == null ||
                        booking.getAddress() == null ||
                        (booking.getAddress() != null && StringUtils.isNullOrEmpty(booking.getAddress().getLine1())

                        )) {
            throw new BadRequestException("First Name, last Name, Total price, deposit and address line 1 are  mandatory");
        }

        //TODO: more validating like valida zip code or state or city or checkin-in and check-out time can be added here


    }
}
