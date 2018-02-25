package com.example.demo.dzj.ebuy.service;

import java.util.List;

import com.example.demo.dzj.ebuy.entity.Smalltype;

public interface SmallTypeService {

	/**
	 * 添加子分类
	 * @param smalltype
	 * @return
	 */
	int addSmallType(Smalltype smalltype);
	
	/**
	 * 根据大分类 和店铺id查询
	 * @param bigtypeId
	 * @param shopId
	 * @return
	 */
	List<Smalltype> querySmallTypeByBigIdandShopId(Long bigtypeId, Long shopId);
	
	/**
	 * 根据店铺以及小类id查询
	 * @param smalltypeId
	 * @param shopId
	 * @return
	 */
	Smalltype qureySmallTypeBySmallidandShopId(Long smalltypeId,Long shopId);
	
	/**
	 * 更新
	 * @param smalltypeId
	 * @param shopId
	 * @param name
	 * @return
	 */
	int updateSmallTypeBySmallIdandShopId(Long smalltypeId,Long shopId,String name );
}
