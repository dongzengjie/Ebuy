package com.example.demo.dzj.ebuy.controller.managerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ManagerUrl {

	@RequestMapping(value="/toshopadd")
	public String toshopadd() {
	
		return "manage/shop-add";
		
	}
	
	@RequestMapping(value="/tomanagerresult")
	public String tomanagerresult() {
	
		return "manage/manage-result";
		
	}
	
	@RequestMapping(value="/tomanageindex")
	public String tomanageindex() {
	
		return "manage/index";
		
	}
	
	@RequestMapping(value="/toregist")
	public String toregist() {
		return "manage/register";
	}
	

	@RequestMapping(value="/tologin")
	public String tologin() {
		return "manage/login";
	}
	
	@RequestMapping(value="/toproductClass")
	public String toproductClass() {
		return "manage/productClass";
	}
	
	@RequestMapping(value="/toproductClassAdd")
	public String toproductClassAdd() {
		return "manage/productClass-add";
	}
	
	@RequestMapping(value="/toproductClassmodify")
	public String toproductClassmodify() {
		return "manage/productClass-modify";
	}
	
	@RequestMapping(value="/toproduct")
	public String toproduct() {
		return "manage/product";
	}
	
	@RequestMapping(value="/toproductmodify")
	public String toproductmodify() {
		return "manage/product-modify";
	}
	
	
	@RequestMapping(value="/toproductview")
	public String toproductview() {
		return "fronted/product-view";
	}
	
	@RequestMapping(value="/toproductadd")
	public String toproductadd() {
		return "manage/product-add";
	}
	
}
