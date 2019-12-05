package com.webbanhang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.HoaDonChiTietDAO;
import com.webbanhang.dao.HoaDonDAO;
import com.webbanhang.entity.HoaDon;
import com.webbanhang.entity.HoaDonChiTiet;

@Controller
public class BillController {
	@Autowired
	HoaDonDAO dao;

	@Autowired
	HoaDonChiTietDAO ctDao;

	@RequestMapping("/bill/view")
	public String bill(Model model, @CookieValue(value = "userId", defaultValue = "not") Integer userId) {
		model.addAttribute("hoadons", dao.findHoaDonCustomer(userId));
		model.addAttribute("hoadon", new HoaDon());
		return "customer/hoadon/index";
	}

	@RequestMapping("/bill/detail/{id}")
	public String billDetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("details",  ctDao.findByHoaDon(id));
		model.addAttribute("detail", new HoaDonChiTiet());
		return "customer/hoadon/detail";
	}
}