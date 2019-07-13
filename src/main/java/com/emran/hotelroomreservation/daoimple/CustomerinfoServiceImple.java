/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.model.Customerinfo;
import com.google.gson.Gson;
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
public class CustomerinfoServiceImple implements CustomerinfoService{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public String addCustomerinfo(Customerinfo customerinfo) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(customerinfo);
        t.commit();
        s.close();
        return "success";
    }

    @Override
    public String updateCustomerinfo(Customerinfo customerinfo) {
           Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(customerinfo);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteCustomerinfo(int id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo customerinfo= (Customerinfo) s.get(Customerinfo.class, id);
        s.delete(customerinfo);
        t.commit();
        s.close();

        return null;
    }

    

    @Override
    public Customerinfo viewCustomerinfo(int id) {
           Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo customerinfo = (Customerinfo) s.get(Customerinfo.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(customerinfo);
        return customerinfo;
    }

    @Override
    public String viewAllCustomerinfo() {
               Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customerinfo> customerinfolist = s.createQuery("from Customerinfo").list();
        Gson g = new Gson();
        String customerinfolistgson = g.toJson(customerinfolist);
        t.commit();
        s.close();
        return customerinfolistgson;
    }
    
    @Override
    public Customerinfo showOneTeacherbyEmail(String email) {
        Session s = sessionFactory.openSession();
        Customerinfo teinfo = new Customerinfo();
        Transaction t = s.getTransaction();
        t.begin();
        Query q = s.createQuery(" select u from Customerinfo u where emailid=?");

        List<Customerinfo> sinfo = q.setParameter(0, email).list();

        t.commit();
        s.close();
        return sinfo.get(0);
    }
    
}
