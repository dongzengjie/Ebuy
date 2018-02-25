package com.example.demo.dzj.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dzj.ebuy.entity.Product;

@Mapper
public interface ProductDao {
	
	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);
	
	/**
	 * 根据商品id查询
	 * @param productId
	 * @return
	 */
	Product queryProductById(Long productId);
	
	/**
	 * 分页查询
	 * @param product
	 * @param rowindex
	 * @param pagesize
	 * @return
	 */
	List<Product> queryProductList(@Param("product")Product product,@Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);
	
	/**
	 * 查询商品种数
	 * @param product
	 * @return
	 */
	int queryProductCount(@Param("product")Product product);
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);
	
	/**
	 * 将小分类id值为空
	 * @param smalltypeId
	 * @return
	 */
	int updateProductSmallTypeIdToNull(@Param("smalltypeId")long smalltypeId, @Param("shopId")long shopId);
}
