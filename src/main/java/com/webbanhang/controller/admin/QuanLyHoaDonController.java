package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.HoaDonDAO;
import com.webbanhang.dao.TinhTrangHoaDonDAO;
import com.webbanhang.entity.HoaDon;

@Controller
public class QuanLyHoaDonController {
	@Autowired
	HoaDonDAO dao;

	@Autowired
	TinhTrangHoaDonDAO ttdao;

	@Autowired
	TinhTrangHoaDonDAO khdao;

	@RequestMapping("admin/hoadon/index")
	public String index(Model model) {
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		model.addAttribute("khachHang", khdao.findAll());
		model.addAttribute("hoadon", new HoaDon());
		return "admin/hoadon/index";
	}

	@GetMapping("admin/hoadon/update")
	public String update(Model model) {
		model.addAttribute("hoadon", new HoaDon());
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		return "admin/hoadon/index";
	}

	@PostMapping("admin/hoadon/update")
	public String update(Model model, @ModelAttribute("hoadon") HoaDon hoadon) {
		if (hoadon.getMaHD() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 hóa đơn ");
		} else {
			try {
				dao.update(hoadon);
				model.addAttribute("message", "Cập nhật hóa đơn thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật hóa đơn thất bại");
			}
		}
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		return "admin/hoadon/index";
	}

	@GetMapping("admin/hoadon/delete")
	public String delete(Model model) {
		model.addAttribute("hoadon", new HoaDon());
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		return "admin/hoadon/index";
	}

	@RequestMapping("/admin/hoadon/delete")
	public String delete(Model model, @ModelAttribute("hoadon") HoaDon hoadon) {
		if (hoadon.getMaHD() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 hóa đơn ");
		} else {
			try {
				dao.delete(hoadon.getMaHD());
				model.addAttribute("message", "Xóa hóa đơn thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa nhật hóa đơn thất bại");
			}
		}
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		return "admin/hoadon/index";
	}

	@GetMapping("admin/hoadon/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		HoaDon entity = dao.findById(id);
		model.addAttribute("hoadons", dao.findAll());
		model.addAttribute("trangThai", ttdao.findAll());
		model.addAttribute("hoadon", entity);
		return "admin/hoadon/index";
	}
}
