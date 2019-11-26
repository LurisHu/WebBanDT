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

	@GetMapping("admin/danhmuc/create")
	public String create(Model model, @ModelAttribute("dm") DanhMuc dm) {
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}

	@PostMapping("admin/danhmuc/create")
	public String create(Model model, @Validated @ModelAttribute("dm") DanhMuc dm, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				dao.create(dm);
				model.addAttribute("message", "Thêm danh mục thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm danh mục thất bại");
			}
		}
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}

	@GetMapping("admin/danhmuc/update")
	public String update(Model model, @ModelAttribute("dm") DanhMuc dm) {
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}
	
	@PostMapping("admin/danhmuc/update")
	public String update(Model model, @Validated @ModelAttribute("dm") DanhMuc dm, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				dao.update(dm);
				model.addAttribute("message", "Cập nhật danh mục thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật mục thất bại");
			}
		}
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}
	
	@GetMapping("admin/danhmuc/delete")
	public String delete(Model model) {
		model.addAttribute("dm", new DanhMuc());
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}
	
	@PostMapping("/admin/danhmuc/delete")
	public String delete(Model model, @ModelAttribute("dm") DanhMuc dm) {
		if (dm.getMaDM() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 danh mục để xóa ");
		} else {
			try {
				dao.delete(dm.getMaDM());
				model.addAttribute("message", "Xóa danh mục thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa danh mục thất bại");
			}
		}
		model.addAttribute("dms", dao.findAll());
		return "admin/danhmuc/index";
	}

	@GetMapping("admin/danhmuc/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		DanhMuc entity = dao.findById(id);
		model.addAttribute("dms", dao.findAll());
		model.addAttribute("dm", entity);
		return "admin/danhmuc/index";
	}
}
