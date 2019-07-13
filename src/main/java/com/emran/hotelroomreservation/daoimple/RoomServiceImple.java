/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.RoomService;
import com.emran.hotelroomreservation.model.Room;
import com.google.gson.Gson;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SARK
 */
@Repository
public class RoomServiceImple implements RoomService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addRoom(Room room) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(room);
        t.commit();
        s.close();
        return null;

//         Session s = sessionFactory.openSession();
//        Transaction t = s.getTransaction();
//        t.begin();
//        s.save(category);
//        t.commit();
//        s.close();
//        return null;
    }

    @Override
    public String deleteRoom(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room room = (Room) s.get(Room.class, id);
        s.delete(room);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllRoom() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Room> facilitylist = s.createQuery("from Room").list();
//        json class Gson object g
        Gson g = new Gson();
        String facilitylistgson = g.toJson(facilitylist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return facilitylistgson;
    }

    @Override
    public Room viewRoom(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room room = (Room) s.get(Room.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String roomgson = g.toJson(room);
        return room;
    }

    @Override
    public String updateRoom(int roomid, Room room) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room roomctobject = (Room) s.get(Room.class, roomid);
        roomctobject.setRoomid(room.getRoomid());
        roomctobject.setRoomtypeid(room.getRoomtypeid());
        roomctobject.setCatid(room.getCatid());
        roomctobject.setRoomnumber(room.getRoomnumber());
        roomctobject.setRoomrent(room.getRoomrent());

        s.update(roomctobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewsearchAllRoom(Room room) {

        return null;
    }

    @Override
    public String viewSingleRoom(int typeroom, String categoryroom, String c, String d) {
        System.out.println("method ex =============================");
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();

        // String hql = "SELECT r from Room r WHERE r.roomtypeid =:roomtypeid AND r.catid =:roomcategory";
        //String hql = "SELECT r from Room r WHERE r.roomtypeid =:roomtypeid AND r.catid =:roomcategory AND r.status = 'Empty'";
        String hql = "SELECT r from Room r WHERE r.roomtypeid =:roomtypeid AND r.catid =:roomcategory"
                + " AND not EXISTS (SELECT b from Roombooking b where b.startdate>=:startdate AND b.enddate <=:enddate) AND r.status = 'Empty' ";

        Query query = s.createQuery(hql);
//         query.setString("roomtypeid", typeroom);
        query.setInteger("roomtypeid", typeroom);
        query.setString("roomcategory", categoryroom);

        query.setString("startdate", c);
        query.setString("enddate", d);
        List<Room> roomlist = query.list();

//         ===============================
        if (roomlist.size() < 0) {
            Gson g = new Gson();
            String roomgson = g.toJson("No Room Found");
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + roomgson);
            return roomgson;
        } else {

            List<Room> roomAlllist = query.list();
            Gson g = new Gson();
            String roomlistgson = g.toJson(roomAlllist);
            System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffff" + roomlistgson);
            t.commit();
            s.close();
            return roomlistgson;

        }
//         ==================================

//        System.out.println(roomlist.get(0).getCatid()+ "888888888888");
//
//        Gson g = new Gson();
//        String roomlistgson = g.toJson(roomlist);
//        
//        t.commit();
//        s.close();
//        
//        return roomlistgson;
    }

    @Override
    public Room viewOneroom(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Room singleoneroom = (Room) s.get(Room.class, id);
        t.commit();
        s.close();
        return singleoneroom;
    }

}
