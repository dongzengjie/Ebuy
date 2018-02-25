package com.example.demo.dzj.ebuy.controller.frontendController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.dto.ProductExecution;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.enums.ProductEnum;
import com.example.demo.dzj.ebuy.service.BigtypeService;
import com.example.demo.dzj.ebuy.service.ProductService;
import com.example.demo.dzj.ebuy.service.SmallTypeService;
import com.example.demo.dzj.ebuy.util.DateFormatUtil;

@RestController
@RequestMapping(value = "/fronted")
public class ProductFrontController {

	@Autowired
	private ProductService productService;
	@Autowired
	private BigtypeService bigtypeService;
	@Autowired
	private SmallTypeService smallTypeService;

	@GetMapping(value = "/getFrontIndexInfo")
	public Map<String, Object> getFrontIndexInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Product productspecial = new Product();
		productspecial.setSpecialPriceTime(DateFormatUtil.getDateFormat(new Date()));
		productspecial.setEnableStatus(1);
		Product productHot = new Product();
		productHot.setEnableStatus(1);
		productHot.setHotTime(DateFormatUtil.getDateFormat(new Date()));
		try {
			ProductExecution productSpecialExecution = productService.queryProductList(productspecial, 0, 8);
			ProductExecution productHotExecution = productService.queryProductList(productHot, 0, 20);
			if (productSpecialExecution.getState() == ProductEnum.ERROR.getState()
					|| productHotExecution.getState() == ProductEnum.ERROR.getState()) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", "获取商品信息失败");
			}
			
			List<Bigtype> bigtypeList= bigtypeService.queryAllType();
			
			modelMap.put("success", true);
			modelMap.put("bigtypeList", bigtypeList);
			modelMap.put("productSpecialList", productSpecialExecution.getProductList());
			modelMap.put("productHotList", productHotExecution.getProductList());
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		return modelMap;

	}
	
	@GetMapping(value = "/getproductListBySmallId/{smalltypeId}/{pageindex}")
	public Map<String, Object> getproductListBySmallId(HttpServletRequest request,@PathVariable long smalltypeId,@PathVariable int pageindex) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Product product =new Product();
		Smalltype smalltype =new Smalltype();
		smalltype.setSmalltypeId(smalltypeId);
		product.setSmalltype(smalltype);
		try {
			List<Bigtype> bigtypeList= bigtypeService.queryAllType();
			ProductExecution productExecution =productService.queryProductList(product, pageindex, 12);
			if(productExecution.getState() == ProductEnum.ERROR.getState()) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", "获取商品信息失败");
			}
			modelMap.put("success", true);
			modelMap.put("bigtypeList", bigtypeList);
			modelMap.put("productList", productExecution.getProductList());
			modelMap.put("count", productExecution.getCount()); 
			
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
	
	@GetMapping(value="/getproductinfo/{productId}")
	public Map<String, Object> getproductListBySmallId(HttpServletRequest request,@PathVariable long productId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		/*Product product =new Product();
		product.setProductId(productId);*/
		try {
			List<Bigtype> bigtypeList= bigtypeService.queryAllType();
			
			Product product=productService.queryProductByProductId(productId);
			
			modelMap.put("success", true);
			modelMap.put("product", product);
			modelMap.put("bigtypeList", bigtypeList);
			
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
}
