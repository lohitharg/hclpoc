package com.bookstore.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.order.entity.CartItem;
import com.bookstore.order.repository.CartRepository;

//import lombok.extern.slf4j.Slf4j;

/**
 * @author Apurva Patel
 *
 */
@Service
//@Slf4j
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;

	/*
	 * public Integer addProduct(Integer productId, Integer productQuantity) {
	 * Integer addedQuantity=productQuantity; CartItem cartItem=new CartItem();
	 * 
	 * //Product pro cartItem.set cartRepository.save() return addedQuantity; //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 */
	public void addProductToCart(long productId, long userId, int qty, Long price,String productName) throws Exception {
		try {
			/*
			 * if(cartRepository.getCartByProductIdAnduserId(userId,
			 * productId).isPresent()){ throw new Exception("Product is already exist."); }
			 */
			//log.info("Inside CartService :: addProductToCart"); 
			
			CartItem cartItem = new CartItem();
			cartItem.setQty(qty);
			cartItem.setUserId(userId);
			cartItem.setProductId(productId);
			cartItem.setPrice(price);
			cartItem.setProductName(productName);
			//Products pro = proServices.getProductsById(productId);
			//obj.setProduct(pro); 
			//TODO price has to check with qty
			//obj.setPrice(price);
			cartRepository.save(cartItem);		
			//return "saved"/* this.getCartByUserId(userId) */;	
		}catch(Exception e) {
			e.printStackTrace();
			//log.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	public List<CartItem> getCartByUserId(Long userId) {
       // log.info("Inside CartService:: getCartByUserId");

		return cartRepository.getByuserId(userId);
	}
	
	//public List<CartItem>
}
