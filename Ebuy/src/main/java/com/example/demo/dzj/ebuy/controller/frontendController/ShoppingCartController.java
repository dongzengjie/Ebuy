package com.example.demo.dzj.ebuy.controller.frontendController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.ShoppingCart;
import com.example.demo.dzj.ebuy.entity.ShoppingCartItems;

@RestController
@RequestMapping(value = "/fronted")
public class ShoppingCartController {

	/**
	 * 将购物车中的商品存入Session中
	 */

	private boolean flag = false;

	/**
	 * 添加商品到购物车
	 */
	@PostMapping(value = "/shoppingCart")
	public Map<String, Object> shoppingCart(HttpServletRequest request, @RequestBody Product product) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();

		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		ShoppingCartItems items = new ShoppingCartItems();

		List<ShoppingCartItems> cartItems = shoppingCart.getShoppingCartItemsList();

		
		try {

			if (cartItems.size() > 0) {

				for (ShoppingCartItems shoppingCartItems : cartItems) {
					long id = shoppingCartItems.getProduct().getProductId();
					if (id == product.getProductId()) {
						shoppingCartItems.setCount(shoppingCartItems.getCount() + 1);
						flag = true;
						break;
					}
				}

				if (!flag) {

					items.setProduct(product);
					items.setCount(1);
					shoppingCart.getShoppingCartItemsList().add(items);

				}
				flag = false;
			} else {
				items.setProduct(product);
				items.setCount(1);
				shoppingCart.getShoppingCartItemsList().add(items);
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}

		return modelMap;
	}
	
	

	/**
	 * 获取购物车中的商品
	 * @param request
	 * @return
	 */
	@GetMapping(value="/getshoppingCart")
	public Map<String, Object> getshoppingCart(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if(shoppingCart !=null) {
			modelMap.put("success", true);
			modelMap.put("shoppingCart", shoppingCart);
			modelMap.put("size", shoppingCart.getShoppingCartItemsList().size());
		}else {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "请先登录");
		}
		
		return modelMap;
	}
	
	/**
	 * 移除商品
	 * @param request
	 * @return
	 */
	@GetMapping(value="/removeproduct/{index}")
	public Map<String, Object> removeproduct(HttpServletRequest request,@PathVariable int index) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		List<ShoppingCartItems> cartItems = shoppingCart.getShoppingCartItemsList();
		try {
			cartItems.remove(index);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		
		return modelMap;
	}
	

}
