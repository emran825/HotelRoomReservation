/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CategoryService;
import com.emran.hotelroomreservation.dao.CustomerinfoService;
import com.emran.hotelroomreservation.dao.CustomerserviceDao;
import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.dao.RoomService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.dao.RoomtypeService;
import com.emran.hotelroomreservation.dao.UserService;
import com.emran.hotelroomreservation.model.Customerservice;
import com.emran.hotelroomreservation.model.Room;
import com.emran.hotelroomreservation.model.Roombooking;
import com.emran.hotelroomreservation.model.SessionInsert;
import com.emran.hotelroomreservation.model.CartItemFacility;
import com.emran.hotelroomreservation.model.Customerinfo;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SARK
 */
@Controller
public class SearchController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomtypeService roomtypeService;
    @Autowired
    RoombookingService roombookingService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CustomerinfoService customerinfoService;
    @Autowired
    UserService userService;
    @Autowired
    CustomerserviceDao customerserviceDao;
    @Autowired
    FacilityService facilityService;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "startdate", new CustomDateEditor(format, false));
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format1, false));

//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/search")
    public ModelAndView showAllRoom() {

      String roomtype = roomtypeService.viewAllRoomtype();
        
         String categoryall = categoryService.viewAllCategory();

        String roomtable = roomService.viewAllRoom();

//        String roombookingList = roombookingService.viewAllRoombooking();

        ModelAndView mv = new ModelAndView("searchroom");

        mv.addObject("roomtableList", roomtable);
        mv.addObject("roomtype", roomtype);
        mv.addObject("categoryall", categoryall);
//        mv.addObject("roombookinglist", roombookingList);
        //mv.addObject("check", "true");
        mv.addObject("check", "false");
        mv.addObject("s", "null");
        return mv;
    }

    @RequestMapping("/roomsearch")
    //read the provided form data  
    public ModelAndView display(@RequestParam("roomtypeid") int roomtypeid, @RequestParam("catid") String catid, @RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate, HttpSession session) throws ParseException {
        String searchroom = roomService.viewSingleRoom(roomtypeid, catid, startdate, enddate);
        System.out.println("tttttttttttttttttttttttttttttttt" + searchroom);
        String roomtable = roomService.viewAllRoom();
        
         String roomtype = roomtypeService.viewAllRoomtype();
        
         String categoryall = categoryService.viewAllCategory();
        
        Gson g = new Gson();
        String roomlistgson = g.toJson(searchroom);
        System.out.println("88888888522222222222222222222222222222222222" + roomlistgson);
//        Room r = new Room();
//        double rrent = r.getRoomrent();
//        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr   " + rrent);

        // session.setAttribute("rrent", rrent);
        session.setAttribute("catid", catid);
        session.setAttribute("roomtypeid", roomtypeid);
        System.out.println("fffffffffffffffffffffffffff");
        //session.setAttribute("Datesum", Datesum());

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date sdate = format.parse(startdate);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        Date edate = format1.parse(enddate);

//    ==============================***********===========================        
        session.setAttribute("startdate", startdate);
        session.setAttribute("enddate", enddate);

        SearchController searchController = new SearchController();

        long difference = searchController.daydifference(sdate, edate);

        System.out.println("kkkkkkkkkkkkkkkkkkkk   " + difference);
        session.setAttribute("difference", difference);

        ModelAndView mv = new ModelAndView("searchroom");
        mv.addObject("roomtableList", roomtable);
         mv.addObject("roomtype", roomtype);
        mv.addObject("categoryall", categoryall);
        mv.addObject("check", "true");
        mv.addObject("s", searchroom);
        return mv;
    }

    @RequestMapping("/roomprofilelink")
    public ModelAndView passingoneEmployee(@RequestParam("getsid") int roomid, HttpSession session) {

        Room singlroom = roomService.viewOneroom(roomid);
        String facility = facilityService.viewAllFacility();
        
        
        //        ===========payment date print====================
          SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String da = format1.format(date);
        session.setAttribute("da", da);

        double roomrent = singlroom.getRoomrent();

//        long total = roomrent*difference;
//        double totalrent = roomrent*2;
        int rid = singlroom.getRoomid();
        String rn = singlroom.getRoomnumber();
        String roomcat = singlroom.getCatname();
        String roomt = singlroom.getRoomtype();
        
        
        session.setAttribute("roomid", rid);
        session.setAttribute("rn", rn);
        session.setAttribute("roomrent", roomrent);
        session.setAttribute("roomcat", roomcat);
        session.setAttribute("roomt", roomt);
        
        session.setAttribute("sidInSession", roomid);
        System.out.println(singlroom);
        Gson g = new Gson();
        String singleroomJson = g.toJson(singlroom);
        ModelAndView mv = new ModelAndView("viewroom", "newProductObject", new Roombooking());
        mv.addObject("singleStd", singleroomJson);
        mv.addObject("facility", facility);

        ArrayList<CartItemFacility> acart = (ArrayList<CartItemFacility>) session.getAttribute("cart");
        if (acart.isEmpty()) {
            session.setAttribute("acartempty", "true");
        } else {
            String acartgson = g.toJson(acart);
            mv.addObject("acartgson", acartgson);
            session.setAttribute("acartempty", "false");
        }

        return mv;

    }

