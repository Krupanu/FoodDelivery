package com.example.fooddelivery.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.fooddelivery.dao.CartDao;
import com.example.fooddelivery.model.Cart;

@Controller
public class CartController {

    private final CartDao cartDao;

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @GetMapping("/addToCart")
    public ModelAndView addtoCart(@ModelAttribute Cart cart) {
        ModelAndView mv = new ModelAndView();

        cartDao.save(cart);
        mv.addObject("status", "Foods added to cart!");
        mv.setViewName("index");

        return mv;

    }

    @GetMapping("/deletecart")
    public ModelAndView deleteProductFromCart(@RequestParam("cartId") int  cartId) {
        ModelAndView mv = new ModelAndView();

        Cart cart = new Cart();

        Optional<Cart> o = cartDao.findById(cartId);
        if(o.isPresent()) {
            cart = o.get();
        }

        cartDao.delete(cart);

        mv.addObject("status", "Selected Food removed from Cart!");
        mv.setViewName("index");

        return mv;
    }

}