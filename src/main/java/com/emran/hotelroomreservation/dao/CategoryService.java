/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Category;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public interface CategoryService {
   public String addCategory(Category category);
    public String updateCategory(Category category);
    public String deleteCategory(String id);
    public String viewAllCategory();
    public Category viewCategory(String id);   
    
    
}
