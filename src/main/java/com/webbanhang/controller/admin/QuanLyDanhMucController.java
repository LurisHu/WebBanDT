package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.DanhMucDAO;
import com.webbanhang.entity.DanhMuc;

@Controller
public class QuanLyDanhMucController {
	@Autowired
	DanhMucDAO dao;

	@RequestMapping("admin/danhmuc/index")
	public String index(Model model) {
		model.addAttribute("dms", dao.findAll());
		model.addAttribute("dm", new DanhMuc());
		return "admin/danhmuc/index";
	}

	@RequestMapping("admin/danhmuc/create")
	public String create(Model model, @ModelAttribute("dm") DanhMuc dm) {
		dao.create(dm);
		model.addAttribute("dms", dao.findAll());
		return "redirect:/admin/danhmuc/index";
	}

	@RequestMapping("admin/danhmuc/update")
	public String update(Model model, @ModelAttribute("dm") DanhMuc dm) {
		dao.update(dm);
		model.addAttribute("dms", dao.findAll());
		return "redirect:/admin/danhmuc/edit/"+dm.getMaDM();
	}

	@RequestMapping("/admin/danhmuc/delete")
	public String delete(Model model, @ModelAttribute("dm") DanhMuc entity) {
		dao.delete(entity.getMaDM());
		model.addAttribute("dms", dao.findAll());
		return "redirect:/admin/danhmuc/index";
	}

	@GetMapping("admin/danhmuc/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		DanhMuc entity = dao.findById(id);
		model.addAttribute("dms", dao.findAll());
		model.addAttribute("dm", entity);
		return "admin/danhmuc/index";
	}
}
