/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CategoryService;
import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.model.Category;
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
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    RoomtypeService roomtypeService;
    
    
     @RequestMapping("/roomcategory")
    public ModelAndView showproductpage() {
        String categorylist = categoryService.viewAllCategory();
        String roomtypelist = roomtypeService.viewAllRoomtype();
        //String supplierslist = sdao.viewSupplier();

        ModelAndView mv = new ModelAndView("addroomcategory", "newProductObject", new Category());
        mv.addObject("categoryList", categorylist);
        mv.addObject("roomtypeList", roomtypelist);
       // mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
     @RequestMapping(value = "/addingcategory", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Category category) {
        categoryService.addCategory(category);
        return "redirect:/roomcategory";
    }
    
    
     @RequestMapping(value = "/addingcategory", params = "Edit")
    public String editcategory(@ModelAttribute("addCategoryObject1")Category category) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        categoryService.updateCategory(category);
        return "redirect:/roomcategory";
    }
    
    
    
    
      @RequestMapping("/editingproduct")
    public ModelAndView editproductpage(@RequestParam("getcatid") String catid) {
         String categorylist = categoryService.viewAllCategory();
        String roomtypelist = roomtypeService.viewAllRoomtype();;
       // String productlist = pdao.viewProduct();
        ModelAndView mv = new ModelAndView("addroomcategory", "newProductObject", categoryService.viewCategory(catid));
        mv.addObject("categoryList", categorylist);
        mv.addObject("roomtypeList", roomtypelist);
               mv.addObject("check", "false");
        return mv;
    }
     @RequestMapping("removingproduct/{atid}")
    public String removeproduct(@PathVariable("atid") String atid) {
        categoryService.deleteCategory(atid);
        return "redirect:/roomcategory";
    }

}
