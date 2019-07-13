///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emran.hotelroomreservation.controller;
//
//import com.emran.hotelroomreservation.dao.FacilityService;
//import com.emran.hotelroomreservation.model.Cart;
//import com.emran.hotelroomreservation.model.Facility;
//import com.google.gson.Gson;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.ListIterator;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author SARK
// */
//public class Cartcontroller {
//       @Autowired
//    FacilityService facilityService; 
//       
//           @RequestMapping("/showcartpage")
//    public ModelAndView showCartPage(HttpSession httpSession) {
//        ModelAndView mv = new ModelAndView("cart");
//        Gson g = new Gson();
//        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
//        if (c.isEmpty()) {
//            httpSession.setAttribute("cartempty", "true");
//            return mv;
//        } else {
//            String cartgson = g.toJson(c);
//            mv.addObject("itemsincart", cartgson);
//            httpSession.setAttribute("grandtotal", getGrandTotal(c));
//            httpSession.setAttribute("grandquantity", getgrandquantity(c));
//            httpSession.setAttribute("cartempty", "false");
//            return mv;
//        }
//    }
//    
//    
//     public int getgrandquantity(ArrayList<Cart> items) {
//        int grandquant = 0;
//        ListIterator<Cart> itr = items.listIterator();
//        while (itr.hasNext()) {
//            Cart obj = (Cart) itr.next();
//            grandquant = grandquant + obj.getQty();
//        }
//        return grandquant;
//    }
//
//    public double getGrandTotal(ArrayList<Cart> item) {
//        double gtotal = 0;
//        ListIterator<Cart> itr = item.listIterator();
//        while (itr.hasNext()) {
//            Cart ob = (Cart) itr.next();
//            gtotal = gtotal + (ob.getQty() * ob.getFacilitycost());
//        }
//        return gtotal;
//    }
//    
//    
//    
//    
//    
//    
//     @RequestMapping(value = "/editquantity")
//    public String editCart(@RequestParam("getproductid") int id, @RequestParam("value") String sign, HttpSession session) {
//        ArrayList<Cart> c = (ArrayList<Cart>) session.getAttribute("usercart");
//        Iterator<Cart> lit = c.iterator();
//        while (lit.hasNext()) {
//            Cart d = lit.next();
//            int index = c.indexOf(d);
//            if (d.getFacilityid() == id) {
//                String name = d.getFacilityname();
//                int qty = d.getQty();
//              int price = d.getFacilitycost();
//                c.remove(index);
//                if (sign.equals("decrease") && qty > 1) {
//                    c.add(index, new Cart(id, name, qty - 1, price, ((qty + 1) * price)));
//                } else if (sign.equals("decrease") && qty == 1) {
//                    c.add(index, new Cart(id, name, 1, price, price));
//                } else if (sign.equals("increase") && qty < 100) {
//                    c.add(index, new Cart(id, name, qty + 1, price, ((qty + 1) * price)));
//                } else {
//                    c.add(index, new Cart(id, name, qty, price, ((qty) * price)));
//                }
//                break;
//            }
//        }
//        session.setAttribute("grandquantity", getgrandquantity(c));
//        session.setAttribute("usercart", c);
//
//        return "redirect:/showcartpage";
//    }
//    
//    
//    
//    
//    
//      @RequestMapping("/addtocart")
//    public String addingToCart(@RequestParam("getProductId") int facilityid, HttpSession session) {
//
//       // Product pm = productdao.viewOneProduct(productId);
//        Facility fc = facilityService.viewFacility(facilityid);
//        session.setAttribute("productid", facilityid);
//        String flag = "not inserted";
//        ArrayList<Cart> cartarray = (ArrayList<Cart>) session.getAttribute("usercart");
//
//        if (cartarray.isEmpty()) {
//            cartarray.add(new Cart(fc.getFacilityid(), fc.getFacilityname(), 1, fc.getFacilitycost(), fc.getFacilitycost()));
//            flag = "inserted";
//        } else {
//            Iterator<Cart> lit = cartarray.iterator();
//            while (lit.hasNext()) {
//                Cart d = lit.next();
//                if (d.getFacilityid() == facilityid) {
//                    int index = cartarray.indexOf(d);
//                    String name = d.getFacilityname();
//                    int qty = d.getQty() + 1;
//                    int price = d.getFacilitycost();
//                    cartarray.remove(index);
//                    cartarray.add(index, new Cart(facilityid, name, qty, price, ((qty) * price)));
//                    session.setAttribute("usercart", cartarray);
//                    flag = "inserted";
//                    break;
//                }
//            }
//            if (flag.equals("not inserted")) {
//                cartarray.add(new Cart(fc.getFacilityid(), fc.getFacilityname(), 1, fc.getFacilitycost(), fc.getFacilitycost()));
//                session.setAttribute("usercart", cartarray);
//            }
//        }
//        session.setAttribute("grandquantity", getgrandquantity(cartarray));
////        UserCartDetails usercart = new UserCartDetails();
////        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
////        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
////        usercart.setProductsincart(cartarray.toString());
////        cdao.insertCartwithProducts(usercart);
//        return "redirect:/buyproductpage";
//    }
//    
//}
