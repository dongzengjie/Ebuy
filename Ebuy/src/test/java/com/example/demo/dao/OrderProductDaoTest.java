package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.OrderProductDao;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProductDaoTest {

	@Autowired
	private OrderProductDao orderProductDao;
	
	@Test
	public void testadd() {
		
		/*Order order1 =new Order();
		order1.setOrderId(27l);
		Product product1 =new Product();
		product1.setProductId(330L);
		OrderProduct orderProduct1 =new OrderProduct();
		orderProduct1.setNum(2);
		orderProduct1.setProduct(product1);
		orderProduct1.setOrder(order1);
		
		Order order2 =new Order();
		order2.setOrderId(27l);
		Product product2 =new Product();
		product2.setProductId(329L);
		OrderProduct orderProduct2 =new OrderProduct();
		orderProduct2.setNum(2);
		orderProduct2.setProduct(product2);
		orderProduct2.setOrder(order2);
		
		Order order3 =new Order();
		order3.setOrderId(27l);
		Product product3 =new Product();
		product3.setProductId(328L);
		OrderProduct orderProduct3 =new OrderProduct();
		orderProduct3.setNum(2);
		orderProduct3.setProduct(product3);
		orderProduct3.setOrder(order3);
		List<OrderProduct> orderProductList =new ArrayList<OrderProduct>();
		orderProductList.add(orderProduct3);
		orderProductList.add(orderProduct2);
		orderProductList.add(orderProduct1);
		
		orderProductDao.batchInsertOrderProduct(orderProductList);*/
	}
	
	@Test
	public void delete(){
		/*int i =orderProductDao.deleteOrderProductByOrderId(27l);
		System.out.println(i);*/
	}
 }
