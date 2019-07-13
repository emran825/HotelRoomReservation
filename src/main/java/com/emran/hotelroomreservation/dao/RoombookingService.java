/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Roombooking;

/**
 *
 * @author SARK
 */
public interface RoombookingService {
     public String addRoombooking(Roombooking roombooking);
    public String updateRoombooking(Roombooking roombooking);
    public String deleteRoombooking(int id);
    public String viewAllRoombooking();
    public String viewAllRoombookin(String a,String b,String c,String d);
    public Roombooking viewRoom(int id);   
}
