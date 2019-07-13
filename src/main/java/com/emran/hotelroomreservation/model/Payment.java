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
@Entity
public class Payment implements Serializable{
   // paymentid, bookingid, paymenttype, bookingamount, totalamount, paymentdate
 // paymentid, bookingid, paymenttype, payamount 
   @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
    int paymentid;
    int bookingid;
    String paymenttype;
    double bookingamount;
    double totalamount;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date paymentdate;
    // payamount;

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

 

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public double getBookingamount() {
        return bookingamount;
    }

    public void setBookingamount(double bookingamount) {
        this.bookingamount = bookingamount;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }
    
   
    
}
