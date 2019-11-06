package com.webbanhang.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	@RequestMapping("account/login")
	public String login(){
		return "account/login";
	}
	@RequestMapping("account/register")
	public String register(){
		return "account/register";
	}
}
