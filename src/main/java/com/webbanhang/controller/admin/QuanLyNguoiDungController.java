package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.NguoiDung;

@Controller
public class QuanLyNguoiDungController {
	@Autowired
	NguoiDungDAO dao;

	@RequestMapping("admin/nguoidung/admin/index")
	public String index(Model model) {
		model.addAttribute("nds", dao.findAllAdmin());
		model.addAttribute("nd", new NguoiDung());
		return "admin/nguoidung/admin/index";
	}

	@RequestMapping("admin/nguoidung/admin/create")
	public String create(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.create(nd);
		model.addAttribute("nds", dao.findAllAdmin());
		return "redirect:/admin/nguoidung/admin/index";
	}

	@RequestMapping("admin/nguoidung/admin/update")
	public String update(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.update(nd);
		model.addAttribute("nccs", dao.findAllAdmin());
		return "redirect:/admin/nguoidung/admin/edit/"+nd.getMaNguoiDung();
	}

	@RequestMapping("/admin/nguoidung/admin/delete")
	public String delete(Model model, @ModelAttribute("nd") NguoiDung entity) {
		dao.delete(entity.getMaNguoiDung());
		model.addAttribute("nds", dao.findAllAdmin());
		return "redirect:/admin/nguoidung/admin/index";
	}

	@GetMapping("admin/nguoidung/admin/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		NguoiDung entity = dao.findById(id);
		model.addAttribute("nds", dao.findAllAdmin());
		model.addAttribute("nd", entity);
		return "admin/nguoidung/admin/index";
	}
	
	@RequestMapping("admin/nguoidung/customer/index")
	public String indexCustomer(Model model) {
		model.addAttribute("nds", dao.findAllCustomer());
		model.addAttribute("nd", new NguoiDung());
		return "admin/nguoidung/customer/index";
	}

	@RequestMapping("admin/nguoidung/customer/create")
	public String createCustomer(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.create(nd);
		model.addAttribute("nds", dao.findAllCustomer());
		return "redirect:/admin/nguoidung/customer/index";
	}

	@RequestMapping("admin/nguoidung/customer/update")
	public String updateCustomer(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.update(nd);
		model.addAttribute("nccs", dao.findAllCustomer());
		return "redirect:/admin/nguoidung/customer/edit/"+nd.getMaNguoiDung();
	}

	@RequestMapping("/admin/nguoidung/customer/delete")
	public String deleteCustomer(Model model, @ModelAttribute("nd") NguoiDung entity) {
		dao.delete(entity.getMaNguoiDung());
		model.addAttribute("nds", dao.findAllCustomer());
		return "redirect:/admin/nguoidung/customer/index";
	}

	@GetMapping("admin/nguoidung/customer/edit/{id}")
	public String editCustomer(Model model, @PathVariable("id") Integer id) {
		NguoiDung entity = dao.findById(id);
		model.addAttribute("nds", dao.findAllCustomer());
		model.addAttribute("nd", entity);
		return "admin/nguoidung/customer/index";
	}
}
