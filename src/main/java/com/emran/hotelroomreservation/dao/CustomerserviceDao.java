/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Customerservice;
import java.util.ArrayList;

/**
 *
 * @author SARK
 */
public interface CustomerserviceDao {
     public String addCustomerservice(Customerservice customerservice);
    public String updateCustomerservice(Customerservice customerservice);
    public String deleteCustomerservice( int serid);
    public String viewAllCustomerservice();
    public Customerservice viewCustomerservice(int serid);   

    public String addCustomerservice(ArrayList<Customerservice> servicedetail);
    
}
