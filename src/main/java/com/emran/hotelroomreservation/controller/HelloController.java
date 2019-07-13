/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B2
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String helloMessage(ModelMap map) {
        map.addAttribute("hello", "Hello Spring MVC");
        return "index2";
    }
    
    @RequestMapping(value = "/about")
    public String aboutPage(ModelMap map) {
        return "about";
    }

     @RequestMapping(value = "/accomodation")
    public String accomodationPage(ModelMap map) {
        return "accomodation";
    }
    
     @RequestMapping(value = "/gallery")
    public String galleryPage(ModelMap map) {
        return "gallery";
    }
    
     @RequestMapping(value = "/contact")
    public String contactPage(ModelMap map) {
        return "contact";
    }

}
