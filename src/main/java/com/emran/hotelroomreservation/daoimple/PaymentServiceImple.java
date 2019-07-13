/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.PaymentService;
import com.emran.hotelroomreservation.model.Payment;
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
public class PaymentServiceImple implements PaymentService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addPayment(Payment payment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(payment);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePayment(Payment payment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(payment);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePayment(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment payment = (Payment) s.get(Payment.class, id);
        s.delete(payment);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllPayment() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> paymentlist = s.createQuery("from Payment").list();
        Gson g = new Gson();
        String paymentlistgson = g.toJson(paymentlist);
        t.commit();
        s.close();
        return paymentlistgson;
    }

    @Override
    public Payment viewPayment(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment payment = (Payment) s.get(Payment.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String paymentgson = g.toJson(payment);
        return payment;
    }
}
