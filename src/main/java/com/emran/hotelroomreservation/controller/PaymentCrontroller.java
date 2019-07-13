/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.CustomerserviceDao;
import com.emran.hotelroomreservation.dao.PaymentService;
import com.emran.hotelroomreservation.dao.PaymentdetailsService;
import com.emran.hotelroomreservation.dao.RoomService;
import com.emran.hotelroomreservation.dao.RoombookingService;
import com.emran.hotelroomreservation.model.CartItemFacility;
import com.emran.hotelroomreservation.model.Customerservice;
import com.emran.hotelroomreservation.model.Payment;
import com.emran.hotelroomreservation.model.Paymentdetails;
import com.emran.hotelroomreservation.model.Room;
import com.emran.hotelroomreservation.model.Roombooking;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

/**
 *
 * @author SARK
 */
@Controller
public class PaymentCrontroller {

    @Autowired
    PaymentService paymentService;
    @Autowired
    RoombookingService roombookingService;

    @Autowired
    RoomService roomService;

    @Autowired
    CustomerserviceDao casdao;

    @Autowired
    PaymentdetailsService paymentdetailsService;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "paymentdate", new CustomDateEditor(format, false));
//         SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
//        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format1, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/paymentinfo")
    public ModelAndView showproductpage() {
//        String paymentinfo = paymentService.viewAllPayment();
//        String roombookinginfo = roombookingService.viewAllRoombooking();
        ModelAndView mv = new ModelAndView("addpayment", "newProductObject", new Payment());
//        mv.addObject("paymentuser", paymentinfo);
//        mv.addObject("roombookinglist", roombookinginfo);
//       // mv.addObject("categorymodelobject", categorygsonlist);
//        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/receipt")
    public ModelAndView showreceipt() {

        ModelAndView mv = new ModelAndView("receipt");

        return mv;
    }
    // ===============*************======================

    @RequestMapping(value = "/addpayment", params = "Add")
    public String addFacility(@ModelAttribute("newProductObject") Payment payment, HttpSession session) {
        Roombooking roombooking = new Roombooking();
        roombooking.setRoomid((Integer) session.getAttribute("roomid"));
        roombooking.setRoomtypeid((Integer) session.getAttribute("roomtype"));

        roombooking.setCustid((Integer) session.getAttribute("custid"));
        roombooking.setStartdate((Date) session.getAttribute("sdate"));
        roombooking.setEnddate((Date) session.getAttribute("edate"));
        roombooking.setEmailid((String) session.getAttribute("emailid"));

        Room room = new Room();
        String roomnum = room.getRoomnumber();
        session.setAttribute("roomnum", roomnum);

        // String roomname = roomtable.
        roombookingService.addRoombooking(roombooking);
        session.setAttribute("bookid", roombooking.getBookingid());

        //add cart item to database
        ArrayList<CartItemFacility> allowanceCartTemp = (ArrayList<CartItemFacility>) session.getAttribute("cart");
        ArrayList<Customerservice> servicedetail = new ArrayList<Customerservice>();
        for (CartItemFacility cart : allowanceCartTemp) {
            Customerservice cs = new Customerservice();
            cs.setFacilityid(cart.getFacilityid());
            cs.setCustid((Integer) session.getAttribute("custid"));
            //booking id get
            cs.setBookingid(roombooking.getBookingid());

            servicedetail.add(cs);
        }
        casdao.addCustomerservice(servicedetail);
        System.out.println("fast-----------------------------------------------------------------");
        // servicedetail.removeAll(servicedetail);
        session.setAttribute("cart", new ArrayList<CartItemFacility>());
        //booking id set
        payment.setBookingid(roombooking.getBookingid());
        paymentService.addPayment(payment);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date dd = payment.getPaymentdate();
        String d = format.format(dd);
        session.setAttribute("d", d);
        System.out.println(session.getAttribute("d"));
        int pid = payment.getPaymentid();
        session.setAttribute("pid", pid);
        String paytype = payment.getPaymenttype();
        session.setAttribute("paytype", paytype);
        System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"+session.getAttribute("paytype"));

        // =====================Paymentdetails===================
        ArrayList<Paymentdetails> paymentdetails = new ArrayList<Paymentdetails>();

        for (CartItemFacility cart : allowanceCartTemp) {
            Paymentdetails pd = new Paymentdetails();
            pd.setPaymentid(payment.getPaymentid());
            pd.setBookingid(roombooking.getBookingid());
            //booking id get
            pd.setFacilityid(cart.getFacilityid());
            pd.setFacilitycost(cart.getFacilitycost());

            paymentdetails.add(pd);
//            casdao.addCustomerservice(servicedetail);
            System.out.println("fast*********************************************************************");
        }
        paymentdetailsService.addlistPaymentdetails(paymentdetails);
        session.setAttribute("cart", new ArrayList<CartItemFacility>());
        // return "redirect:/paymentinfo";
        return "redirect:/receipt";
    }

    //===================**************================= 
    @RequestMapping(value = "/addpayment", params = "Edit")
    public String editcategory(@ModelAttribute("newProductObject") Payment payment) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        paymentService.updatePayment(payment);
        return "redirect:/paymentinfo";
    }

    @RequestMapping("/editingpayment")
    public ModelAndView editproductpage(@RequestParam("getpaymentid") int paymentid) {
        String paymentinfo = paymentService.viewAllPayment();
        String roombookinginfo = roombookingService.viewAllRoombooking();
        ModelAndView mv = new ModelAndView("addpayment", "newProductObject", paymentService.viewPayment(paymentid));
        mv.addObject("paymentuser", paymentinfo);
        mv.addObject("roombookinglist", roombookinginfo);
        mv.addObject("check", "false");
        return mv;
    }

    @RequestMapping("removepayment/{Id}")
    public String removecategory(@PathVariable("Id") int paymentid) {
        paymentService.deletePayment(paymentid);
        return "redirect:/paymentinfo";
    }
}
