package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.OrderDao;
import com.example.demo.dzj.ebuy.dto.OrderExecution;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.service.OrderService;
import com.example.demo.dzj.ebuy.util.OrderIdUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	@Autowired
	private OrderService orderService;

	@Test
	public void add() {
		float cost = 0f;

/*		Product product3 = new Product();
		product3.setProductId(328L);
		product3.setPrice(123f);

		Product product2 = new Product();
		product2.setProductId(329L);
		product2.setPrice(12f);

		Product product1 = new Product();
		product1.setProductId(330L);
		product1.setPrice(123f);

		OrderProduct orderProduct1 = new OrderProduct();
		orderProduct1.setNum(1);
		orderProduct1.setProduct(product1);

		OrderProduct orderProduct2 = new OrderProduct();
		orderProduct2.setNum(2);
		orderProduct2.setProduct(product2);

		OrderProduct orderProduct3 = new OrderProduct();
		orderProduct3.setNum(1);
		orderProduct3.setProduct(product3);

		List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		orderProducts.add(orderProduct3);
		orderProducts.add(orderProduct2);
		orderProducts.add(orderProduct1);

		for (OrderProduct orderProduct : orderProducts) {
			cost += orderProduct.getNum() * orderProduct.getProduct().getPrice();
		}

		Order order = new Order();
		order.setCost(cost);
		order.setOrderNo(OrderIdUtil.getOrderIdByUUId());
		order.setUserId(5l);
		order.setCreateTime(new Date());

		orderService.addOrder(order, orderProducts);*/
	}

	@Test
	public void query() {
/*
		Order order = new Order();
		order.setUserId(5l);

		OrderExecution execution = orderService.queryorder(order);
		System.out.println(execution.getOrderList().size());*/

	}
	
	@Test
	public void delete() {
		/*orderService.deleteOrderByOrderId(28l);*/
	}
}
