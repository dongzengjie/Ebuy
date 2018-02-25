package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.List;

public class Bigtype implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	private Long bigtypeId;
	private String bigName;
	private String remarks;
	
	private List<Smalltype> smalltypelist;

	public Long getBigtypeId() {
		return bigtypeId;
	}

	public void setBigtypeId(Long bigtypeId) {
		this.bigtypeId = bigtypeId;
	}



	public String getBigName() {
		return bigName;
	}

	public void setBigName(String bigName) {
		this.bigName = bigName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Smalltype> getSmalltypelist() {
		return smalltypelist;
	}

	public void setSmalltypelist(List<Smalltype> smalltypelist) {
		this.smalltypelist = smalltypelist;
	}
	
	
}
