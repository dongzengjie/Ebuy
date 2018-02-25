package com.example.demo.dzj.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.Product;

@Mapper
public interface OrderDao {
	
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	int addOrder(Order order);
	
	/**
	 * 查询订单(如果根据订单id查询 返回的list中只有一条记录)
	 * @param orderId
	 * @return
	 */
	List<Order> queryOrder(Order order);
	
	/**
	 * 根据订单id删除订单(调用此方法前 先把OrderProduct中的订单关联信息删除)
	 * @param orderId
	 * @return
	 */
	int deleteOrderByOrderId(long orderId);
	
	List<Product> queryProduct(long shopId);
}
