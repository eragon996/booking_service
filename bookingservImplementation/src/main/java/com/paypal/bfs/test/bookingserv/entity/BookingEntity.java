package com.paypal.bfs.test.bookingserv.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Bookings")
public class BookingEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "checkin_datetime", nullable = false)
    private Date checkinDatetime;

    @Column(name = "checkout_datetime", nullable = false)
    private Date checkoutDatetime;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "deposit", nullable = false)
    private Double deposit;

    @Column(name = "address_line_1", nullable = false)
    private String  addressLine1;

    @Column(name = "address_line_2")
    private String  addressLine2;

    @Column(name = "address_city", nullable = false)
    private String  addressCity;

    @Column(name = "address_state", nullable = false)
    private String  addressState;

    @Column(name = "address_zip_code", nullable = false)
    private String  addressZipCode;

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

    public Date getCheckinDatetime() {
        return checkinDatetime;
    }

    public void setCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    public Date getCheckoutDatetime() {
        return checkoutDatetime;
    }

    public void setCheckoutDatetime(Date checkoutDatetime) {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
