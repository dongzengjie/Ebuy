package com.example.demo.dzj.ebuy.enums;

public enum UserEnum {
	SUCCESS(1,"操作成功"),INNER_ERROR(2,"插入失败"),QUERY_ERROR(3,"查询失败"),HAVE_USER(3,"用户已存在"),NO_USER(23,"该用户不存在");
	private int state;
	private String stateInfo;
	private  UserEnum(int state,String stateInfo) {
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
	public static UserEnum stateof(int index) {
		for (UserEnum state: values()) {
			if(state.getState()==index) {
				return state;
			}
		}
		return null;
	}
}
