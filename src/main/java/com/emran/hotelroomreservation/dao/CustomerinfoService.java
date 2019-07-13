/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Customerinfo;

/**
 *
 * @author SARK
 */
public interface CustomerinfoService {
     public String addCustomerinfo(Customerinfo customerinfo);
    public String updateCustomerinfo(Customerinfo customerinfo);
    public String deleteCustomerinfo(int id);
    public String viewAllCustomerinfo();
    public Customerinfo viewCustomerinfo(int id); 
       public Customerinfo showOneTeacherbyEmail(String email);
    
    
}
