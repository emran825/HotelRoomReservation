/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;


import com.emran.hotelroomreservation.model.Roomtype;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public interface RoomtypeService {
    public String addRoomtype(Roomtype roomtype);
    public String updateRoomtype(Roomtype roomtype);
    public String deleteRoomtype(int id);
    public String viewAllRoomtype();
    public Roomtype viewRoomtype(int id); 
}
