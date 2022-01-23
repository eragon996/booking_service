package com.paypal.bfs.test.bookingserv.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bookings {

    @JsonProperty("items")
    private Booking[] items;

    public Booking[] getItems() {
        return items;
    }

    public void setItems(Booking[] items) {
        this.items = items;
    }
}
