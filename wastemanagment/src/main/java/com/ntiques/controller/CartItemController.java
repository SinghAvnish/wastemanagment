package com.ntiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntiques.model.CartItem;
import com.ntiques.service.CartItemService;
import com.ntiques.service.CartService;
import com.ntiques.service.ProductService;
import com.ntiques.service.UserService;

@Controller
public class CartItemController
{
	
	@Autowired (required=true)
	private CartItemService cartItemService;
	
	@Autowired (required=true)
	private UserService userService;
	
	@Autowired (required=true)
	private CartService cartService;
	
	@Autowired (required=true)
	private ProductService productService;
	
	
	
	@RequestMapping(value= "/CartItemadd")
		
		public String addToCart(@ModelAttribute CartItem cartItem,@RequestParam("id")int id )
		{
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user_name =authentication.getName();
			String uname=userService.getByUserName(user_name).getUsername();
			System.out.println("Current user"+uname);
			
			//String uname=userService.getByUserName(user_name).getUsername();
			System.out.println("Current user"+uname);
			
			int user_id=userService.user_id(user_name);
			System.out.println("Current user id"+user_id);
			
			int cartId=cartService.getById(user_id).getCartId();
			cartItem.setCartid(cartId);
			System.out.println("Current user"+cartId);
			
			cartItem.setProdname(productService.get(id).getName());
			cartItem.setPrice(productService.get(id).getPrice());
			cartItem.setProdid(id);
			cartItem.setQuantity(1);
			cartItemService.saveOrUpdate(cartItem);
			return "redirect:cartitemlist";
			}
		
	 	

			@RequestMapping("/cartitemlist")
			public String cartList(Model model)
			{
				Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
				String username = authentication.getName();
		
				int userId=userService.getByName(username).getUserId();
				int cartId=cartService.getById(userId).getCartId();
				model.addAttribute("cartItemList", this.cartItemService.getCartItemsByUser(cartId));
				return "cartitemlist";
	}	
	 	}
		






