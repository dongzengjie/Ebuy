package com.example.demo.dzj.ebuy.service;

import java.util.List;

import com.example.demo.dzj.ebuy.entity.Bigtype;

public interface BigtypeService {

	/**
	 * 查询付分类
	 * @return
	 */
	List<Bigtype> queryBigtypeList();
	
	/**
	 * 查询父分类和子分类
	 * @return
	 */
	List<Bigtype> queryAllType();
}
