/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.CustomerserviceDao;
import com.emran.hotelroomreservation.model.Customerservice;
import com.google.gson.Gson;
import java.util.ArrayList;
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
public class CustomerserviceDaoImple implements CustomerserviceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addCustomerservice(Customerservice customerservice) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(customerservice);
        t.commit();
        s.close();
        return null;
    }
    
    @Override
    public String addCustomerservice(ArrayList<Customerservice> servicedetail) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        for (Customerservice customerservice : servicedetail) {
            s.save(customerservice);
        }
        
       // s.save(servicedetail);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateCustomerservice(Customerservice customerservice) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(customerservice);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteCustomerservice(int serid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerservice customerservice = (Customerservice) s.get(Customerservice.class, serid);
        s.delete(customerservice);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllCustomerservice() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customerservice> customerservicelist = s.createQuery("from Customerservice").list();
        Gson g = new Gson();
        String customerservicelistgson = g.toJson(customerservicelist);
        t.commit();
        s.close();
        return customerservicelistgson;
    }

    @Override
    public Customerservice viewCustomerservice(int serid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerservice customerservice = (Customerservice) s.get(Customerservice.class, serid);
        t.commit();
        s.close();
        Gson g = new Gson();
        String customerservicegson = g.toJson(customerservice);
        return customerservice;
    }

}
