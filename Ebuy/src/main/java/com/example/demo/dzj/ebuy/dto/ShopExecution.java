package com.example.demo.dzj.ebuy.dto;

import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.enums.ShopEnum;

public class ShopExecution {
	private int state;
	private String stateinfo;
	private Shop shop;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateinfo() {
		return stateinfo;
	}

	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ShopExecution() {

	}

	public ShopExecution(ShopEnum shopEnum) {
		this.state = shopEnum.getState();
		this.stateinfo = shopEnum.getStateInfo();
	}

	public ShopExecution(ShopEnum shopEnum, Shop shop) {
		this.state = shopEnum.getState();
		this.stateinfo = shopEnum.getStateInfo();
		this.shop=shop;

	}
}
