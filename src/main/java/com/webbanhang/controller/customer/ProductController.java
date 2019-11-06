package com.webbanhang.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.entity.SanPham;

@Controller
public class ProductController {
	@Autowired
	SanPhamDAO dao;
	
	@RequestMapping("/")
	public String list(Model model) {
		List<SanPham> list = dao.findAll();
		model.addAttribute("list", list);
		return "customer/product/index";
	}
}
