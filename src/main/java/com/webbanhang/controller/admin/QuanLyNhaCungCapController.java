package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.NhaCungCapDAO;
import com.webbanhang.entity.NhaCungCap;

@Controller
public class QuanLyNhaCungCapController {
	@Autowired
	NhaCungCapDAO dao;

	@RequestMapping("admin/nhacungcap/index")
	public String index(Model model) {
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", new NhaCungCap());
		return "admin/nhacungcap/index";
	}

	/*
	 * @RequestMapping("admin/nhacungcap/edit") public String edit(Model model) {
	 * model.addAttribute("nccs", dao.findAll()); model.addAttribute("ncc", new
	 * NhaCungCap()); return "admin/nhacungcap/edit"; }
	 */

	@GetMapping("admin/nhacungcap/create")
	public String create(Model model) {
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", new NhaCungCap());
		return "admin/nhacungcap/index";
	}

	@PostMapping("admin/nhacungcap/create")
	public String create(Model model, @Validated @ModelAttribute("ncc") NhaCungCap ncc, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				dao.create(ncc);
				model.addAttribute("message", "Tạo nhà cung cấp thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Tạo nhà cung cấp thất bại");
			}
		}
		model.addAttribute("nccs", dao.findAll());
		return "admin/nhacungcap/index";
	}

	@GetMapping("admin/nhacungcap/update")
	public String edit2(Model model) {
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", new NhaCungCap());
		return "admin/nhacungcap/index";
	}

	@PostMapping("admin/nhacungcap/update")
	public String update(Model model, @Validated @ModelAttribute("ncc") NhaCungCap ncc, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				dao.update(ncc);
				model.addAttribute("message", "Cập nhật nhà cung cấp thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật nhà cung cấp thất bại");
			}
		}
		model.addAttribute("nccs", dao.findAll());
		return "admin/nhacungcap/index";
	}

	@GetMapping("admin/nhacungcap/delete")
	public String delete(Model model) {
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", new NhaCungCap());
		return "admin/nhacungcap/index";
	}

	@PostMapping("/admin/nhacungcap/delete")
	public String delete(Model model, @ModelAttribute("ncc") NhaCungCap entity) {
		if (entity.getMaNCC() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 nhà cung cấp để xóa ");
		} else {
			try {
				dao.delete(entity.getMaNCC());
				model.addAttribute("message", "Xóa nhà cung cấp thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa nhà cung cấp thất bại");
			}
		}
		model.addAttribute("nccs", dao.findAll());
		return "admin/nhacungcap/index";
	}

	@GetMapping("admin/nhacungcap/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		NhaCungCap entity = dao.findById(id);
		model.addAttribute("nccs", dao.findAll());
		model.addAttribute("ncc", entity);
		return "admin/nhacungcap/index";
	}
}
