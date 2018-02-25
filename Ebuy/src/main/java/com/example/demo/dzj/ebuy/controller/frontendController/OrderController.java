package com.example.demo.dzj.ebuy.controller.frontendController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.dto.OrderExecution;
import com.example.demo.dzj.ebuy.entity.Order;
import com.example.demo.dzj.ebuy.entity.OrderProduct;
import com.example.demo.dzj.ebuy.entity.Product;
import com.example.demo.dzj.ebuy.entity.ShoppingCart;
import com.example.demo.dzj.ebuy.entity.ShoppingCartItems;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.enums.OrderEnum;
import com.example.demo.dzj.ebuy.service.OrderService;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;
import com.example.demo.dzj.ebuy.util.OrderIdUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/fronted")
public class OrderController {

	@Autowired
	private OrderService orderService;

	
	/**
	 * 添加订单信息
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/addOrderInfo")
	public Map<String, Object> addOrderInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Order order =new Order();
		order.setCreateTime(new Date());
		order.setOrderNo(OrderIdUtil.getOrderIdByUUId());
		order.setStatus(0);
		
		float cost=0.0f;
		// 判断是否是购物车中的商品
		boolean fromShoppingCart = HttpServletRequestUtil.getBoolean(request, "fromShoppingCart");
		List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();

		if (fromShoppingCart) {
			// 从session中获取购物车
			HttpSession session = request.getSession();
			ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
			List<ShoppingCartItems> shoppingCartItemList = shoppingCart.getShoppingCartItemsList();
			for (ShoppingCartItems shoppingCartItems : shoppingCartItemList) {
				OrderProduct orderProduct =new OrderProduct();
				orderProduct.setNum(shoppingCartItems.getCount());
				orderProduct.setProduct(shoppingCartItems.getProduct());
				cost += shoppingCartItems.getCount() * shoppingCartItems.getProduct().getPrice();
				orderProductList.add(orderProduct);
			}
			order.setCost(cost);
			order.setUserId(shoppingCart.getUserId());
			try {
				OrderExecution orderExecution =orderService.addOrder(order, orderProductList);
				if(orderExecution.getState() ==OrderEnum.ERROR.getState()) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", orderExecution.getStateInfo());
				}else {
					ShoppingCart shoppingCart1 =new ShoppingCart();
					shoppingCart1.setUserId(shoppingCart.getUserId());
					request.getSession().setAttribute("shoppingCart", shoppingCart1);
					modelMap.put("success", true);
				}
				
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", e.getMessage());
			}
			
			
		} else {
			User user=(User) request.getSession().getAttribute("user");
			
			if(user ==null) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", "请先登录");
			}
			
			String productStr=HttpServletRequestUtil.getString(request, "productStr");
			ObjectMapper objectMapper =new ObjectMapper();
			Product product=null;
			try {
				product = objectMapper.readValue(productStr, Product.class);
				order.setUserId(user.getUserId());
				order.setCost(product.getPrice());
				OrderProduct orderProduct =new OrderProduct();
				orderProduct.setNum(1);
				orderProduct.setProduct(product);
				
				orderProductList.add(orderProduct);
				
				try {
					OrderExecution orderExecution =orderService.addOrder(order, orderProductList);
					if(orderExecution.getState() ==OrderEnum.ERROR.getState()) {
						modelMap.put("success", false);
						modelMap.put("errorMsg", orderExecution.getStateInfo());
					}else {
						modelMap.put("success", true);
					}
					
				} catch (Exception e) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", e.getMessage());
				}
				
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", e.getMessage());
			}
			
		}
		return modelMap;
	}
	
	/**
	 * 获取订单信息
	 * @param request
	 * @return
	 */
	@GetMapping(value="/getOrderInfo")
	public Map<String, Object> getOrderInfo(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		float cost =0.0f;
		User user=(User) request.getSession().getAttribute("user");
		
		if(user ==null) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "请先登录");
		}
		
		try {
			Order order =new Order();
			order.setUserId(user.getUserId());
			OrderExecution orderExecution= orderService.queryorder(order);
			if(orderExecution.getState() ==OrderEnum.SUCCESS.getState()) {
				List<Order> orderList= orderExecution.getOrderList();
				modelMap.put("success", true);
			
				for (Order ordercost : orderList) {
					cost +=ordercost.getCost();
				}
				modelMap.put("cost", cost);
				modelMap.put("user", user);
				modelMap.put("orderList", orderList);
			}else {
				modelMap.put("success", false);
				modelMap.put("errorMsg", orderExecution.getStateInfo());
			}
			
			
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
	
	@GetMapping(value="/deleteOrder/{orderId}")
	public Map<String, Object> deleteOrder(HttpServletRequest request, @PathVariable long orderId){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			OrderExecution orderExecution=orderService.deleteOrderByOrderId(orderId);
			if(orderExecution.getState()==OrderEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			}else {
				modelMap.put("success", false);
				modelMap.put("errorMsg", orderExecution.getStateInfo());
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
}
