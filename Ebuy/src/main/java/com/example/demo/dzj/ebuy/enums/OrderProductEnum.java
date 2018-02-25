package com.example.demo.dzj.ebuy.enums;

public enum OrderProductEnum {
	SUCCESS(1,"操作成功"),ERROR(-1002,"操作失败");
	
	private int state;
	private String stateInfo;
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
	
	private OrderProductEnum(int state,String stateInfo) {
		this.state=state;
		this.stateInfo=stateInfo;
	}
	
	public static OrderProductEnum  stateof(int index) {
		for (OrderProductEnum state: values()) {
			if(state.getState()==index) {
				return state;
			}
		}
		return null;
	}
}
