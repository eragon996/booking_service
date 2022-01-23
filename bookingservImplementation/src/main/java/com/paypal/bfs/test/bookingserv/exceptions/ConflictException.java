package com.paypal.bfs.test.bookingserv.exceptions;

public class ConflictException extends ServiceException{

    public ConflictException(String message) {
        super(message, "BS-002");
    }
}
