package com.example.demo.dzj.ebuy.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.OrderDao;
import com.example.demo.dzj.ebuy.dao.OrderProductDao;
import com.example.demo.dzj.ebuy.dto.OrderExecution;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.enums.OrderEnum;
import com.example.demo.dzj.ebuy.exception.OrderException;
import com.example.demo.dzj.ebuy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderProductDao orderProdcutDao;

	@Transactional
	public OrderExecution addOrder(Order order, List<OrderProduct> orderProductList) throws OrderException {
		if (order != null && order.getCost() != 0 && order.getOrderNo() != null) {

			try {
				int effectOrder = orderDao.addOrder(order);
				if (effectOrder <= 0) {
					return new OrderExecution(OrderEnum.ERROR);
				}

				for (OrderProduct orderProduct : orderProductList) {
					orderProduct.setOrder(order);
				}

				int effectorderProduct = orderProdcutDao.batchInsertOrderProduct(orderProductList);

				if (effectorderProduct <= 0) {
					return new OrderExecution(OrderEnum.ERROR);
				}
				order.setOrderProductlist(orderProductList);
				return new OrderExecution(OrderEnum.SUCCESS, order);
			} catch (Exception e) {
				throw new OrderException("错误信息:" + e.getMessage());
			}
		} else {
			return new OrderExecution(OrderEnum.ERROR);
		}

	}

	@Transactional
	public OrderExecution queryorder(Order order) throws OrderException {

		if (order != null) {

			List<Order> orderList = orderDao.queryOrder(order);
			if (orderList.size() <= 0) {
				return new OrderExecution(OrderEnum.ERROR);
			} else {
				return new OrderExecution(OrderEnum.SUCCESS, orderList);
			}

		} else {
			return new OrderExecution(OrderEnum.ERROR);
		}

	}

	@Transactional
	public OrderExecution deleteOrderByOrderId(long orderId) {
		if (orderId <= 0) {
			return new OrderExecution(OrderEnum.NULL_ORDERID);
		} else {
			int effectorderProduct = orderProdcutDao.deleteOrderProductByOrderId(orderId);
			if (effectorderProduct <= 0) {
				return new OrderExecution(OrderEnum.ERROR);
			}

			int effectorder = orderDao.deleteOrderByOrderId(orderId);

			if (effectorder <= 0) {
				return new OrderExecution(OrderEnum.ERROR);
			}
			return new OrderExecution(OrderEnum.SUCCESS);
		}

	}

	@Transactional
	public List<Product> queryProductOrder(long shopId) {

		List<Product> orderProduct = orderDao.queryProduct(shopId);

		return orderProduct;

	}

}
