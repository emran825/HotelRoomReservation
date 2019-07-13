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
public class Roombooking implements Serializable{
   // bookingid, roomid, roomtypeid, custid, startdate, enddate, numberofguest, emailid
   // bookingid, roomid, roomtypeid, custid, startdate, enddate, numberofguest, emailid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bookingid;
  int roomid;
  int roomtypeid;
    int custid;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date startdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date enddate;
   
    String emailid;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }
    

//    public int getRoomid() {
//        return roomid;
//    }
//
//    public void setRoomid(int roomid) {
//        this.roomid = roomid;
//    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

   

    public int getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(int roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

   

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    
}
