package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dto.ImageHolder;
import com.example.demo.dzj.ebuy.dto.ProductExecution;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testAddProduct() throws FileNotFoundException {
		/*Shop shop =new Shop();
		Bigtype bigtype =new Bigtype();
		Smalltype smalltype =new Smalltype();
		Product product =new Product();
		
		bigtype.setBigtypeId(2l);
		smalltype.setSmalltypeId(9L);
		shop.setShopId(1l);
		product.setShop(shop);
		product.setBigtype(bigtype);
		product.setSmalltype(smalltype);
		product.setProductName("这是测试商品 2 ");
		product.setHot(2);
		product.setHotTime(new Date());
		product.setSpecialPrice(200.12f);
		
		File file=new File("G:/bizhi/303405-106.jpg");
		InputStream inputStream=new FileInputStream(file);
		ImageHolder holder=new ImageHolder(file.getName(),inputStream);
		
		ProductExecution productExecution =productService.addProduct(product, holder);
		
		*/
	}
	
	@Test
	public void testupdate() throws FileNotFoundException {
	/*	Shop shop =new Shop();
		Bigtype bigtype =new Bigtype();
		Smalltype smalltype =new Smalltype();
		Product product =new Product();
		product.setProductId(305L);
		bigtype.setBigtypeId(2l);
		smalltype.setSmalltypeId(9L);
		shop.setShopId(1l);
		product.setShop(shop);
		product.setBigtype(bigtype);
		product.setSmalltype(smalltype);
		product.setProductName("这是测试修改后商品  ");
		product.setHot(2);
		product.setHotTime(new Date());
		product.setSpecialPrice(400.12f);
		
		File file=new File("G:/bizhi/QQ图片20170320190214.jpg");
		InputStream inputStream=new FileInputStream(file);
		ImageHolder holder=new ImageHolder(file.getName(),inputStream);
		
		ProductExecution productExecution =productService.modifyProduct(product, holder);
		*/
	}
	
	@Test
	public void queryList() {
		/*Shop shop =new Shop();
		Product product =new Product();
		shop.setShopId(1L);
		product.setShop(shop);
		ProductExecution execution =productService.queryProductList(product, 0, 999);
		List<Product> list =execution.getProductList();
		for (Product product2 : list) {
			System.out.println(product2.getProductName());
		}
		System.out.println(execution.getCount());*/
		
	
	}
	
}
