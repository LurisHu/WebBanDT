package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.ReportDAO;

@Controller
public class AdminController {
	@Autowired
	ReportDAO dao;

	@RequestMapping("admin/dashboard/index")
	public String index(Model model) {
		model.addAttribute("inventory", dao.inventoryByCategory());
		model.addAttribute("revenue", dao.revenueByMonth());
		model.addAttribute("revenueMonthNow", dao.revenueByMonthNow());
		model.addAttribute("revenueYearNow", dao.revenueByYearNow());
		return "admin/dashboard/index";
	}
}
