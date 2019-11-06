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

	@RequestMapping("admin/nguoidung/index")
	public String index(Model model) {
		model.addAttribute("nds", dao.findAll());
		model.addAttribute("nd", new NguoiDung());
		return "admin/nguoidung/index";
	}

	@RequestMapping("admin/nguoidung/create")
	public String create(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.create(nd);
		model.addAttribute("nds", dao.findAll());
		return "redirect:/admin/nguoidung/index";
	}

	@RequestMapping("admin/nguoidung/update")
	public String update(Model model, @ModelAttribute("nd") NguoiDung nd) {
		dao.update(nd);
		model.addAttribute("nccs", dao.findAll());
		return "redirect:/admin/nguoidung/edit/"+nd.getMaNguoiDung();
	}

	@RequestMapping("/admin/nguoidung/delete")
	public String delete(Model model, @ModelAttribute("nd") NguoiDung entity) {
		dao.delete(entity.getMaNguoiDung());
		model.addAttribute("nds", dao.findAll());
		return "redirect:/admin/nguoidung/index";
	}

	@GetMapping("admin/nguoidung/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		NguoiDung entity = dao.findById(id);
		model.addAttribute("nds", dao.findAll());
		model.addAttribute("nd", entity);
		return "admin/nguoidung/index";
	}
}
