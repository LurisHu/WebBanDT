package com.webbanhang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.entity.SanPham;

@Controller
public class ProductController {
	@Autowired
	SanPhamDAO dao;
	
	@RequestMapping("customer/sanpham/index")
	public String index(Model model) {
		model.addAttribute("form", new SanPham());
		int PageNo = 0;
		model.addAttribute("BestSellerPhone", dao.BestSellerPhone(PageNo));
		model.addAttribute("BestSellerLaptop", dao.BestSellerLaptop(PageNo));
		model.addAttribute("BestSellerPhuKien", dao.BestSellerPhuKien(PageNo));
		model.addAttribute("AllProduct", dao.findAll());
		return "customer/sanpham/index";
	}
	
	@RequestMapping("/customer/sanpham/detail/{id}")
	public String detail(Model model,
			@PathVariable("id")Integer id ) {
		SanPham p = dao.findById(id);
		model.addAttribute("item", p);
		int PageNo = 0;
		model.addAttribute("BestSellerPhone", dao.BestSellerPhone(PageNo));
		return "customer/sanpham/detail";
	}
	
	@RequestMapping("/customer/sanpham/phone")
	public String phone(Model model) {
		model.addAttribute("form", new SanPham());
		int PageNo = 0;
		model.addAttribute("Phone", dao.AllPhone(PageNo));
		return "customer/sanpham/phone";
	}
}