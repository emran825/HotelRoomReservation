/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.model.Facility;
import com.emran.hotelroomreservation.model.Roomtype;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author B2
 */
@Repository
public class RoomtypeServiceImple implements RoomtypeService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addRoomtype(Roomtype roomtype) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(roomtype);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public String updateRoomtype(Roomtype roomtype) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(roomtype);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteRoomtype(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roomtype roomtype = (Roomtype) s.get(Roomtype.class, id);
        s.delete(roomtype);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllRoomtype() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Roomtype> roomtypelist = s.createQuery("from Roomtype").list();
//        json class Gson object g
        Gson g = new Gson();
        String roomtypelistgson = g.toJson(roomtypelist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return roomtypelistgson;
    }

    @Override
    public Roomtype viewRoomtype(int id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roomtype rm = (Roomtype) s.get(Roomtype.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(rm);
        return rm;
    }
    
}
