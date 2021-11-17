package com.bookstore.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookstore.order.entity.CartItem;
import com.bookstore.order.entity.OrderDetails;
import com.bookstore.order.entity.OrderItem;
import com.bookstore.order.repository.CartRepository;
import com.bookstore.order.repository.OrderDetailsRepository;
import com.bookstore.order.repository.OrderRepository;

//import lombok.extern.slf4j.Slf4j;

/**
 * @author Apurva Patel
 *
 */
@Service
//@Slf4j
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private CartRepository cartRepository;

	public List<OrderItem> saveProductsForCheckout(List<OrderItem> tmp) throws Exception {
		//  log.info("Inside OrderService:: saveProductsForCheckout");
		  try {
				Long userId = tmp.get(0).getUserId();
				if(tmp.size() >0) {
					orderRepository.saveAll(tmp);
					 this.removeAllCartByUserId(userId);
					//cartRepository.deleteAllCartByUserId(user_id);
					return this.getAllCheckoutByUserId(userId);
				}	
				else {
					throw  new Exception("Should not be empty");
				}
			}catch(Exception e) {
				throw new Exception("Error while checkout "+e.getMessage());
			}
	}
	public List<OrderItem> getAllCheckoutByUserId(Long userId) {
		return orderRepository.getByuserId(userId);
	}

	
	  public List<CartItem> removeAllCartByUserId(Long userId) 
	  {
		  cartRepository.deleteAllCartByUserId(userId); 
	  return null; 
	  }
	
	  public List<OrderItem> updateOrderStatus(String orderId) {
		orderRepository.updateOrderStatus(orderId);
		 return null; 
	}
	public List<OrderDetails> getOrders(Long userId) {
		return orderDetailsRepository.getOrdersByuserId(userId);
	}
	/*public OrderDetails getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.getOrderByOrderId(orderId);
	}*/
	public OrderDetails getLastOrder(Long userId) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.getLastOrder(userId);
	}
	public OrderDetails getOrderByOrderId(Long userId,String orderId) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.getOrderByOrderId(userId,orderId);
	}
	 
}
