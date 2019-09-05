/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.model.Roombooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admincontroller {

    @Autowired
    RoombookingService roombookingService;

    @Autowired
    CustomerinfoService customerinfoService;

    @RequestMapping("/showBookingInfo")
    public ModelAndView showcatpage() {
        System.out.println("Start==========================");

        //viewAllFacility()method return Gson data and Gson data input facilitygsonlist
        String roombookingList = roombookingService.showAllRoombookinfo();
        
        System.out.println("CCCCCCCCCCCCCCCCCCC " + roombookingList);
        //====================GSON======================
//        Gson g = new Gson();
//        String customerinfolistgson = g.toJson(roombookingList);
        //====================================================

        //================CUST ID=================================
//        Roombooking r = new Roombooking();
////        Array a = (Array) new Roombooking();
////        System.out.println(a+"           ");
//        System.out.println(r.getBookingid()+"  "+r.getEnddate()+"  dfdfdfdfffdffdff      ");
//        
//        
//       
//        int custid = r.getCustid();
//      
//       Customerinfo n = customerinfoService.showcusname(custid );
//        System.out.println(n.getUsername()+" NNNNNNNNNNNNNNNNNNNNNNNNNNN");
//        session.setAttribute("name", n.getUsername());
//        System.out.println("SSSSSSSSSSS "+session.getAttribute("customerinfo"));
//        System.out.println(custid + "Cu=============");
        //========================================================
        System.out.println("End===========================");
        ModelAndView mv = new ModelAndView("adminBookinginf", "addCategoryObject1", new Roombooking());

        // facilitygsonlist input facilitymodelobject
        //=============OK 
        mv.addObject("roombookingListobject", roombookingList);

        // mv.addObject("roombookingListobject", customerinfolistgson);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("delete/{bid}")
    public String removeproduct(@PathVariable("bid") int atid) {
        roombookingService.admindelete(atid);
        return "redirect:/showBookingInfo";
    }
}
