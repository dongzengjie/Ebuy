package com.example.demo.dzj.ebuy.controller.frontendController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dzj.ebuy.dto.UserExecution;
import com.example.demo.dzj.ebuy.entity.ShoppingCart;
import com.example.demo.dzj.ebuy.entity.User;


import com.example.demo.dzj.ebuy.enums.UserEnum;
import com.example.demo.dzj.ebuy.service.UserService;
import com.example.demo.dzj.ebuy.util.CheckVrifyCodeUtil;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/fronted")
public class FrontUserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/tologin")
	public  Map<String, Object> managerlogin(HttpServletRequest  request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String parameter =HttpServletRequestUtil.getString(request, "vrifyCode"); 
		String userStr=HttpServletRequestUtil.getString(request, "userStr");
		ObjectMapper objectMapper =new ObjectMapper();
		User user=null;
		
		try {
			user=objectMapper.readValue(userStr, User.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		boolean vrifycode=CheckVrifyCodeUtil.checkVrifyCode(request, parameter);
		if( !vrifycode) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "验证码错误");
			return modelMap;
		}
		if(!user.getUsername().equals(" ") && !user.getPassword().equals(" ")) {
			try {
				UserExecution userExecution =userService.queryUserByUserNameandPassword(user.getUsername(), user.getPassword());
				
				if(userExecution.getUser().getStatus() !=1) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", "没有此用户");
					return modelMap;
				}
				if(userExecution.getState() ==UserEnum.NO_USER.getState()) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", userExecution.getStateinfo());
				}else {
					
					ShoppingCart shoppingCart =new ShoppingCart();
					shoppingCart.setUserId(userExecution.getUser().getUserId());
					request.getSession().setAttribute("shoppingCart", shoppingCart);
					request.getSession().setAttribute("user", userExecution.getUser());	
					
					modelMap.put("success", true);
				}
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", e.getMessage());
			}
		}else {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "用户名密码不能为空！");

		}
		
		return modelMap;
		
	}	
	@PostMapping(value = "/frontedregistuser")
	public Map<String, Object> managerregistuser(HttpServletRequest  request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String parameter =HttpServletRequestUtil.getString(request, "vrifyCode"); 
		String userStr=HttpServletRequestUtil.getString(request, "userStr");
		ObjectMapper objectMapper =new ObjectMapper();
		User user=null;
		try {
			user=objectMapper.readValue(userStr, User.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		boolean vrifycode=CheckVrifyCodeUtil.checkVrifyCode(request, parameter);
		if( !vrifycode) {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "验证码错误");
			return modelMap;
		}
		if (!user.getUsername().equals("") && !user.getPassword().equals("") && !user.getMobile().equals("")) {
			user.setStatus(1);
			try {
				UserExecution userExecution =userService.addUser(user);
				if(userExecution.getState()==UserEnum.HAVE_USER.getState()) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", userExecution.getStateinfo());
				}
				
				if(userExecution.getState() == UserEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				
				}else {
					modelMap.put("success", false);
					modelMap.put("errorMsg", userExecution.getStateinfo());
				}
				
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errorMsg", e.getMessage());
			}
			
			
			
		} else {
			modelMap.put("success", false);
			modelMap.put("errorMsg", "部分信息不能为空！");

		}
		return modelMap;

	}

}
