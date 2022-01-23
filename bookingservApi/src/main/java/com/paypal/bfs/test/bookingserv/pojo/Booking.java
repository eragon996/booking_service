
package com.paypal.bfs.test.bookingserv.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin_datetime",
    "checkout_datetime",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("checkin_datetime")
    private String checkinDatetime;

    @JsonProperty("checkout_datetime")
    private String checkoutDatetime;

    @JsonProperty("total_price")
    private Double totalPrice;

    @JsonProperty("deposit")
    private Double deposit;

    @JsonProperty("address")
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCheckinDatetime() {
        return checkinDatetime;
    }

    public void setCheckinDatetime(String checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    public String getCheckoutDatetime() {
        return checkoutDatetime;
    }

    public void setCheckoutDatetime(String checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
