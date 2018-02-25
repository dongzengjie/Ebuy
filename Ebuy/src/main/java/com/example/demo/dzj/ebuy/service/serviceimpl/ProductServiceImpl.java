package com.example.demo.dzj.ebuy.service.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.ProductDao;
import com.example.demo.dzj.ebuy.dto.ImageHolder;
import com.example.demo.dzj.ebuy.dto.ProductExecution;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.enums.ProductEnum;
import com.example.demo.dzj.ebuy.exception.ProductException;
import com.example.demo.dzj.ebuy.service.ProductService;
import com.example.demo.dzj.ebuy.util.ImageUtil;
import com.example.demo.dzj.ebuy.util.PageCalculator;
import com.example.demo.dzj.ebuy.util.PathUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());  
	@Transactional
	public ProductExecution addProduct(Product product, ImageHolder imageHolder) throws ProductException {

		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {

			product.setEnableStatus(1);

			try {

				int effect = productDao.insertProduct(product);
				if (effect <= 0) {
					throw new ProductException("添加失败。。。。");
				}
				if (imageHolder != null) {
					try {
						addimage(product, imageHolder);
					} catch (Exception e) {
						
						 logger.error(e.getMessage(), e);  
						throw new ProductException("!!!!图片资源为空 !!!!"+e.getMessage());
					}
					int effectImg = productDao.updateProduct(product);
					if (effectImg <= 0) {
						throw new ProductException("添加图片失败");
					}
				}

			} catch (Exception e) {
				throw new ProductException("添加失败" + e.getMessage());
			}

		} else {
			return new ProductExecution(ProductEnum.EMPTY_SHOP);
		}
		return new ProductExecution(ProductEnum.SUCCESS, product);
	}

	private void addimage(Product product, ImageHolder imageHolder) {
		String desction = PathUtil.getShopImagePath(product.getShop().getShopId());
		String path = ImageUtil.generateThumbnail(imageHolder, desction);
		product.setProPic(path);
	}

	@Transactional
	public ProductExecution modifyProduct(Product product, ImageHolder imageHolder) throws ProductException {
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			try {
				if (imageHolder != null && imageHolder.getImage() != null && imageHolder.getImageName() != null) {
					Product tempProduct = productDao.queryProductById(product.getProductId());
					if (tempProduct.getProPic() != null) {
						ImageUtil.deleteFileorPath(tempProduct.getProPic());
					}
					addimage(product, imageHolder);
				}

				int effect = productDao.updateProduct(product);
				if (effect <= 0) {
					throw new ProductException("修改失败");
				}
			} catch (Exception e) {
				 logger.error(e.getMessage(), e);  
				throw new ProductException("修改失败：" + e.getMessage());
			}

		} else {
			return new ProductExecution(ProductEnum.EMPTY_SHOP);
		}
		return new ProductExecution(ProductEnum.SUCCESS, product);
	}

	public Product queryProductByProductId(Long productId) {

		return productDao.queryProductById(productId);
	}

	@Transactional
	public ProductExecution queryProductList(Product product, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculatorRowindex(pageIndex, pageSize);
		List<Product> productList = productDao.queryProductList(product, rowIndex, pageSize);
		int count = productDao.queryProductCount(product);
		ProductExecution productExecution = new ProductExecution();
		if (productList == null ) {
			productExecution.setState(ProductEnum.ERROR.getState());
		} else {
			productExecution.setCount(count);
			productExecution.setProductList(productList);
			productExecution.setState(ProductEnum.SUCCESS.getState());
		}
		return productExecution;
	}

}
