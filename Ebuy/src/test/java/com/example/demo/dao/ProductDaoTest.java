package com.example.demo.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.ProductDao;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.util.DateFormatUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void addProduct() {
	/*	Shop shop = new Shop();
		Bigtype bigtype =new Bigtype();
		Smalltype smalltype =new Smalltype();
		Product product =new Product();
		
		
		shop.setShopId(1l);
		bigtype.setBigtypeId(2l);
		smalltype.setSmalltypeId(9l);
		
		product.setProductName("尼康");
		product.setDescription("尼康（Canon） EOS 100D 单反机身");
		product.setBigtype(bigtype);
		product.setEnableStatus(1);
		product.setShop(shop);
		product.setSmalltype(smalltype);
		product.setPrice(2000);
		
		int i =productDao.insertProduct(product);
		System.out.println(product.getProductId());*/
		
		
	}
	
	@Test
	public void testselect() {
		/*Product p=productDao.queryProductById(20L);
		System.out.println(p.getBigtype().getBigName());
		System.out.println(p.getShop().getShopName());*/
		Product product =new Product();
		//product.setProductName("阿");
		/*try {
			product.setSpecialPriceTime(DateFormatUtil.getDateFormat(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*product.setSpecialPriceTime(DateFormatUtil.getDateFormat(new Date()));
		List<Product> list =productDao.queryProductList(product, 0, 999);
		for (Product product2 : list) {
			System.out.println(product2.getProductName());
		}*/
	}
	
	@Test
	public void testlist() {
		/*Product product =new Product();
		Shop shop=new Shop();
		//shop.setShopId(1l);
		product.setProductName("苹果");
		product.setShop(shop);
		
		int count =productDao.queryProductCount(product);
		System.out.println(count);
		List<Product> list = productDao.queryProductList(product, 0, 999);
		
		for (Product product2 : list) {
			System.out.println(product2.getProductName());
		}*/
		
		/*Product product=productDao.queryProductById(325L);
		System.out.println(product.getSmalltype().getSmallName());*/
	}
	
	
	@Test
	public void testupdate() {
		/*Product product =new Product();
		Shop shop=new Shop();
		Smalltype smalltype =new Smalltype();
		smalltype.setSmalltypeId(7l);
		shop.setShopId(2l);
		product.setProductId(8L);
		product.setSmalltype(smalltype);
		product.setShop(shop);
		product.setProductName("乐库优2014春装新款中腰蓝色");
		int i =productDao.updateProduct(product);*/
		
	}
	
	@Test
	public void toNull() {
		/*productDao.updateProductSmallTypeIdToNull(9L,1l);*/
	}
	
	
	
	
	
	
	
	
	
}
