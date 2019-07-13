/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.model.Facility;
import com.emran.hotelroomreservation.model.Roomtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B2
 */
@Controller
public class RoomtypeController {
   @Autowired 
 RoomtypeService roomtypeService;
   
   
    @RequestMapping("/showingroomtypepage")
    public ModelAndView showcatpage() {
        //viewAllRoomtype()method return Gson data and Gson data input roomtypegsonlist
        String roomtypegsonlist = roomtypeService.viewAllRoomtype();
        ModelAndView mv = new ModelAndView("addroomtype", "addCategoryObject1", new Roomtype());
       // facilitygsonlist input facilitymodelobject
        mv.addObject("roomtypemodelobject", roomtypegsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    //    Addcategory is Addbutton name line addcategory.jsp 181
//    addingroomtype is form action name  line addcategory.jsp 162

    @RequestMapping(value = "/addingroomtype", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCategoryObject1") Roomtype roomtype) {
        roomtypeService.addRoomtype(roomtype);
        return "redirect:/showingroomtypepage";
    }
    
    
     @RequestMapping("removeroomtype/{Id}")
    public String removecategory(@PathVariable("Id") int roomtypeid) {
        roomtypeService.deleteRoomtype(roomtypeid);
        return "redirect:/showingroomtypepage";
    }
    
     //form action and value/path name are same addingroomtype line 162 / 186
   // button name and params name are same EditCategory
    @RequestMapping(value = "/addingroomtype", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1")Roomtype roomtype) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        roomtypeService.updateRoomtype(roomtype);
        return "redirect:/showingroomtypepage";
    }
    
    
    
    @RequestMapping("/editroomtypebutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int roomtypeid) {

       Roomtype onecategory = roomtypeService.viewRoomtype(roomtypeid);
        String categorygsonlist = roomtypeService.viewAllRoomtype();
        ModelAndView mv = new ModelAndView("addroomtype", "addCategoryObject1", onecategory);
        mv.addObject("roomtypemodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
 
}
