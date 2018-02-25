package com.example.demo.dzj.ebuy.controller.frontendController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class FrontedUrl {

	@RequestMapping(value="/tofrontedindex",method=RequestMethod.GET)
	public String tofrontedindex() {
	
		return "fronted/index";
		
	}
	
	@RequestMapping(value="/tofrontedproductlist")
	public String tofrontedproductlist() {
	
		return "fronted/product-list";
		
	}
	
	@RequestMapping(value="/tofrontedlogin")
	public String tofrontedlogin() {
	
		return "fronted/login";
		
	}
	
	@RequestMapping(value="/tofrontedregist")
	public String tofrontedregist() {
	
		return "fronted/register";
		
	}
	
	@RequestMapping(value="/tofrontedshopping")
	public String tofrontedshopping() {
	
		return "fronted/shopping";
		
	}
	
	@RequestMapping(value="/tofrontedorder")
	public String tofrontedorder() {
	
		return "fronted/order";
		
	}
	
	
}
