package com.paypal.bfs.test.bookingserv.exceptions;

public class BadRequestException extends ServiceException{
    public BadRequestException(String message) {
        super(message, "BS-001");
    }
}
