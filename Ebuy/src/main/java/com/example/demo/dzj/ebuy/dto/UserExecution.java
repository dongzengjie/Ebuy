package com.example.demo.dzj.ebuy.dto;

import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.enums.ShopEnum;
import com.example.demo.dzj.ebuy.enums.UserEnum;

public class UserExecution {
	private int state;
	private String stateinfo;
	private User user;



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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserExecution() {

	}

	public UserExecution(UserEnum userEnum) {
		this.state = userEnum.getState();
		this.stateinfo = userEnum.getStateInfo();
	}

	public UserExecution(UserEnum userEnum, User user) {
		this.state = userEnum.getState();
		this.stateinfo = userEnum.getStateInfo();
		this.user=user;

	}
}
