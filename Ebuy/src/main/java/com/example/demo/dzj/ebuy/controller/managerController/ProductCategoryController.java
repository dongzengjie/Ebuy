package com.example.demo.dzj.ebuy.controller.managerController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.service.BigtypeService;
import com.example.demo.dzj.ebuy.service.SmallTypeService;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;

@RestController
@RequestMapping(value = "/manager")
public class ProductCategoryController {

	@Autowired
	private BigtypeService bigtypeService;

	@Autowired
	private SmallTypeService smallTypeService;

	/**
	 * 获取分类信息
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/getCategoryInfo")
	public Map<String, Object> getCategoryInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		String bigtype = shop.getBigtype().getBigName();

		try {
			List<Smalltype> smalltypeList = smallTypeService
					.querySmallTypeByBigIdandShopId(shop.getBigtype().getBigtypeId(), shop.getShopId());
			modelMap.put("success", true);
			modelMap.put("bigtype", bigtype);
			modelMap.put("smalltypeList", smalltypeList);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}

		return modelMap;

	}

	@PostMapping(value = "/addcategory")
	public Map<String, Object> addcategory(@RequestBody Smalltype smalltype, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		smalltype.setBigtypeId(shop.getBigtype().getBigtypeId());
		smalltype.setShopId(shop.getShopId());
		if (smalltype.getSmallName().equals("")) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "不能为空");
			return modelMap;
		}

		int effect = smallTypeService.addSmallType(smalltype);
		if (effect <= 0) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "添加失败");
		} else {
			modelMap.put("success", true);
		}

		return modelMap;

	}

	/**
	 * 更新
	 */
	@PostMapping(value = "/updateSmalltype")
	public Map<String, Object> updateSmalltype(@RequestBody Smalltype smalltype, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop = (Shop) request.getSession().getAttribute("shop");

		if (smalltype.getSmallName().equals("")) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "不能为空");
			return modelMap;
		}
		int effect = smallTypeService.updateSmallTypeBySmallIdandShopId(smalltype.getSmalltypeId(), shop.getShopId(),
				smalltype.getSmallName());
		if (effect <= 0) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "添加失败");
		} else {
			modelMap.put("success", true);
		}

		return modelMap;

	}
	
	@GetMapping(value="/querySmallTypeAndBigType")
	public  Map<String, Object> querySmallTypeAndBigType(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop shop = (Shop) request.getSession().getAttribute("shop");
		Long smalltypeId= HttpServletRequestUtil.getLong(request, "smalltypeId");
		String bigtype = shop.getBigtype().getBigName();
		Smalltype smalltype =smallTypeService.qureySmallTypeBySmallidandShopId(smalltypeId, shop.getShopId());
		modelMap.put("bigtype", bigtype);
		modelMap.put("smalltype", smalltype.getSmallName());
		modelMap.put("success", true);
		
		return modelMap;
		
	}
}
