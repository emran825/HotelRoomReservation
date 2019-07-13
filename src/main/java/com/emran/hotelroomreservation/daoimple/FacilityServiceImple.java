/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.model.Facility;
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
public class FacilityServiceImple implements FacilityService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addFacility(Facility facility) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(facility);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateFacility(Facility facility) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(facility);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteFacility(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Facility facility = (Facility) s.get(Facility.class, id);
        s.delete(facility);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllFacility() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Facility> facilitylist = s.createQuery("from Facility").list();
//        json class Gson object g
        Gson g = new Gson();
        String facilitylistgson = g.toJson(facilitylist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return facilitylistgson;
    }

    @Override
    public Facility viewFacility(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Facility cm = (Facility) s.get(Facility.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }
    
}
