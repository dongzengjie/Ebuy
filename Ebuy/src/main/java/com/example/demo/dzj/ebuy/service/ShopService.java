package com.example.demo.dzj.ebuy.service;

import com.example.demo.dzj.ebuy.dto.ShopExecution;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.exception.ShopException;

public interface ShopService {

	/**
	 * 增加店铺
	 * @param shop
	 * @return
	 */
	ShopExecution addShop(Shop shop) throws ShopException;
	
	/**
	 * 根据用户Id查询店铺
	 * 
	 * @param userId
	 * @return
	 */
	ShopExecution queryShopByUserId(Long userId) throws ShopException;
	
}
