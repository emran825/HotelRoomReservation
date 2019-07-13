/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Paymentdetails;
import java.util.ArrayList;

/**
 *
 * @author SARK
 */
public interface PaymentdetailsService {
    
    
    
    public String addPaymentdetails(Paymentdetails paymentdetails);

    public String updatePaymentdetails(Paymentdetails paymentdetails);

    public String deletePaymentdetails(int id);

    public String viewAllPaymentdetails();

    public Paymentdetails viewPaymentdetails(int id);
    
  

    public String addlistPaymentdetails(ArrayList<Paymentdetails> paymentdetails);
    
}
