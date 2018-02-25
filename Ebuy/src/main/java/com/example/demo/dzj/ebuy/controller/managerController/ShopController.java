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

import com.example.demo.dzj.ebuy.dto.ShopExecution;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.enums.ShopEnum;
import com.example.demo.dzj.ebuy.service.BigtypeService;
import com.example.demo.dzj.ebuy.service.ShopService;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/manager")
public class ShopController {

	@Autowired
	private BigtypeService bigtypeservice;

	@Autowired
	private ShopService shopservice;

	/**
	 * 添加店铺
	 * 
	 * @param request
	 * @return
	 */

	@PostMapping(value = "/addShop")
	public Map<String, Object> addShop(HttpServletRequest request,@RequestBody Shop shop) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
	
		
		User user1=(User) request.getSession().getAttribute("user");
		
		if(shop.getShopName().equals("")) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "店铺名字不能为空");
			return modelMap;
		}
		try {
			shop.setUser(user1);
			
			ShopExecution shopExecution = shopservice.addShop(shop);
			if (shopExecution.getState() == ShopEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
				ShopExecution shoptemp=shopservice.queryShopByUserId(user1.getUserId());
				request.getSession().setAttribute("shop", shoptemp.getShop());
			} else {
				modelMap.put("success", false);
				modelMap.put("errorMsg", shopExecution.getStateinfo());
				return modelMap;
			}

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
			return modelMap;
		}

		return modelMap;

	}

	@GetMapping(value = "/getbigtype")
	public Map<String, Object> getbigtype() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Bigtype> bigtypeList=bigtypeservice.queryBigtypeList();
		modelMap.put("success", true);
		modelMap.put("bigtypeList", bigtypeList);
		return modelMap;

	}
}
