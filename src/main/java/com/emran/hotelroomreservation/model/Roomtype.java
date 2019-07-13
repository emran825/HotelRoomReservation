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
public class Roomtype implements Serializable{
   @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
    int roomtypeid;
    String roomtype;

    public int getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(int roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

   
    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
}
