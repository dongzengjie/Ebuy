package com.example.demo.dzj.ebuy.controller.managerController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dzj.ebuy.dto.ShopExecution;
import com.example.demo.dzj.ebuy.dto.UserExecution;
import com.example.demo.dzj.ebuy.entity.User;
import com.example.demo.dzj.ebuy.enums.ShopEnum;
import com.example.demo.dzj.ebuy.enums.UserEnum;
import com.example.demo.dzj.ebuy.service.ShopService;
import com.example.demo.dzj.ebuy.service.UserService;
import com.example.demo.dzj.ebuy.util.CheckVrifyCodeUtil;
import com.example.demo.dzj.ebuy.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/manager")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ShopService shopservice;
	/**
	 * 店家注册
	 * @param user
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/managerregistuser")
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
			user.setStatus(2);
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
	
	/**
	 * 店家登陆
	 * @param user
	 * @param request
	 * @return
	 */
	@PostMapping(value="/tomanagerlogin")
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
				
				if(userExecution.getUser().getStatus() !=2) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", "你不是店家");
					return modelMap;
				}
				if(userExecution.getState() ==UserEnum.NO_USER.getState()) {
					modelMap.put("success", false);
					modelMap.put("errorMsg", userExecution.getStateinfo());
				}else {
					ShopExecution shopExecution =shopservice.queryShopByUserId(userExecution.getUser().getUserId());
					if(shopExecution.getState() == ShopEnum.EMPTY.getState()) {
						modelMap.put("success", true);
						modelMap.put("haveshop", false);
						request.getSession().setAttribute("user", userExecution.getUser());
					}else {
						modelMap.put("success", true);
						modelMap.put("haveshop", true);
						request.getSession().setAttribute("shop", shopExecution.getShop());
						request.getSession().setAttribute("user", userExecution.getUser());
					}
					
					
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

}
