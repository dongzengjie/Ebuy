package com.example.demo.dzj.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dzj.ebuy.entity.Bigtype;

@Mapper
public interface BigTypeDao {
	/**
	 * 查询父分类以及父分类下的子分类
	 * @return
	 */
	List<Bigtype> queryBigtypeAndSmallType();
	
	
	/**
	 * 查询父分类
	 * @return
	 */
	List<Bigtype> queryBigtype();
	
	/**
	 * 添加大分类
	 * @return
	 */
	int insertBigType(Bigtype bigtype);
}
