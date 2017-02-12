package org.shoppingdemon.ulti;

import javax.servlet.http.HttpServletRequest;

import org.shoppingdemon.model.CartInfo;

 
public class Utils {
  
   public static CartInfo getCartInSession(HttpServletRequest request) {
 
  
       // save to Session
       CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
      
  
       // create if null
       if (cartInfo == null) {
           cartInfo = new CartInfo();
          
  
           // save to session.
           request.getSession().setAttribute("myCart", cartInfo);
       }
 
       return cartInfo;
   }
 
   public static void removeCartInSession(HttpServletRequest request) {
       request.getSession().removeAttribute("myCart");
   }
 
   public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
       request.getSession().setAttribute("lastOrderedCart", cartInfo);
   }
  
   public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
       return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
   }
 
}