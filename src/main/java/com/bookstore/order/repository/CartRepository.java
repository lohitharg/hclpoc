package com.bookstore.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bookstore.order.entity.CartItem;

/**
 * @author Apurva Patel
 *
 */
@Repository
public interface CartRepository extends JpaRepository<CartItem,Integer>{

	//CartItem getByUserID(Long userId);

	List<CartItem> getByuserId(Long userId);
	
	@Transactional
	@Modifying
	@Query("DELETE  FROM CartItem cartItem WHERE   cartItem.userId=:userId")
	void deleteAllCartByUserId(Long userId);

	//void save(CartItem cartItem) ;

}
