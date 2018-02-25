package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.ShopDao;
import com.example.demo.dzj.ebuy.dto.ShopExecution;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.service.ShopService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

	@Autowired
	private ShopService shopService;
	
	@Test
	public void  testAddandQuery() {
	/*	ShopExecution shopExecution = shopService.queryShopByUserId(1L);
		//System.out.println(shopExecution.getShop().getName());
			Shop shop =new Shop();
			shop.setShopName("服装店");
			User user =new User();
			user.setUserId(1L);
			shop.setUser(user);
			Bigtype bigtype =new Bigtype();
			bigtype.setBigtypeId(1L);
			shop.setBigtype(bigtype);
			shopExecution=shopService.addShop(shop);
			System.out.println(shopExecution.getStateinfo());
		*/
	}
	
	@Test
	public void testqueryshopbyid() {
		/*shopService.queryShopByUserId(1l);*/
	}
}
