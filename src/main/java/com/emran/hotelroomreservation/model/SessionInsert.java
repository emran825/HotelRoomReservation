/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.model;

import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author SARK
 */
public class SessionInsert {

    String bookingid;
    String roomid;
    String roomtypeid;
    String custid;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date startdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date enddate;
    int numberofguest;
    String emailid;

    String roomtype;
    String catid;
    String catname;
    String roomnumber;
    double roomrent;
    String paymentid;

    String paymenttype;
    double bookingamount;
    double totalamount;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date paymentdate;

    String cusname;

    String nationality;
    String phoneno;
    String nid;
     String serid;
    String facilityid;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date servicedate;

    public SessionInsert(String bookingid, String roomid, String roomtypeid, String custid, Date startdate, Date enddate, int numberofguest, String emailid, String roomtype, String catid, String catname, String roomnumber, double roomrent, String paymentid, String paymenttype, double bookingamount, double totalamount, Date paymentdate, String cusname, String nationality, String phoneno, String nid, String serid, String facilityid, Date servicedate) {
        this.bookingid = bookingid;
        this.roomid = roomid;
        this.roomtypeid = roomtypeid;
        this.custid = custid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.numberofguest = numberofguest;
        this.emailid = emailid;
        this.roomtype = roomtype;
        this.catid = catid;
        this.catname = catname;
        this.roomnumber = roomnumber;
        this.roomrent = roomrent;
        this.paymentid = paymentid;
        this.paymenttype = paymenttype;
        this.bookingamount = bookingamount;
        this.totalamount = totalamount;
        this.paymentdate = paymentdate;
        this.cusname = cusname;
        this.nationality = nationality;
        this.phoneno = phoneno;
        this.nid = nid;
        this.serid = serid;
        this.facilityid = facilityid;
        this.servicedate = servicedate;
    }
    

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(String roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
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

    public int getNumberofguest() {
        return numberofguest;
    }

    public void setNumberofguest(int numberofguest) {
        this.numberofguest = numberofguest;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public double getRoomrent() {
        return roomrent;
    }

    public void setRoomrent(double roomrent) {
        this.roomrent = roomrent;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
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

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getSerid() {
        return serid;
    }

    public void setSerid(String serid) {
        this.serid = serid;
    }

    public String getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(String facilityid) {
        this.facilityid = facilityid;
    }

    public Date getServicedate() {
        return servicedate;
    }

    public void setServicedate(Date servicedate) {
        this.servicedate = servicedate;
    }

    @Override
    public String toString() {
        return "SessionInsert{" + "bookingid=" + bookingid + ", roomid=" + roomid + ", roomtypeid=" + roomtypeid + ", custid=" + custid + ", startdate=" + startdate + ", enddate=" + enddate + ", numberofguest=" + numberofguest + ", emailid=" + emailid + ", roomtype=" + roomtype + ", catid=" + catid + ", catname=" + catname + ", roomnumber=" + roomnumber + ", roomrent=" + roomrent + ", paymentid=" + paymentid + ", paymenttype=" + paymenttype + ", bookingamount=" + bookingamount + ", totalamount=" + totalamount + ", paymentdate=" + paymentdate + ", cusname=" + cusname + ", nationality=" + nationality + ", phoneno=" + phoneno + ", nid=" + nid + ", serid=" + serid + ", facilityid=" + facilityid + ", servicedate=" + servicedate + '}';
    }
   

}
