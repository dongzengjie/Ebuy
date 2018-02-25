package com.example.demo.dzj.ebuy.dto;

import java.util.List;

import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.enums.OrderEnum;

public class OrderExecution {
	private Order order;
	private String stateInfo;
	private int state;
	private List<Order> orderList;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	public OrderExecution(OrderEnum orderEnum) {
		this.state=orderEnum.getState();
		this.stateInfo=orderEnum.getStateInfo();
	}
	

	public OrderExecution(OrderEnum orderEnum,Order order) {
		this.state=orderEnum.getState();
		this.stateInfo=orderEnum.getStateInfo();
		this.order=order;
	}
	
	public OrderExecution(OrderEnum orderEnum,List<Order> orderList) {
		this.state=orderEnum.getState();
		this.stateInfo=orderEnum.getStateInfo();
		this.orderList=orderList;
	}
	
	
}
