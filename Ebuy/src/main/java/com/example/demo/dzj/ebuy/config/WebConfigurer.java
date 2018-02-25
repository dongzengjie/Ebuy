package com.example.demo.dzj.ebuy.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.dzj.ebuy.interceptor.ManagerInterceptor;
import com.example.demo.dzj.ebuy.interceptor.UserInterceptor;

@Component
public class WebConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///C:/ebuy/image/upload/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		
		/*String interceptPath ="/**";
		InterceptorRegistration loginIR =registry.addInterceptor(new ManagerInterceptor());
		loginIR.addPathPatterns(interceptPath);
		loginIR.addPathPatterns("/tomanageindex");
		loginIR.excludePathPatterns("/toregist");
		loginIR.excludePathPatterns("/tologin");
		loginIR.excludePathPatterns("/defaultKaptcha");
		loginIR.excludePathPatterns("/manager/tomanagerlogin");
		loginIR.excludePathPatterns("/manager/managerregistuser");
		*/
		
		/*userloginIR.addPathPatterns("/tofrontedshopping");
		userloginIR.addPathPatterns("/tofrontedorder");
		userloginIR.excludePathPatterns("/defaultKaptcha");
		userloginIR.addPathPatterns("/fronted/shoppingCart");
		userloginIR.addPathPatterns("/fronted/getshoppingCart");
		userloginIR.addPathPatterns("/fronted/addOrderInfo");*/
		
	
		super.addInterceptors(registry);
	}
}
