package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.OrderDao;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void testadd() {
		/*Order order =new Order();
		order.setCreateTime(new Date());
		order.setCost(123f);
		order.setOrderNo("asddfw12131");
		order.setStatus(1);
		order.setUserId(1l);
		
		orderDao.addOrder(order);
		System.out.println(order.getOrderId());*/
		
	}
	
	@Test
	public void testquery() {
		/*Order order =new Order();
		order.setOrderId(26L);
		List<Order> list =orderDao.queryOrder(order);
		for (Order order2 : list) {
			System.out.println(order2.getOrderNo());
			List<OrderProduct> orderProducts =order2.getOrderProductlist();
			for (OrderProduct orderProduct : orderProducts) {
				System.out.println(orderProduct.getProduct().getProductName() + orderProduct.getNum());
			}
		}
		
		*/
	}
	
	@Test
	public void testqueryo() {	
		/*List<Product> productList =orderDao.queryProduct(1l);
		System.out.println(productList.size());
		for (Product product : productList) {
			List<OrderProduct> listorderproduct= product.getOrderProductlist();
			for (OrderProduct orderProduct : listorderproduct) {
				System.out.println(orderProduct.getOrder());
			}
		}*/
	}
}
