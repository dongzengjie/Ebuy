package com.example.demo.dzj.ebuy.util;

public class PageCalculator {

	public static int calculatorRowindex(int pageIndex,int pagesize){
		return (pageIndex>0)? (pageIndex-1)*pagesize:0;
	}
}
