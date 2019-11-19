package com.webbanhang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

	@GetMapping("/account/login")
	public String login() {
		return "redirect:/customer/sanpham/index";
	}
	
	@PostMapping("/account/login")
	public String login(Model model,
			@RequestParam("id") Integer id ,
			@RequestParam("password") String pw) {
		model.addAttribute("user", dao.findById(id));
		NguoiDung user= dao.findById(id);
		if(user==null) {
			model.addAttribute("message","Invaild username");
		}else if(!pw.equals(user.getMatKhau())) {
			model.addAttribute("message","Invaild password");
		}else {
			model.addAttribute("message","Login successfully");
			if(user.getIsAdmin()==true) {
				return "redirect:/admin/nguoidung/index";
			}else {
				return "redirect:/customer/sanpham/index";
			}
		}
		return "redirect:/product/index";
	}

	@GetMapping(value = { "account/register", "register" })
	public String index(Model model) {
		model.addAttribute("nd", new NguoiDung());
		return "account/register/index";
	}

	@PostMapping(value = { "account/register", "register" })
	public String create(@Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors, Model model) {
		// Set default values to create customer
		nd.setLoaiKH(0);
		nd.setIsAdmin(false);
		nd.setIsActive(false);
		// create account
		if (errors.hasErrors()) {
			model.addAttribute("message", "Xin vui lòng sửa các lỗi sau đây");
		} else {
			try {
				dao.create(nd);
				model.addAttribute("message", "Đăng ký thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Đăng ký thất bại");
			}
		}
		return "account/register/index";
	}
}
