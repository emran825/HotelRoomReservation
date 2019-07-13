/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.controller;

import com.emran.hotelroomreservation.dao.FacilityService;
import com.emran.hotelroomreservation.model.CartItemFacility;
import com.emran.hotelroomreservation.model.Facility;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SARK
 */
@Controller
public class facilityCartController {
     @Autowired
    FacilityService fs;
     
     
     @RequestMapping("/addcart")
    public String addAllowance2Cart(@RequestParam("getallowanceid") int facid, HttpSession session) {
        Facility singleAcal = fs.viewFacility(facid);
        
        String flag = "not inserted";
        ArrayList<CartItemFacility> allowanceCartTemp = (ArrayList<CartItemFacility>) session.getAttribute("cart");

        if (allowanceCartTemp.isEmpty()) {
            CartItemFacility cartItemFacility = new CartItemFacility();
            cartItemFacility.setFacilityid(singleAcal.getFacilityid());
            cartItemFacility.setFacilityname(singleAcal.getFacilityname());
            cartItemFacility.setFacilitycost(singleAcal.getFacilitycost());
            
            allowanceCartTemp.add(cartItemFacility);
            
            session.setAttribute("cart", allowanceCartTemp);
           
            
            flag = "inserted";
        } else {
            Iterator<CartItemFacility> lit = allowanceCartTemp.iterator();
            while (lit.hasNext()) {
                CartItemFacility d = lit.next();
                         if (d.getFacilityid() == facid) {
                    int index = allowanceCartTemp.indexOf(d);
                    //String name = d.getPname();
                    //int qty = d.getQty() + 1;
                    //double price = d.getPrice();
                    allowanceCartTemp.remove(index);
                    CartItemFacility cartItemFacility = new CartItemFacility();
                    cartItemFacility.setFacilityid(singleAcal.getFacilityid());
                    cartItemFacility.setFacilityname(singleAcal.getFacilityname());
                    cartItemFacility.setFacilitycost(singleAcal.getFacilitycost());
                    allowanceCartTemp.add(index, cartItemFacility);
                    session.setAttribute("cart", allowanceCartTemp);
                      
                    
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                CartItemFacility cartItemFacility = new CartItemFacility();
                cartItemFacility.setFacilityid(singleAcal.getFacilityid());
                cartItemFacility.setFacilityname(singleAcal.getFacilityname());
                cartItemFacility.setFacilitycost(singleAcal.getFacilitycost());
                
                allowanceCartTemp.add(cartItemFacility);
                
                session.setAttribute("cart", allowanceCartTemp);
            }
        }
        
        session.setAttribute("grandtotal", getgrandquantity(allowanceCartTemp));
        
        
        String theURL = "redirect:/" + "roomprofilelink?getsid=" + session.getAttribute("sidInSession");
        return theURL;
    }
    
    
    
    // remove from cart
    @RequestMapping("/deleteallowance4rmcart")
    public String removeproductitem(@RequestParam("getallowanceid") int allowanceid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<CartItemFacility> allowanceCartTemp = (ArrayList<CartItemFacility>) session.getAttribute("cart");
        Iterator<CartItemFacility> itr = allowanceCartTemp.iterator();
        while (itr.hasNext()) {
            CartItemFacility aci = itr.next();
            if (aci.getFacilityid()== allowanceid) {
                allowanceCartTemp.remove(allowanceCartTemp.indexOf(aci));
                break;
            }
        }
        session.setAttribute("cart", allowanceCartTemp);
          session.setAttribute("grandtotal", grandquantity(allowanceCartTemp));
        
        
        String theURL = "redirect:/" + "roomprofilelink?getsid=" + session.getAttribute("sidInSession");
        return theURL;
    }
//    ===============total====================
     public int getgrandquantity(ArrayList<CartItemFacility> items) {
        int grandquant = 0;
        ListIterator<CartItemFacility> itr = items.listIterator();
        while (itr.hasNext()) {
            CartItemFacility obj = (CartItemFacility) itr.next();
            grandquant = grandquant + obj.getFacilitycost();
        }
        return grandquant;
    }
     
     
      public int grandquantity(ArrayList<CartItemFacility> items) {
        int grandquant = 0;
        ListIterator<CartItemFacility> itr = items.listIterator();
        while (itr.hasNext()) {
            CartItemFacility obj = (CartItemFacility) itr.next();
            grandquant = grandquant - obj.getFacilitycost();
        }
        return grandquant;
    }

//    public double getGrandTotal(ArrayList<CartItemFacility> item) {
//        double gtotal = 0;
//        ListIterator<CartItemFacility> itr = item.listIterator();
//        while (itr.hasNext()) {
//            
//            CartItemFacility ob = (CartItemFacility) itr.next();
//            gtotal = gtotal +  ob.getFacilitycost();
//        }
//        return gtotal;
//    }
    
    
//    ===============total====================
    
    
    
    
    
    
    
    
    
    
    
//    =====================***********================================
//     public double getGrandTotal(ArrayList<CartItemFacility> item) {
//        double gtotal = 0;
//        ListIterator<CartItemFacility> itr = item.listIterator();
//        while (itr.hasNext()) {
//            CartItemFacility ob = (CartItemFacility) itr.next();
//            gtotal = gtotal + (ob.getFacilitycost());
//            System.out.println("gggggggggggggrrrrrrrrrrrr  "+gtotal);
//        }
//        return gtotal;
//    }
//     
//     
//     
//     @RequestMapping("/showcartpage")
//    public ModelAndView showCartPage(HttpSession httpSession) {
//        ModelAndView mv = new ModelAndView("cart");
//        Gson g = new Gson();
//         ArrayList<CartItemFacility> allowanceCartTemp = (ArrayList<CartItemFacility>) httpSession.getAttribute("cart");
//        if (allowanceCartTemp.isEmpty()) {
//            httpSession.setAttribute("cartempty", "true");
//            return mv;
//        } else {
//            String cartgson = g.toJson(allowanceCartTemp);
//            mv.addObject("itemsincart", cartgson);
//            httpSession.setAttribute("grandtotal", getGrandTotal(allowanceCartTemp));
////            httpSession.setAttribute("grandquantity", getgrandquantity(c));
//            httpSession.setAttribute("cartempty", "false");
//            return mv;
//        }
////        =================*************========================
//    }
//    
    
    
    
//    =============================***********************====================================
    
//     @RequestMapping("/confirmorder")
//    public ModelAndView confirmOrder(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {
//        BillingAddress bm = (BillingAddress) bdao.viewOneBillingAddress(addressid);
//        ArrayList<CartItemFacility> c = (ArrayList<CartItemFacility>) httpSession.getAttribute("cart");
//        String email = (String) httpSession.getAttribute("UserId");
//        ProductOrder porder = new ProductOrder();
//        porder.setUseremail(email);
//        porder.setAddressid(addressid);
//        odao.insertProductOrder(porder);
//        ArrayList<OrderDetails> odetails = new ArrayList<OrderDetails>();
//        for (Cart cart : c) {
//            OrderDetails sorder = new OrderDetails();
//            sorder.setOrderid(porder.getOrderid());
//            sorder.setProductid(cart.getPid());
//            sorder.setQuantity(cart.getQty());
//            sorder.setPrice(cart.getPrice());
//            odetails.add(sorder);
//            // get product and update quantity
//            Product p = pdao.viewOneProduct(cart.getPid());
//            p.setProductquantity(p.getProductquantity()-cart.getQty());
//            pdao.updateProduct(cart.getPid(), p);
//            
//        }
//        odetdao.insertOrderDetails(odetails);
//        odetails.removeAll(odetails);
//        ModelAndView mv = new ModelAndView("invoice");
//        mv.addObject("bill", "false");
//        mv.addObject("success", "true");
//        mv.addObject("orderid", porder.getOrderid());
//        httpSession.setAttribute("usercart", new ArrayList<Cart>());
//        httpSession.setAttribute("grandquantity", 0);
//        return mv;
//    }
//    
    
//    =============================***********************====================================
    
        
    
    
}

