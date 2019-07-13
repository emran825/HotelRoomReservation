/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CategoryService;
import com.emran.hotelroomreservation.dao.RoomService;
import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.model.Room;
import com.google.gson.Gson;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SARK
 */
@Controller
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomtypeService roomtypeService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ServletContext servletContext;

//    public void initBinder(WebDataBinder binder){
//         SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//        binder.registerCustomEditor(Date.class, "purchasedate", new CustomDateEditor(format, false));
//    }
      @RequestMapping("/roomadd")
    public ModelAndView showAllRoom() {
        String roomselect = roomService.viewAllRoom();
        String roomtypeall = roomtypeService.viewAllRoomtype();
        String categoryall = categoryService.viewAllCategory();
        ModelAndView mv = new ModelAndView("addroom", "newProductObject", new Room());
        mv.addObject("roomservicename", roomselect);
        mv.addObject("roomtypeList", roomtypeall);
        mv.addObject("categoryList", categoryall);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addroomname", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Room room, HttpServletRequest request) {
        roomService.addRoom(room);
        
        
      String path = servletContext.getRealPath("/");
        System.out.println(path);
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut2 = targetcut.substring(0, targetcut.lastIndexOf("\\"));
        //System.out.println(targetcut2+".......");
        //System.out.println(request.getSession().getServletContext());
        //String p = servletContext.getContextPath();
        String p = targetcut2 + "\\src\\main\\webapp\\resources\\imgr\\" + String.valueOf(room.getRoomid()) + "" + ".jpg";
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        System.out.println(p);
        MultipartFile filedet = room.getStimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
      
        
        return "redirect:/roomadd";
    }
    

    @RequestMapping("removinroomname/{atid}")
    public String removeproduct(@PathVariable("atid") int atid) {
        roomService.deleteRoom(atid);
        return "redirect:/roomadd";
    }
    
    
    @RequestMapping(value = "/addroomname", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject")Room room, HttpServletRequest request) {

        roomService.updateRoom(room.getRoomid(),room);
       String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut2 = targetcut.substring(0, targetcut.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut2 + "\\src\\main\\webapp\\resources\\imgr\\" + String.valueOf(room.getRoomid()) + "" + ".jpg";
        MultipartFile filedet = room.getStimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                File f = new File(p);
                if (f.exists()) {
                    f.delete();
                    FileOutputStream fos = new FileOutputStream(f);
                    BufferedOutputStream bs = new BufferedOutputStream(fos);
                    bs.write(bytes);
                    bs.close();
                    fos.close();
                    Thread.sleep(10000);
                    System.out.println("File Uploaded Successfully");
                }
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
       return "redirect:/roomadd";
    }
    
    
    
    
         
      @RequestMapping("/editingroomname")
    public ModelAndView editproductpage(@RequestParam("getroom") int roomid,HttpSession session) {
          String roomselect = roomService.viewAllRoom();
        String roomtypeall = roomtypeService.viewAllRoomtype();
        String categoryall = categoryService.viewAllCategory();
         session.setAttribute("roomid", roomid);
        ModelAndView mv = new ModelAndView("addroom", "newProductObject",roomService.viewRoom(roomid));
       // String productlist = pdao.viewProduct();
        
        mv.addObject("roomservicename", roomselect);
        mv.addObject("roomtypeList", roomtypeall);
        mv.addObject("categoryList", categoryall);
        mv.addObject("check", "false");
        return mv;
    }
    
    
//    @RequestMapping("/roomprofilelink")
//    public ModelAndView passingoneEmployee(@RequestParam("getsid") int roomid) {
//        Room singlroom = roomService.viewOneroom(roomid);
//        System.out.println(singlroom);
//        Gson g = new Gson();
//        String singleroomJson = g.toJson(singlroom);
//        ModelAndView mv = new ModelAndView("viewroom", "paymentMA", singlroom);
//        mv.addObject("singleStd", singleroomJson);
//        return mv;
//    }

}
