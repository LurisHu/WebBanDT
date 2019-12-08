/*
*
* Fresher Academy 2019
* @author Kay
* @date Dec 7, 2019
* @version 1.8
* 
*/
package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.ReportDAO;

@Controller
public class ReportController {
	@Autowired
	ReportDAO dao;
	
	@RequestMapping("admin/report/inventory-by-category")
	public String inventoryByCategory(Model model) {
		model.addAttribute("data", dao.inventoryByCategory());
		return "admin/report/inventory-by-category";
	}
	
	@RequestMapping("admin/report/revenue-by-category")
	public String revenueByCategory(Model model) {
		model.addAttribute("data", dao.revenueByCategory());
		return "admin/report/revenue-by-category";
	}
	
	@RequestMapping("admin/report/revenue-by-customer")
	public String revenueByCustomer(Model model) {
		model.addAttribute("data", dao.revenueByCustomer());
		return "admin/report/revenue-by-customer";
	}
	
	@RequestMapping("admin/report/revenue-by-month")
	public String revenueByMonthCustomer(Model model) {
		model.addAttribute("data", dao.revenueByMonth());
		return "admin/report/revenue-by-month";
	}
	
	@RequestMapping("admin/report/quantity-by-ncc")
	public String quantityByNCC(Model model) {
		model.addAttribute("data", dao.quantityByNCC());
		return "admin/report/quantity-by-ncc";
	}
}
