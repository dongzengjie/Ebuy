package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long orderId;
	private double cost;
	private Date createTime;
	private String orderNo;
	private int status;//0未付款  1 待发货，2 发货 ，3 签收 
	private Long userId;
	private Long shopId;
	private List<OrderProduct> orderProductlist;
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	
	
	public List<OrderProduct> getOrderProductlist() {
		return orderProductlist;
	}
	public void setOrderProductlist(List<OrderProduct> orderProductlist) {
		this.orderProductlist = orderProductlist;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
