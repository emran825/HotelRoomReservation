/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Payment;

/**
 *
 * @author SARK
 */
public interface PaymentService {

    public String addPayment(Payment payment);

    public String updatePayment(Payment payment);

    public String deletePayment(int id);

    public String viewAllPayment();

    public Payment viewPayment(int id);
}
