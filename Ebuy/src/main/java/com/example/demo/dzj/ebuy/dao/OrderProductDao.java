package com.example.demo.dzj.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dzj.ebuy.entity.OrderProduct;

@Mapper
public interface OrderProductDao {

	/**
	 * 根据订单id删除
	 * @param orderId
	 * @return
	 */
	int deleteOrderProductByOrderId(long orderId);
	
	/**
	 * 批量添加
	 * @param orderProductList
	 * @return
	 */
	int batchInsertOrderProduct(List<OrderProduct> orderProductList);
}
