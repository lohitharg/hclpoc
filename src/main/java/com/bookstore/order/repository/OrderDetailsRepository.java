package com.bookstore.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.order.entity.OrderDetails;

/**
 * @author Apurva Patel
 *
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer>{
	//@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '') [product_id],row_number() OVER(Partition by order_id ORDER BY order_id ) as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty) TT WHERE rownum=1 AND user_id=?",nativeQuery = true)
	//@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,B.product_name,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '') [product_id],row_number() OVER(Partition by order_id ORDER BY order_id ) as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,B.product_name) TT WHERE rownum=1 AND user_id=?",nativeQuery = true)
	//@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address, B.payment_type,B.price,B.qty,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '') [product_id],STUFF((SELECT ',' + convert(varchar,A.Product_name) FROM order_item A WHERE A.order_id = B.order_id ORDER BY Product_name FOR XML PATH('')), 1, 1, '') [product_name],row_number() OVER(Partition by order_id ORDER BY order_id ) as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,B.product_name) TT WHERE rownum=1 AND user_id=?",nativeQuery = true)
	@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address, B.payment_type,B.total,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '')[product_id],STUFF((SELECT ',' + convert(varchar,A.Product_name) FROM order_item A WHERE A.order_id = B.order_id ORDER BY Product_name FOR XML PATH('')), 1, 1, '') [product_name],STUFF((SELECT ',' + convert(varchar,A.Price) FROM order_item A WHERE A.order_id = B.order_id ORDER BY Price FOR XML PATH('')), 1, 1, '') [price],STUFF((SELECT ',' + convert(varchar,A.qty) FROM order_item A WHERE A.order_id = B.order_id ORDER BY qty FOR XML PATH('')), 1, 1, '') [qty],row_number() OVER(Partition by order_id ORDER BY order_id)as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,B.product_name,B.total) TT WHERE rownum=1 AND user_id=?",nativeQuery = true)
	List<OrderDetails> getOrdersByuserId(Long userId);

	@Query(value="SELECT * FROM order_item WHERE id = (SELECT MAX (id) FROM order_item)",nativeQuery=true)
	OrderDetails getLastOrder(Long userId);
	
	@Query(value="SELECT * FROM (SELECT B.id,B.order_id,B.order_status,B.user_id,B.order_date,B.delivery_address, B.payment_type,B.total,STUFF((SELECT ',' + convert(varchar,A.Product_id) FROM order_item A WHERE A.order_id = B.order_id ORDER BY product_id FOR XML PATH('')), 1, 1, '')[product_id],STUFF((SELECT ',' + convert(varchar,A.Product_name) FROM order_item A WHERE A.order_id = B.order_id ORDER BY Product_name FOR XML PATH('')), 1, 1, '') [product_name],STUFF((SELECT ',' + convert(varchar,A.Price) FROM order_item A WHERE A.order_id = B.order_id ORDER BY Price FOR XML PATH('')), 1, 1, '') [price],STUFF((SELECT ',' + convert(varchar,A.qty) FROM order_item A WHERE A.order_id = B.order_id ORDER BY qty FOR XML PATH('')), 1, 1, '') [qty],row_number() OVER(Partition by order_id ORDER BY order_id)as rownum FROM order_item B GROUP BY B.id, B.product_id, B.order_id,B.order_status ,B.user_id,B.order_date,B.delivery_address,B.payment_type,B.price,B.qty,B.product_name,B.total) TT WHERE rownum=1 AND user_id=? AND order_id= ?",nativeQuery = true)
	OrderDetails getOrderByOrderId(Long userId,String orderId);

	//OrderDetails getOrderByOrderId(String orderId);
}
