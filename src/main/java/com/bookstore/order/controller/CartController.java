package com.bookstore.order.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.order.bean.CartBean;
import com.bookstore.order.entity.CartItem;
import com.bookstore.order.service.CartService;

//import lombok.extern.slf4j.Slf4j;

/**
 * @author Apurva Patel
 *
 */
@RestController
@RequestMapping("/cart")
//@Slf4j
public class CartController {
	
	@Autowired
	private CartService cartSevice;
	
	@PostMapping("/add") 
	public String addProductToCart(@RequestBody CartBean carBean) throws Exception {
			//@PathVariable("pid")Integer productId, @PathVariable("qty")Integer productQuantity) {
	//	log.info("Inside CartController :: addBookToCart"); 
		Long productId= carBean.getProductId();
		Long userId=carBean.getUserId();
		int qty =carBean.getQty();
		Long price= carBean.getPrice();
		String productName=carBean.getProductName();
		cartSevice.addProductToCart(productId,userId,qty,price,productName);
		
		return "Product added to cart successfully";
		
	}
	
	 @GetMapping("/list/{id}")
	    public List<CartItem> getCartByUserId(@PathVariable("id") Long userId) {
	       // log.info("Inside CartController:: getCartByUserId");
	        return cartSevice.getCartByUserId(userId);
	    }
}
