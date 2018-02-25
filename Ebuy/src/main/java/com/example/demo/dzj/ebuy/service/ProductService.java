package com.example.demo.dzj.ebuy.service;

import com.example.demo.dzj.ebuy.dto.ImageHolder;
import com.example.demo.dzj.ebuy.dto.ProductExecution;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.exception.ProductException;

public interface ProductService {

	/**
	 * 添加商品 
	 * @param product
	 * @param imageHolder
	 * @return
	 */
	ProductExecution addProduct(Product product,ImageHolder imageHolder) throws ProductException;
	
	
	/**
	 * 更具商品id查询
	 * @param productId
	 * @return
	 */
	Product queryProductByProductId(Long  productId);
	
	
	/**
	 * 更新商品
	 * @param product
	 * @param imageHolder
	 * @return
	 * @throws ProductException
	 */
	ProductExecution modifyProduct(Product product,ImageHolder imageHolder) throws ProductException;
	
	/**
	 * 分页拆线呢商品id
	 * @param product
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution queryProductList(Product product,int pageIndex,int pageSize);
}
