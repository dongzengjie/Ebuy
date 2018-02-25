package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;

public class Shop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shopId;
	private String shopName;
	
	private User user;
	private Bigtype bigtype;
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bigtype getBigtype() {
		return bigtype;
	}
	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}
	
	
}
