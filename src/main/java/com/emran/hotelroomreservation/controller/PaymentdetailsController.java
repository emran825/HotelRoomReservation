/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.dao.PaymentService;
import com.emran.hotelroomreservation.dao.PaymentdetailsService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.model.Paymentdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SARK
 */
@Controller
public class PaymentdetailsController {
    @Autowired
    PaymentdetailsService paymentdetailsService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    RoombookingService roombookingService;
    @Autowired
    FacilityService facilityService;
    
          @RequestMapping("/Paymentdetailsinfo")
    public ModelAndView showproductpage() {
         String paymentdetailsinfo = paymentdetailsService.viewAllPaymentdetails();
        String paymentinfo = paymentService.viewAllPayment();
        String roombookinginfo = roombookingService.viewAllRoombooking();
        String facilityServiceinfo = facilityService.viewAllFacility();
        ModelAndView mv = new ModelAndView("addpaymentdetails", "newProductObject", new Paymentdetails());
         mv.addObject("paymentdetailsinfouser", paymentdetailsinfo);
        mv.addObject("paymentuser", paymentinfo);
        mv.addObject("roombookinglist", roombookinginfo);
        mv.addObject("facilityServiceinfolist", facilityServiceinfo);
       // mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping(value = "/addpaymentdetails", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Paymentdetails paymentdetails) {
        paymentdetailsService.addPaymentdetails(paymentdetails);
        return "redirect:/Paymentdetailsinfo";
    }
    
        @RequestMapping(value = "/addpaymentdetails", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject")Paymentdetails paymentdetails) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        paymentdetailsService.updatePaymentdetails(paymentdetails);
        return "redirect:/Paymentdetailsinfo";
    }
    
     @RequestMapping("removepaymentdetails/{Id}")
    public String removecategory(@PathVariable("Id") int id) {
        paymentdetailsService.deletePaymentdetails(id);
        return "redirect:/Paymentdetailsinfo";
    }
    
    
            @RequestMapping("/editingpaymentdetails")
    public ModelAndView editproductpage(@RequestParam("getpid") int id) {
        String paymentdetailsinfo = paymentdetailsService.viewAllPaymentdetails();
        String paymentinfo = paymentService.viewAllPayment();
        String roombookinginfo = roombookingService.viewAllRoombooking();
        String facilityServiceinfo = facilityService.viewAllFacility();
          ModelAndView mv = new ModelAndView("addpaymentdetails", "newProductObject", paymentdetailsService.viewPaymentdetails(id));
        mv.addObject("paymentdetailsinfouser", paymentdetailsinfo);
        mv.addObject("paymentuser", paymentinfo);
        mv.addObject("roombookinglist", roombookinginfo);
        mv.addObject("facilityServiceinfolist", facilityServiceinfo);
               mv.addObject("check", "false");
        return mv;
    }
}
