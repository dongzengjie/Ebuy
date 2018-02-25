package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String address;
	private Date birthday;
	private String dentityCode;
	private String email;
	private String mobile;
	private String password;
	private String sex;
	private Integer status;//1合法 2 不合法
	private String trueName;
	private String username;
	private List<Order> orderlist;
	

	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDentityCode() {
		return dentityCode;
	}
	public void setDentityCode(String dentityCode) {
		this.dentityCode = dentityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	
	
}
