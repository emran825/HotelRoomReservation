/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.dao.UserService;
import com.emran.hotelroomreservation.model.Customerinfo;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerinfoController {
    @Autowired
    CustomerinfoService customerinfoService;
    @Autowired
    UserService userService;
    
      @RequestMapping("/customerinfo")
    public ModelAndView showproductpage() {
        String customerinfolist = customerinfoService.viewAllCustomerinfo();
        String userservicelist = userService.viewAllUser();
       
        //String supplierslist = sdao.viewSupplier();

        ModelAndView mv = new ModelAndView("addcustomerinfo", "newProductObject", new Customerinfo());
        mv.addObject("categoryList", customerinfolist);
        mv.addObject("roomtypeList", userservicelist);
       // mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
     @RequestMapping(value = "/addingcustomer", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Customerinfo customerinfo) {
        String eml = customerinfo.getEmailid();
        int cid = customerinfo.getCustid();
         System.out.println(eml+" ffffffffffffffffff"+cid);
       String custObject=customerinfoService .addCustomerinfo(customerinfo);
       if(custObject.equals("success")){
        return "redirect:/search";
       }
       return "redirect:/customerinfo";
    }
    
     @RequestMapping("removingcustomer/{atid}")
    public String removeproduct(@PathVariable("atid") int atid) {
        
        customerinfoService.deleteCustomerinfo(atid);
       
         return "redirect:/customerinfo";
    }
    
    
    
     @RequestMapping(value = "/addingcustomer", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject") Customerinfo customerinfo) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        customerinfoService.updateCustomerinfo(customerinfo);
         return "redirect:/customerinfo";
    }
    
    
    
    
      @RequestMapping("/editingcustomer")
    public ModelAndView editproductpage(@RequestParam("getcustid") int catid) {
         String customerinfolist = customerinfoService.viewAllCustomerinfo();
         
         String userservicelist = userService.viewAllUser();
       // String productlist = pdao.viewProduct();
        ModelAndView mv = new ModelAndView("addcustomerinfo", "newProductObject", customerinfoService.viewCustomerinfo(catid));
        mv.addObject("categoryList", customerinfolist);
        mv.addObject("roomtypeList", userservicelist);
               mv.addObject("check", "false");
        return mv;
    }
    
    
}
