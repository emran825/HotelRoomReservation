/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.model.Roombooking;
import com.google.gson.Gson;
import java.util.List;
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
public class RoombookingServiceImple implements RoombookingService{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public String addRoombooking(Roombooking roombooking) {
        Session s =  sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(roombooking);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateRoombooking(Roombooking roombooking) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(roombooking);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteRoombooking(int id) {
    Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roombooking roombooking= (Roombooking) s.get(Roombooking.class, id);
        s.delete(roombooking);
        t.commit();
        s.close();

        return null;     
    }

    @Override
    public String viewAllRoombooking() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Roombooking> roombookinglist = s.createQuery("from Roombooking").list();
        Gson g = new Gson();
        String customerinfolistgson = g.toJson(roombookinglist);
        t.commit();
        s.close();
        return customerinfolistgson;
    }

    @Override
    public Roombooking viewRoom(int id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Roombooking roombooking = (Roombooking) s.get(Roombooking.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(roombooking);
        return roombooking;
    }
    
    @Override
    public String viewAllRoombookin(String roomtype,String roomcategory,String c,String d) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
      //  List<Roombooking> roombookinglist = s.createQuery("from Roombooking").list();
        List<Roombooking> roombookinglist = s.createQuery("SELECT * from Room where roomtypeid = '"+roomtype+"' and catid = '"+roomcategory+"'  ").list();
        
//        SELECT roomno FROM tbl_ReservedRooms WHERE ((fromdate BETWEEN @checkindate AND @checkoutdate )
//OR (todate BETWEEN @checkindate AND @checkoutdate)) 
//AND status = 'Active'
        
        Gson g = new Gson();
        String customerinfolistgson = g.toJson(roombookinglist);
        t.commit();
        s.close();
        return customerinfolistgson;
    }

    
    
}
