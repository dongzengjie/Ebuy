package com.example.demo.dzj.ebuy.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartSize {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个数据大小
		factory.setMaxFileSize("300MB"); // KB,MB
		/// 总上传数据大小
		factory.setMaxRequestSize("300MB");
		
		return factory.createMultipartConfig();
	}
}
