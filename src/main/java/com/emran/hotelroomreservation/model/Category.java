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
public class Category implements Serializable {
// catid, roomtypeid, catname  
  @Id
  
    String catid;
    int roomtypeid;
    String catname;

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public int getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(int roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
    
}
