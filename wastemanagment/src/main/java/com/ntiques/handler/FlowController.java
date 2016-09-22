package com.ntiques.handler;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ntiques.dao.BillingAddressDao;
import com.ntiques.dao.CardDetailDao;
import com.ntiques.dao.CartDao;
import com.ntiques.dao.CartItemDao;
import com.ntiques.dao.OrderDetailDao;
import com.ntiques.dao.OrderedItemsDao;
import com.ntiques.dao.ProductDao;
import com.ntiques.dao.ShippingAddressDao;
import com.ntiques.dao.UserDao;
import com.ntiques.model.BillingAddress;
import com.ntiques.model.CardDetail;
import com.ntiques.model.Cart;
import com.ntiques.model.CartItem;
import com.ntiques.model.CheckoutDetails;
import com.ntiques.model.OrderDetail;
import com.ntiques.model.OrderedItems;
import com.ntiques.model.Product;
import com.ntiques.model.ShippingAddress;
import com.ntiques.model.User;
import com.ntiques.service.BillingAddressService;
import com.ntiques.service.CardDetailService;
import com.ntiques.service.CartItemService;
import com.ntiques.service.CartService;
import com.ntiques.service.OrderDetailService;
import com.ntiques.service.OrderedItemsService;
import com.ntiques.service.ProductService;
import com.ntiques.service.ShippingAddressService;
import com.ntiques.service.UserService;



@Component
public class FlowController {
	@Autowired (required=true)
	private ProductService ProductService;
	@Autowired (required=true)
	private ShippingAddress ShippingAddress;

	@Autowired (required=true)
	private BillingAddress BillingAddress;

	@Autowired (required=true)
	private OrderDetail OrderDetail;

	@Autowired (required=true)
	private OrderedItems OrderedItems;

	@Autowired (required=true)
	private CardDetail CardDetail;

	@Autowired (required=true)
	private ShippingAddressService ShippingAddressService;

	@Autowired (required=true)
	private BillingAddressService BillingAddressService;

	@Autowired (required=true)
	private OrderedItemsService OrderedItemsService;

	@Autowired (required=true)
	private OrderDetailService OrderDetailService;

	@Autowired (required=true)
	private CardDetailService CardDetailService;
	@Autowired (required=true)
	User user;
	@Autowired (required=true)
	UserService userService;

	@Autowired (required=true)
	CartService cartService;

	@Autowired (required=true)
	Cart cart;

	@Autowired (required=true)
	CartItemService cartItemService;
	
	@Autowired (required=true)
	HttpSession httpSession;
	
	@Autowired (required=true)
	Product product;
	
	CheckoutDetails checkoutDetails = new CheckoutDetails();

	public CheckoutDetails initFlow() {
		user = userService.getByUserName(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		checkoutDetails.setCart(cartService.getById(user.getUserId()));
		checkoutDetails.setUser(userService.getByUserName(user.getUsername()));
		return checkoutDetails;
	}

	public String addShippingAddress(CheckoutDetails checkoutDetails, ShippingAddress shippingAddress) {
		user = userService.getByUserName(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		shippingAddress.setUserId(user.getUserId());
		checkoutDetails.setShippingAddress(shippingAddress);

		this.ShippingAddress.setUserId(user.getUserId());
		this.ShippingAddress.setLine1(shippingAddress.getLine1());
		this.ShippingAddress.setLine2(shippingAddress.getLine2());
		this.ShippingAddress.setCity(shippingAddress.getCity());
		this.ShippingAddress.setState(shippingAddress.getState());
		this.ShippingAddress.setCountry(shippingAddress.getCountry());
		this.ShippingAddress.setZipCode(shippingAddress.getZipCode());

		return "success";
	}

	public String addBillingAddress(CheckoutDetails checkoutDetails, BillingAddress billingAddress) {
		user = userService.getByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		billingAddress.setUserId(user.getUserId());
		checkoutDetails.setBillingAddress(billingAddress);

		this.BillingAddress.setUserId(user.getUserId());
		this.BillingAddress.setLine1(billingAddress.getLine1());
		this.BillingAddress.setLine2(billingAddress.getLine2());
		this.BillingAddress.setCity(billingAddress.getCity());
		this.BillingAddress.setState(billingAddress.getState());
		this.BillingAddress.setCountry(billingAddress.getCountry());
		this.BillingAddress.setZipCode(billingAddress.getZipCode());

		return "success";
	}

	public String addCardDetails(CheckoutDetails checkoutDetails, CardDetail cardDetail) {
		user = userService.getByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

		cardDetail.setUserId(user.getUserId());
		cardDetail.setTotalCost(cartService.getById(user.getUserId()).getGrandTotal());
		CardDetailService.saveOrUpdate(cardDetail);

		List<CartItem> listOfCartItems = cartItemService.getCartItemsByUserId(user.getUserId());

		listOfCartItems = cartItemService.getCartItemsByUserId(user.getUserId());

		cart = cartService.getById(user.getUserId());

		cart.setCartId(cart.getCartId());
		cart.setUserId(cart.getUserId());
		cart.setNoOfProducts(listOfCartItems.size());

		ShippingAddressService.saveOrUpdate(checkoutDetails.getShippingAddress());
		BillingAddressService.saveOrUpdate(checkoutDetails.getBillingAddress());
		cartService.saveOrUpdate(cart);

		httpSession.setAttribute("noOfProducts", cart.getNoOfProducts());

		return "success";
	}

}

