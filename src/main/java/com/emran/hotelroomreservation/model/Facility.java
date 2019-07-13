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
 * @author B2
 */
@Entity
public class Facility implements Serializable{
    
   
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
int facilityid ;
  String facilityname;
  
  int facilitycost;

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
  
}
