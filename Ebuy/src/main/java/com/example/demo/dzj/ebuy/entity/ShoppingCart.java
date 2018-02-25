package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private List<ShoppingCartItems> shoppingCartItemsList =new ArrayList<ShoppingCartItems>();



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ShoppingCartItems> getShoppingCartItemsList() {
		return shoppingCartItemsList;
	}

	public void setShoppingCartItemsList(List<ShoppingCartItems> shoppingCartItemsList) {
		this.shoppingCartItemsList = shoppingCartItemsList;
	}
	
	
}
