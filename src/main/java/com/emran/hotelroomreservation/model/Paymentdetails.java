/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SARK
 */
@Entity
public class Paymentdetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int paymentid;
    int bookingid;
    int facilityid;
    double facilitycost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(int facilityid) {
        this.facilityid = facilityid;
    }

    public double getFacilitycost() {
        return facilitycost;
    }

    public void setFacilitycost(double facilitycost) {
        this.facilitycost = facilitycost;
    }

}
