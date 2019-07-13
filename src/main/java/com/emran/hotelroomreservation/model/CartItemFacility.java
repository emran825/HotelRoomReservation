/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.model;

/**
 *
 * @author SARK
 */
public class CartItemFacility {
   int facilityid ;
   String facilityname;
   int facilitycost;
//   int qty = 1;
//    double total;

    public CartItemFacility(int facilityid, String facilityname, int facilitycost) {
        this.facilityid = facilityid;
        this.facilityname = facilityname;
        this.facilitycost = facilitycost;
    }

    public CartItemFacility() {
    }

    public int getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(int facilityid) {
        this.facilityid = facilityid;
    }

    public String getFacilityname() {
        return facilityname;
    }

    public void setFacilityname(String facilityname) {
        this.facilityname = facilityname;
    }

    public int getFacilitycost() {
        return facilitycost;
    }

    public void setFacilitycost(int facilitycost) {
        this.facilitycost = facilitycost;
    }

    @Override
    public String toString() {
        return "Cart{" + "facilityid=" + facilityid + ", facilityname=" + facilityname + ", facilitycost=" + facilitycost + '}';
    }

   
    
   
   
}
