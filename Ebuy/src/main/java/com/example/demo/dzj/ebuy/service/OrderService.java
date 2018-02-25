package com.example.demo.dzj.ebuy.service;

import java.util.List;

import com.example.demo.dzj.ebuy.dto.OrderExecution;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.exception.OrderException;

public interface OrderService {
	
	/**
	 * 插入订单
	 * @param order
	 * @return
	 * @throws OrderException
	 */
	OrderExecution addOrder(Order order,List<OrderProduct> orderProductList) throws OrderException;
	
	/**
	 * 查询订单(如果根据订单id查询 返回的list中只有一条记录)
	 * @param order
	 * @return
	 */
	OrderExecution queryorder(Order order) throws OrderException;
	
	/**
	 * 根据订单id删除订单(调用此方法前 先把OrderProduct中的订单关联信息删除)
	 * @param orderId
	 * @return
	 */
	OrderExecution deleteOrderByOrderId(long orderId);
	
	
	List<Product> queryProductOrder(long shopId);
}
