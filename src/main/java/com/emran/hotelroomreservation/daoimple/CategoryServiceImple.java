/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.daoimple;

import com.emran.hotelroomreservation.dao.CategoryService;
import com.emran.hotelroomreservation.model.Category;
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
public class CategoryServiceImple implements CategoryService{
     @Autowired
    SessionFactory sessionFactory;
    @Override
    public String addCategory(Category category) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(category);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateCategory(Category category) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(category);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteCategory(String id) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Category category = (Category) s.get(Category.class, id);
        s.delete(category);
        t.commit();
        s.close();

        return null;
    }
       

    @Override
    public String viewAllCategory() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Category> productslist = s.createQuery("from Category").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Category viewCategory(String id) {
          Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Category category = (Category) s.get(Category.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(category);
        return category;
    }
    
}
