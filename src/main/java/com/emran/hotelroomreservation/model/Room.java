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
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author SARK
 */
@Entity
public class Room implements Serializable {
    // roomid, roomtypeid, catid, roomnumber

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int roomid;
    int roomtypeid;
    String roomtype;
    String catid;
    String catname;
    String roomnumber;
    double roomrent;
    @Transient
    MultipartFile stimage;
    String status = "Empty";

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getStatus() {
        return status;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public MultipartFile getStimage() {
        return stimage;
    }

    public void setStimage(MultipartFile stimage) {
        this.stimage = stimage;
    }

    public double getRoomrent() {
        return roomrent;
    }

    public void setRoomrent(double roomrent) {
        this.roomrent = roomrent;
    }

    public int getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(int roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

}