//    @RequestMapping(value = "/booking", params = "Add")
//    public String addFacility(@ModelAttribute("newProductObject") Roombooking roombooking) {
//        roombookingService.addRoombooking(roombooking);
//        return "redirect:/search";
//    }
//   =============***********=========================
//    =================Booking from Controller==============
    @RequestMapping(value = "/booking", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Roombooking roombooking, HttpSession session) {
        int bid = roombooking.getBookingid();
        int roomid = roombooking.getRoomid();
        int roomtype = roombooking.getRoomtypeid();
        int custid = roombooking.getCustid();
        Date sdate = roombooking.getStartdate();
        Date edate = roombooking.getEnddate();
        String emailid = roombooking.getEmailid();
        System.out.println("bid==================" + bid);
        System.out.println("roomid==================" + roomid);
        System.out.println("roomtype==================" + roomtype);
        System.out.println("custid==================" + custid);
        System.out.println("sdate==================" + sdate);
        System.out.println("edate==================" + edate);
        System.out.println("emailid==================" + emailid);

        session.setAttribute("emailid", emailid);
        session.setAttribute("bid", bid);
        session.setAttribute("roomid", roomid);
        session.setAttribute("roomtype", roomtype);
        session.setAttribute("custid", custid);
        session.setAttribute("sdate", sdate);
        session.setAttribute("edate", edate);
        System.out.println(session.getAttribute("emailid"));
        System.out.println(session.getAttribute("roomid"));
        System.out.println(session.getAttribute("roomtype"));
        System.out.println(session.getAttribute("custid"));
        System.out.println(session.getAttribute("sdate"));
        System.out.println(session.getAttribute("edate"));

        // roombookingService.addRoombooking(roombooking);
        return "redirect:/paymentinfo";
    }

//   =============***********=========================
    public long Datesum() {
        return 0;

//        Roombooking rb = new Roombooking();
//        Date d1 = rb.getStartdate();
//        Date d2 = rb.getEnddate();
//        Calendar mycalender = Calendar.getInstance();
//            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//        mycalender.setTime(d1);
//        Date date1 = mycalender.getTime();
//        
//         Calendar mycalender2 = Calendar.getInstance();
//        mycalender2.setTime(d2);
//        Date date2 = mycalender2.getTime();
//        int difference = (int) ((date1.getTime()-date2.getTime())/86400000);
//        int day = Math.abs(difference);
//        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddddd"+day);
//        return day;
//=================================================================
//    ===============*****=========================
//        Date today = new Date();
//        Calendar mycalender = Calendar.getInstance();
//            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//        mycalender.set(2020, 0, 1);
//        Date newdate = mycalender.getTime();
//        SearchController searchController = new SearchController();
//        long difference = searchController.daydifference(today, newdate);
//            System.out.println("dddddddddddddddddddddddddddddddd  "+difference);
//        return difference;
//      ================****=========================== 
    }

    public long daydifference(Date one, Date two) {
        long difference = (one.getTime() - two.getTime()) / 86400000;
        //long difference = (one.getDay()-two.getDay());
        return Math.abs(difference);
    }

    @RequestMapping(value = "/addcustomerservice", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Customerservice customerservice) {
        customerserviceDao.addCustomerservice(customerservice);
        return "redirect:/search";
    }

}
