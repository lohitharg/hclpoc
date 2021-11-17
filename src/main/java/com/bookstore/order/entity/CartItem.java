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
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Long price;
	private int qty;
	private Long productId;
	private String productName;
	private Long userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public CartItem(int id, Long price, int qty, Long productId, String productName, Long userId) {
		super();
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
	}
	public CartItem() {
		super();
	}
	
}
