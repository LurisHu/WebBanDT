/*
*
* Fresher Academy 2019
* @author Kay
* @date Nov 27, 2019
* @version 1.8
* 
*/
package com.webbanhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.webbanhang.interceptor.AdminInterceptor;
import com.webbanhang.interceptor.AuthorizeInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer {
	@Autowired
	AuthorizeInterceptor auth;
	
	@Autowired
	AdminInterceptor admin;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth).addPathPatterns("/cart/thanhtoan", "/bill/view","/bill/detail/*");
		registry.addInterceptor(admin).addPathPatterns("/admin/**");	
	}
}
