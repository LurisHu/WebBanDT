package com.webbanhang.controller.customer;

import javax.servlet.http.HttpSession;

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

	@Autowired
	HttpSession session;

//	@GetMapping("/account/login")
//	public String login() {
//		return "redirect:/customer/sanpham/index";
//	}
//	
	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String pw) {
		model.addAttribute("nd", dao.findByEmail(email));
		NguoiDung user = dao.findByEmail(email);
		session.setAttribute("user", user);
		if (user == null) {
			model.addAttribute("message", "Email không tồn tại");
		} else if (!pw.equals(user.getMatKhau())) {
			model.addAttribute("message", "Mật khẩu không chính xác");
		} else {
			model.addAttribute("message", "Đăng nhập thành công");
			if (user.getIsAdmin() == true) {
				return "redirect:/admin/nguoidung/index";
			} else {
				return "redirect:/customer/sanpham/index";
			}
		}
		return "account/login/index";
	}

	@GetMapping(value = { "account/login", "login" })
	public String login(Model model) {
		model.addAttribute("nd", new NguoiDung());
		return "account/login/index";
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

		if (errors.hasErrors() || (dao.findByEmail(nd.getEmail()) != null && !(nd.getEmail().isEmpty()))) {
			model.addAttribute("message", "Xin vui lòng sửa các lỗi sau đây");
			if (dao.findByEmail(nd.getEmail()) != null && !(nd.getEmail().isEmpty())) {
				model.addAttribute("checkEmail", "Email đã được sử dụng. Vui lòng chọn email khác!");
			}
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
