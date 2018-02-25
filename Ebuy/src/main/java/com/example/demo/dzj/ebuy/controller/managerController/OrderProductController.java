package com.example.demo.dzj.ebuy.controller.managerController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.service.OrderService;

@RestController
@RequestMapping(value = "/manager")
public class OrderProductController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="/getOrderProduct")
	public Map<String, Object> getOrderProduct(HttpServletRequest request){
		Map<String, Object> modelMap =new HashMap<String, Object>();
		Shop shop =(Shop) request.getSession().getAttribute("shop");
		
		List<Product> productOrderList = orderService.queryProductOrder(shop.getShopId());
		modelMap.put("productOrderList", productOrderList);
		modelMap.put("success", true);
		
		
		return modelMap;
		
	}
}
