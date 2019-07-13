/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Room;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author SARK
 */
@Service
public interface RoomService {
   public String addRoom(Room room);
   
   public String viewsearchAllRoom(Room room);

    public String updateRoom(int roomid, Room room);

    public String deleteRoom(int id);

    public String viewAllRoom();

    public Room viewRoom(int id);
    
    public String viewSingleRoom(int a,String b,String c,String d);
    
     public Room viewOneroom(int id);
    
      
    
}
