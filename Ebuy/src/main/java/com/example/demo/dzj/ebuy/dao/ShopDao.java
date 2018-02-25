package com.example.demo.dzj.ebuy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dzj.ebuy.entity.Shop;

@Mapper
public interface ShopDao {

	/**
	 * 添加店铺
	 * @param shop
	 * @returna's
	 */
	int insertShopInfo(Shop shop);
	
	/**
	 * 根据用户id查询店铺
	 * @param userId
	 * @return
	 */
	Shop queryShopInfoByUserId(Long userId);
	
	/**
	 * 根据店铺id查询
	 * @param shopId
	 * @return
	 */
	Shop queryShopInfoByShopId(Long shopId);
	
}
