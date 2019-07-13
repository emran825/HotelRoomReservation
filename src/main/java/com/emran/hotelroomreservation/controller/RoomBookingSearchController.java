/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CategoryService;
import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.dao.RoomService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.dao.UserService;
import com.emran.hotelroomreservation.model.Room;
import com.emran.hotelroomreservation.model.Roombooking;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class RoomBookingSearchController {
     @Autowired
    RoombookingService roombookingService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomtypeService roomtypeService;
    @Autowired
    CustomerinfoService customerinfoService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "startdate", new CustomDateEditor(format, false));
         SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format1, false));
        
         
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
          @RequestMapping("/booking")
    public ModelAndView showproductpage() {

        String roombookingList = roombookingService.viewAllRoombooking();
        String roomselect = roomService.viewAllRoom();
      
        String roomtypeList = roomtypeService.viewAllRoomtype();
        String customerinfoList = customerinfoService.viewAllCustomerinfo();
        String userserviceList = userService.viewAllUser();
        //String supplierslist = sdao.viewSupplier();
        ModelAndView mv = new ModelAndView("searchandbooking", "newProductObject", new Roombooking());
         mv.addObject("roombookinglist", roombookingList);
         mv.addObject("roomservicename", roomselect);
        mv.addObject("rList", roomtypeList);
        mv.addObject("customerinfolist", customerinfoList);
        mv.addObject("userservicelist", userserviceList);
       // mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
         @RequestMapping(value = "/roombook", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Roombooking roombooking) {
       roombookingService .addRoombooking(roombooking);
       return "redirect:/booking";
    }
   
    
    
     @RequestMapping("removebook/{atid}")
    public String removeproduct(@PathVariable("atid") int atid) {
        roombookingService.deleteRoombooking(atid);
         return "redirect:/booking";
    }
    
    
    
     @RequestMapping(value = "/roombook", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject") Roombooking roombooking) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        roombookingService.updateRoombooking(roombooking);
        return "redirect:/booking";
    }
    
    
    
    
      @RequestMapping("/ebooking")
    public ModelAndView editproductpage(@RequestParam("book") int bookingid) {
        String roombookingList = roombookingService.viewAllRoombooking();
        String roomselect = roomService.viewAllRoom();
        String roomtypeList = roomtypeService.viewAllRoomtype();
        String customerinfoList = customerinfoService.viewAllCustomerinfo();
        String userserviceList = userService.viewAllUser();
       // String productlist = pdao.viewProduct();
        ModelAndView mv = new ModelAndView("searchandbooking", "newProductObject", roombookingService.viewRoom(bookingid));
        mv.addObject("roombookinglist", roombookingList);
         mv.addObject("roomservicename", roomselect);
        mv.addObject("rList", roomtypeList);
        mv.addObject("customerinfolist", customerinfoList);
        mv.addObject("userservicelist", userserviceList);
               mv.addObject("check", "false");
        return mv;
    }
    


    
  

}


