/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.PaymentdetailsService;
import com.emran.hotelroomreservation.model.Paymentdetails;
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
public class PaymentdetailsServiceImple implements PaymentdetailsService{
     @Autowired
    SessionFactory sessionFactory;
    @Override
    public String addPaymentdetails(Paymentdetails paymentdetails) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(paymentdetails);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePaymentdetails(Paymentdetails paymentdetails) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(paymentdetails);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePaymentdetails(int id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Paymentdetails paymentdetails = (Paymentdetails) s.get(Paymentdetails.class, id);
        s.delete(paymentdetails);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllPaymentdetails() {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Paymentdetails> paymentdetailslist = s.createQuery("from Paymentdetails").list();
        Gson g = new Gson();
        String paymentdetailslistgson = g.toJson(paymentdetailslist);
        t.commit();
        s.close();
        return paymentdetailslistgson;
    }

    @Override
    public Paymentdetails viewPaymentdetails(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Paymentdetails paymentdetails = (Paymentdetails) s.get(Paymentdetails.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String paymentgson = g.toJson(paymentdetails);
        return paymentdetails;
    }

    @Override
    public String addlistPaymentdetails(ArrayList<Paymentdetails> paymentdetails) {
            Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for (Paymentdetails payd : paymentdetails) {
            s.save(payd);
        }
        t.commit();
        s.close();
        return null;
    }
    
}
