/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.UserService;
import com.emran.hotelroomreservation.model.Customerinfo;
import com.emran.hotelroomreservation.model.User;
import com.emran.hotelroomreservation.model.Userrole;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UserServiceImple implements UserService{
//custid, cusname, emailid, nationality, phoneno, nid
     @Autowired
    SessionFactory sessionFactory;
    @Override
    public String addUser(User user) {
          String status;
        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.getTransaction();
            t.begin();
            Userrole role = new Userrole();
            role.setEmailid(user.getEmailid());
            role.setPassword(user.getPassword());
            
            Customerinfo cf = new Customerinfo();
            
            cf.setUsername(user.getUsername());
            cf.setEmailid(user.getEmailid());
            cf.setNationality(user.getNationality());
            cf.setPhone(user.getPhone());
            cf.setNid(user.getNid());

            s.save(user);
            s.save(role);
            s.save(cf);
            t.commit();
            s.close();
            status = "Success";
            //logger.info("End of insert user method in userservice impl");
        } catch (Exception e) {
            //logger.info("inside catch accept user method in userservice impl");
            e.printStackTrace();
            status = "Fail";
        }
        return status;
    }

    @Override
    public String updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteUser(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String viewAllUser() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<User> customerinfolist = s.createQuery("from User").list();
        Gson g = new Gson();
        String customerinfolistgson = g.toJson(customerinfolist);
        t.commit();
        s.close();
        return customerinfolistgson;
    }

    @Override
    public User viewUser(String id) {
        Session sc = sessionFactory.openSession();
        Transaction t = sc.getTransaction();
        t.begin();
        User us = (User) sc.get(User.class, id);
        t.commit();
        sc.close();
        //logger.info("end of view user method in userservice impl");
        return us;
    }
    
}
