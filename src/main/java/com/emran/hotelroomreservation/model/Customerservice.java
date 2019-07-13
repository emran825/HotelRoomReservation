/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author SARK
 */
//serid, facilityid, servicedate, custid, bookingid
@Entity
public class Customerservice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int serid;
    int facilityid;

    int custid;
    int bookingid;

    public int getSerid() {
        return serid;
    }

    public void setSerid(int serid) {
        this.serid = serid;
    }

    public int getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(int facilityid) {
        this.facilityid = facilityid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    
}
