package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.ShopDao;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest {
	@Autowired
	private ShopDao shopDao;
	@Test
	public void testadd() {
		/*User user =new User();
		Bigtype bigtype =new Bigtype();
		user.setUserId(1L);
		bigtype.setBigtypeId(1L);
		Shop shop=new Shop();
		shop.setBigtype(bigtype);
		shop.setUser(user);
		shop.setShopName("啊增数码");
		
		int i =shopDao.insertShopInfo(shop);
		System.out.println(i);*/
	}
	@Test
	public void testquery() {
		//Shop shop=shopDao.queryShopInfoByShopId(1L);
/*		Shop shop1=shopDao.queryShopInfoByUserId(1L);
		System.out.println(shop1.getUser().getUsername());
		System.out.println(shop1.getBigtype().getBigtypeId());
		System.out.println(	shop1.getBigtype().getBigName());*/
	
	}
}
