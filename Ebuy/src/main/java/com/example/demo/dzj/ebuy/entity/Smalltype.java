package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;

public class Smalltype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long smalltypeId;
	private String smallName;
	private String 	remarks;
	private Long bigtypeId;
	private Long shopId;
	public Long getSmalltypeId() {
		return smalltypeId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public void setSmalltypeId(Long smalltypeId) {
		this.smalltypeId = smalltypeId;
	}

	public String getSmallName() {
		return smallName;
	}
	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getBigtypeId() {
		return bigtypeId;
	}
	public void setBigtypeId(Long bigtypeId) {
		this.bigtypeId = bigtypeId;
	}
	
}
