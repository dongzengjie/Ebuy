package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long productId;
	private String description;
	private int hot;
	private String hotTime;
	private String productName;
	private double price;
	private String proPic;
	private double specialPrice;//特价
	private String specialPriceTime;//特价时间
	private int stock;
	private Bigtype bigtype;
	private Smalltype smalltype;
	private Shop shop;
	private Long shopId;
	
	private Integer enableStatus;
	private List<OrderProduct> orderProductlist;
	
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	
	
	
	public List<OrderProduct> getOrderProductlist() {
		return orderProductlist;
	}
	public void setOrderProductlist(List<OrderProduct> orderProductlist) {
		this.orderProductlist = orderProductlist;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProPic() {
		return proPic;
	}
	public void setProPic(String proPic) {
		this.proPic = proPic;
	}



	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public String getHotTime() {
		return hotTime;
	}
	public void setHotTime(String hotTime) {
		this.hotTime = hotTime;
	}
	public String getSpecialPriceTime() {
		return specialPriceTime;
	}
	public void setSpecialPriceTime(String specialPriceTime) {
		this.specialPriceTime = specialPriceTime;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Bigtype getBigtype() {
		return bigtype;
	}
	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}
	public Smalltype getSmalltype() {
		return smalltype;
	}
	public void setSmalltype(Smalltype smalltype) {
		this.smalltype = smalltype;
	}
	
	
}
