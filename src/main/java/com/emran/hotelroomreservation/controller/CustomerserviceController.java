/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.dao.CustomerserviceDao;
import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.model.Customerservice;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerserviceController {

    @Autowired
    CustomerserviceDao customerserviceDao;
    @Autowired
    FacilityService facilityService;
    @Autowired
    CustomerinfoService customerinfoService;
    @Autowired
    RoombookingService roombookingService;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "servicedate", new CustomDateEditor(format, false));
//         SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
//        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format1, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/customerservice")
    public ModelAndView showproductpage() {
        String customerserviceDaoList = customerserviceDao.viewAllCustomerservice();
        String facilityList = facilityService.viewAllFacility();
        String customerinfoList = customerinfoService.viewAllCustomerinfo();
        String roombookingList = roombookingService.viewAllRoombooking();
        ModelAndView mv = new ModelAndView("addcustomerservice", "newProductObject", new Customerservice());
        mv.addObject("customerserviceDaolist", customerserviceDaoList);
        mv.addObject("facilitylist", facilityList);
        mv.addObject("customerinfolist", customerinfoList);
        mv.addObject("roombookinglist", roombookingList);
        mv.addObject("check", "true");
        return mv;
    }
    
//     @RequestMapping("/showproductpage")
//    public ModelAndView showproductpage() {
//        String productlist = pdao.viewProduct();
//        String categorygsonlist = cdao.viewCategory();
//        String supplierslist = sdao.viewSupplier();
//
//        ModelAndView mv = new ModelAndView("addproduct", "newProductObject", new Product());
//        mv.addObject("productlist", productlist);
//        mv.addObject("supplierslist", supplierslist);
//        mv.addObject("categorymodelobject", categorygsonlist);
//        mv.addObject("check", "true");
//        return mv;
//    }
    
    
    
    

    @RequestMapping(value = "/addingcustomerservice", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Customerservice customerservice) {
        customerserviceDao.addCustomerservice(customerservice);
        return "redirect:/customerservice";
    }
    
    
    
      @RequestMapping("removingcustomerservice/{atid}")
    public String removeproduct(@PathVariable("atid") int atid) {
        customerserviceDao.deleteCustomerservice(atid);
       return "redirect:/customerservice";
    }
    
       @RequestMapping(value = "/addingcustomerservice", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject") Customerservice customerservice) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        customerserviceDao.updateCustomerservice(customerservice);
        return "redirect:/customerservice";
    }
    
    
    
        @RequestMapping("/editingcustomerservice")
    public ModelAndView editproductpage(@RequestParam("getcustomerserviceid") int serid) {
       String customerserviceDaoList = customerserviceDao.viewAllCustomerservice();
        String facilityList = facilityService.viewAllFacility();
        String customerinfoList = customerinfoService.viewAllCustomerinfo();
        String roombookingList = roombookingService.viewAllRoombooking();
       // String productlist = pdao.viewProduct();
        ModelAndView mv =  new ModelAndView("addcustomerservice", "newProductObject", customerserviceDao.viewCustomerservice(serid));
   mv.addObject("customerserviceDaolist", customerserviceDaoList);
        mv.addObject("facilitylist", facilityList);
        mv.addObject("customerinfolist", customerinfoList);
        mv.addObject("roombookinglist", roombookingList);
               mv.addObject("check", "false");
        return mv;
    }
   // ===================*****************======================================
    
        @RequestMapping("/viewproduct")
    public ModelAndView viewproductdata(@RequestParam("getId") int serid, HttpSession session) {
        Gson g = new Gson();
        String cusservice = g.toJson(customerserviceDao.viewCustomerservice(serid));
        //session.setAttribute("productid", productid);
        ModelAndView mv = new ModelAndView("viewcfacility");
        mv.addObject("pro", cusservice);
        return mv;
    }

}
