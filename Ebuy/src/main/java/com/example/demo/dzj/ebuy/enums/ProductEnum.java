package com.example.demo.dzj.ebuy.enums;

public enum ProductEnum {

	
	SUCCESS(1,"操作成功"),INNER_ERROR(2,"插入失败"),QUERY_ERROR(3,"查询失败"),EMPTY_SHOP(123,"无商铺id"),ERROR(123123,"失败");
	private int state;
	private String stateInfo;
	private  ProductEnum(int state,String stateInfo) {
		this.state=state;
		this.stateInfo=stateInfo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public static ProductEnum  stateof(int index) {
		for (ProductEnum state: values()) {
			if(state.getState()==index) {
				return state;
			}
		}
		return null;
	}
}
