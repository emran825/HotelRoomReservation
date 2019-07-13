/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.model.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B2
 */
@Controller
public class FacilityController {

    @Autowired
    FacilityService facilityService;
    
    
    @RequestMapping("/showingcategorypage")
    public ModelAndView showcatpage() {
        //viewAllFacility()method return Gson data and Gson data input facilitygsonlist
        String facilitygsonlist = facilityService.viewAllFacility();
        ModelAndView mv = new ModelAndView("addFacility", "addCategoryObject1", new Facility());
       // facilitygsonlist input facilitymodelobject
        mv.addObject("facilitymodelobject", facilitygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
//    Addcategory is Addbutton name line addFacility.jsp 181
//    addingcategory is form action name  line addFacility.jsp 162

    @RequestMapping(value = "/addingcategory", params = "Addcategory")
    public String addFacility(@ModelAttribute("addCategoryObject1") Facility facility) {
        facilityService.addFacility(facility);
        return "redirect:/showingcategorypage";
    }
    
    //form action and value/path name are same addingcategory line 162 / 187
   // button name and params name are same EditCategory
    @RequestMapping(value = "/addingcategory", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1")Facility facility) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        facilityService.updateFacility(facility);
        return "redirect:/showingcategorypage";
    }
    
    
     @RequestMapping("/editcategorybutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int facilityid) {

       Facility onecategory = facilityService.viewFacility(facilityid);
        String categorygsonlist = facilityService.viewAllFacility();
        ModelAndView mv = new ModelAndView("addFacility", "addCategoryObject1", onecategory);
        mv.addObject("facilitymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    
    
     @RequestMapping("removecategory/{Id}")
    public String removecategory(@PathVariable("Id") int facilityid) {
        facilityService.deleteFacility(facilityid);
        return "redirect:/showingcategorypage";
    }
    
    


//    @RequestMapping(value = "/")
//    public String helloMessage(ModelMap map) {
//        map.addAttribute("hello", "Hello Spring MVC");
//        return "index";
//    }
}
