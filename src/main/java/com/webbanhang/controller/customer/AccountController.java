package com.webbanhang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.NguoiDung;

@Controller
public class AccountController {
	@Autowired
	NguoiDungDAO dao;
	
	@GetMapping(value= {"account/login","login"})
	public String login(){
		return "account/login/index";
	}
	@PostMapping(value= {"account/login","login"})
	public String loginVerify(
			@RequestParam("email")String email,
			@RequestParam("pwd")String password){
//		if() {
//			
//		}
		return "account/login/index";
	}
	@GetMapping(value= {"account/register","register"})
	public String index(Model nd){
		nd.addAttribute("nd", new NguoiDung());
		return "account/register/index";
	}
	@PostMapping(value= {"account/register","register"})
	public String create(@ModelAttribute("nd")NguoiDung nd){
		//Set default values
		nd.setLoaiKH(0);
		nd.setIsAdmin(false);
		
		//reate accoutn
		dao.create(nd);
		
		System.out.println("Đăng ký thành công");
		return "redirect:account/login";
	}
}
