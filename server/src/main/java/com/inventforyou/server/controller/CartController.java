package com.inventforyou.server.controller;

import com.inventforyou.server.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId) {
        cartService.addProductToCart(productId);
        return "redirect:/cart";
    }
}