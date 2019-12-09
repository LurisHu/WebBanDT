package com.webbanhang.controller.customer;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value= {"customer/sanpham/index",""})
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
	
	@RequestMapping("/customer/danhmuc/phone/{pageNo}")
	public String phone(Model model, @PathVariable("pageNo") int pageNo) {
		if(pageNo >= dao.getPageCountPhone()) {
			pageNo = 0;
		}else if(pageNo < 0) {
			pageNo = dao.getPageCountPhone()-1;
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("lastPageNo", dao.getPageCountPhone()-1);
		model.addAttribute("Phone", dao.findPagePhone(pageNo));
		return "customer/danhmuc/phone";
	}
	
	@RequestMapping("/customer/danhmuc/laptop/{pageNo}")
	public String laptop(Model model, @PathVariable("pageNo") int pageNo) {
		if(pageNo >= dao.getPageCountLaptop()) {
			pageNo = 0;
		}else if(pageNo < 0) {
			pageNo = dao.getPageCountLaptop()-1;
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("lastPageNo", dao.getPageCountLaptop()-1);
		model.addAttribute("Laptop", dao.findPageLaptop(pageNo));
		return "customer/danhmuc/laptop";
	}
	
	@RequestMapping("/customer/danhmuc/phukien/{pageNo}")
	public String phukien(Model model, @PathVariable("pageNo") int pageNo) {
		if(pageNo >= dao.getPageCountLaptop()) {
			pageNo = 0;
		}else if(pageNo < 0) {
			pageNo = dao.getPageCountLaptop()-1;
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("lastPageNo", dao.getPageCountPhuKien()-1);
		model.addAttribute("PhuKien", dao.findPagePhuKien(pageNo));
		return "customer/danhmuc/phukien";
	}
}