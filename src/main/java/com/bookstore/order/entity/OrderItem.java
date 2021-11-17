package com.bookstore.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Apurva Patel
 *
 */
@Entity
@Table
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String order_id,payment_type,delivery_address;
	private Long userId;
	private Long productId;
	private String productName;
	private int qty;
	private Long price;
	private String order_date;
	private String orderStatus;
	private Double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order_id=" + order_id + ", payment_type=" + payment_type
				+ ", delivery_address=" + delivery_address + ", userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + ", qty=" + qty + ", price=" + price + ", order_date=" + order_date
				+ ", orderStatus=" + orderStatus + ", total=" + total + "]";
	}
	
	public OrderItem(int id, String order_id, String payment_type, String delivery_address, Long userId, Long productId,
			String productName, int qty, Long price, String order_date, String orderStatus, Double total) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.payment_type = payment_type;
		this.delivery_address = delivery_address;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.order_date = order_date;
		this.orderStatus = orderStatus;
		this.total = total;
	}
	public OrderItem() {
		super();
	}
	
	
	
}
