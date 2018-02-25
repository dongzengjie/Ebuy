package com.example.demo.dzj.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dzj.ebuy.entity.Smalltype;

@Mapper
public interface SmallTypeDao {

	/**
	 * 根据父分类的id查询子分类
	 * @return
	 */
	List<Smalltype> querySmallTypeByBigId(Long bigTypeId);
	
	/**
	 * 查询所有子分类
	 * @return
	 */
	List<Smalltype> querySmallTypeBybigIdandShopId(@Param("bigtypeId") Long bigtypeId,@Param("shopId") Long shopId);
	/**
	 * 根据子分类id 和店铺id查询
	 * @param smallTypeId
	 * @return
	 */
	Smalltype querySmallTypeBySmallidandShopId(@Param("smalltypeId") Long smalltypeId,@Param("shopId") Long shopId);
	/**
	 * 添加小分类
	 * @return
	 */
	int insertSmallType(Smalltype smalltype);
	
	/**
	 * 根据子分类id删除
	 * @param smalltypeId
	 * @return
	 */
	int deleteSmallTypeById(@Param("smalltypeId") Long smalltypeId,@Param("shopId") Long shopId);
	
	
	int updateSmallTypeBySmallIdandShopId(@Param("smalltypeId") Long smalltypeId,@Param("shopId") Long shopId,@Param("smallName")String smallName);
}
