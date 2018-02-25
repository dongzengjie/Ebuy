package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;

public class OrderProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long orderProductId;
	private int num;
	private Order order;
	private Product product;
	public Long getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
