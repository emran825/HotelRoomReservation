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
//custid, fname, lname, emailid, nationality, phoneno, nid
@Entity
public class Customerinfo implements Serializable{
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  int custid;
  String username;
  String emailid;
  String nationality;
  String phone;
  String nid;

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  

   

   

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
  
  
}
