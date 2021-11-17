package com.bookstore.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.order.entity.OrderItem;

/**
 * @author Apurva Patel
 *
 */
public interface OrderRepository extends JpaRepository<OrderItem,Integer> {

	List<OrderItem> getByuserId(Long userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE OrderItem orderItem SET orderStatus = 'Order Cancelled' WHERE orderItem.order_id=:orderId")
	void updateOrderStatus(String orderId);
	

}
