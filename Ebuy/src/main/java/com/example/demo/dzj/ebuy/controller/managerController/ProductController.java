package com.example.demo.dzj.ebuy.controller.managerController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.demo.dzj.ebuy.dto.ImageHolder;
import com.example.demo.dzj.ebuy.dto.ProductExecution;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.enums.ProductEnum;
import com.example.demo.dzj.ebuy.service.ProductService;
import com.example.demo.dzj.ebuy.service.SmallTypeService;
import com.example.demo.dzj.ebuy.util.DateFormatUtil;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/manager")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private SmallTypeService smallTypeService;
	 private Logger logger = LoggerFactory.getLogger(this.getClass());  
	/**
	 * 分页查询商品信息
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/queryProductList")
	public Map<String, Object> queryProductList(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		Product product = new Product();
		product.setShop(shop);
		if (shop != null && shop.getShopId() != null) {
			ProductExecution productExecution = productService.queryProductList(product, pageIndex, pageSize);
			if (productExecution.getState() == ProductEnum.ERROR.getState()) {
				modelMap.put("errorMsg", productExecution.getStateInfo());
				modelMap.put("success", false);
			} else {
				modelMap.put("count", productExecution.getCount());
				modelMap.put("productList", productExecution.getProductList());
				modelMap.put("success", true);
			}
		} else {
			modelMap.put("errorMsg", "无商铺信息");
			modelMap.put("success", false);
		}
		return modelMap;

	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/addProduct")
	public Map<String, Object> addProduct(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String productStr = HttpServletRequestUtil.getString(request, "productStr");
		Product product = null;
		ImageHolder imageHolder = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			product = objectMapper.readValue(productStr, Product.class);
		} catch (Exception e) {
			modelMap.put("errorMsg", e.getMessage());
			modelMap.put("success", false);
		}

		// 图片处理
		try {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if(commonsMultipartResolver.isMultipart(request)) {
				MultipartRequest multipartRequest = (MultipartRequest) request;
				MultipartFile file = multipartRequest.getFile("productImg");
				imageHolder = new ImageHolder(file.getOriginalFilename(), file.getInputStream());
			}
			
		} catch (Exception e) {
			 logger.error(e.getMessage(), e);  
			modelMap.put("errorMsg", e.getMessage());
			modelMap.put("success", false);
		}

		if (product != null && imageHolder != null) {
			Shop shop = (Shop) request.getSession().getAttribute("shop");
			Bigtype bigtype = shop.getBigtype();
			product.setShop(shop);
			product.setBigtype(bigtype);
		/*	//TODO需要修改
			
			product.setHotTime(DateFormatUtil.getDateFormat(new Date()));
			product.setSpecialPriceTime(DateFormatUtil.getDateFormat(new Date()));
			////
*/
			ProductExecution productExecution = productService.addProduct(product, imageHolder);
			if (productExecution.getState() == ProductEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("errorMsg", productExecution.getStateInfo());
				modelMap.put("success", false);
			}
		}else {
			modelMap.put("errorMsg", "必须上传图片");
			modelMap.put("success", false);
		}
		return modelMap;

	}
	
	/**
	 * 修改商品
	 * @param request
	 * @return
	 */
	@PostMapping(value="/modifyProduct")
	public Map<String, Object> modifyProduct(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String productStr= HttpServletRequestUtil.getString(request, "productStr");
		ObjectMapper objectMapper =new ObjectMapper();
		ImageHolder imageHolder =null;
		Product product =null;
		
		try {
			product = objectMapper.readValue(productStr, Product.class);
		} catch (Exception e) {
			modelMap.put("errorMsg", e.getMessage());
			modelMap.put("success", false);
		}
		//图片处理
		try {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if(commonsMultipartResolver.isMultipart(request)) {
				MultipartRequest multipartRequest = (MultipartRequest) request;
				MultipartFile file = multipartRequest.getFile("productImg");
				imageHolder = new ImageHolder(file.getOriginalFilename(), file.getInputStream());
			}
			
		} catch (Exception e) {
			
			modelMap.put("errorMsg", e.getMessage());
			modelMap.put("success", false);
		}
		
		if(product !=null && product.getProductId() !=null) {
			Shop shop = (Shop) request.getSession().getAttribute("shop");
			Bigtype bigtype = shop.getBigtype();
			product.setShop(shop);
			product.setBigtype(bigtype);
			
			ProductExecution productExecution =productService.modifyProduct(product, imageHolder);
			if(productExecution.getState()== ProductEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			}else {
				modelMap.put("errorMsg", productExecution.getStateInfo());
				modelMap.put("success", false);
			}
		}

		
		return modelMap;
		
	}
	
	
	/**
	 * 更具id查询(使用restful)
	 * @param request
	 * @return
	 */
	@GetMapping(value="/queryProductById/{productId}")
	public Map<String, Object> queryProductById(HttpServletRequest request, @PathVariable long productId ){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		if(productId <=0) {
			modelMap.put("errorMsg", "商品id为空");
			modelMap.put("success", false);
		}else {
			List<Smalltype> smalltypeList = smallTypeService
					.querySmallTypeByBigIdandShopId(shop.getBigtype().getBigtypeId(), shop.getShopId());
			Product product =productService.queryProductByProductId(productId);
			modelMap.put("success", true);
			modelMap.put("product", product);
			modelMap.put("smalltypeList", smalltypeList);
		}
		
		return modelMap;
		
	}
	
	

}
