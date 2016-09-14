package com.ntiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ntiques.model.Cart;
import com.ntiques.service.CartService;

@SessionAttributes({ "CartItem" })
@Controller
public class CartController {
	
	@Autowired    (required=true)
	private CartService cartservice;
	
	

	@RequestMapping(value = "/carts",method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("cart", new Cart());
		
		return "cart";
	}
	
	
}
