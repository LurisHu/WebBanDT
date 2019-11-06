package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.NhaCungCapDAO;
import com.webbanhang.entity.NhaCungCap;

@Controller
public class NhaCungCapController {
	@Autowired
	NhaCungCapDAO dao;

	@RequestMapping("admin/nhacungcap/index")
	public String index(Model model) {
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", new NhaCungCap());
		return "admin/nhacungcap/index";
	}

	@RequestMapping("admin/nhacungcap/create")
	public String create(Model model, @ModelAttribute("ncc") NhaCungCap ncc) {
		dao.create(ncc);
		model.addAttribute("nccs", dao.findAll());
		return "redirect:/admin/nhacungcap/index";
	}

	@RequestMapping("admin/nhacungcap/update")
	public String update(Model model, @ModelAttribute("ncc") NhaCungCap ncc) {
		dao.update(ncc);
		model.addAttribute("nccs", dao.findAll());
		return "redirect:/admin/nhacungcap/index";
	}

	@RequestMapping("/admin/nhacungcap/delete")
	public String delete(Model model, @ModelAttribute("ncc") NhaCungCap entity) {
		dao.delete(entity.getMaNCC());
		model.addAttribute("nccs", dao.findAll());
		return "redirect:/admin/nhacungcap/index";
	}

	@GetMapping("admin/nhacungcap/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		NhaCungCap entity = dao.findById(id);
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", entity);
		return "admin/nhacungcap/index";
	}
}
