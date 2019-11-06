package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.DanhSachDiaChiDAO;
import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.DanhSachDiaChi;

@Controller
public class QuanLyDiaChiController {
	@Autowired
	DanhSachDiaChiDAO dao;
	@Autowired
	NguoiDungDAO daoUser;

	@RequestMapping("admin/diachi/index")
	public String index(Model model) {
		model.addAttribute("dcs", dao.findAll());
		model.addAttribute("dc", new DanhSachDiaChi());
		return "admin/diachi/index";
	}

	@RequestMapping("admin/diachi/create")
	public String create(Model model, @ModelAttribute("dc") DanhSachDiaChi dc,
			@RequestParam("city")String city,
			@RequestParam("district")String district,
			@RequestParam("ward")String ward) {
		city=city.substring(city.indexOf("-")+1, city.length());
		district=district.substring(district.indexOf("-")+1, district.length());
		ward=ward.substring(ward.indexOf("-")+1, ward.length());
		dc.setTenTinh(city);
		dc.setQuanHuyen(district);
		dc.setPhuongXa(ward);
		dc.setNguoiDungDC(daoUser.findById(75600));
		dao.create(dc);
		model.addAttribute("dcs", dao.findAll());
		return "redirect:/admin/diachi/index";
	}

	@RequestMapping("admin/diachi/update")
	public String update(Model model, @ModelAttribute("dc") DanhSachDiaChi dc,
			@RequestParam("city")String city,
			@RequestParam("district")String district,
			@RequestParam("ward")String ward) {
		city=city.substring(city.indexOf("-")+1, city.length());
		district=district.substring(district.indexOf("-")+1, district.length());
		ward=ward.substring(ward.indexOf("-")+1, ward.length());
		dc.setTenTinh(city);
		dc.setQuanHuyen(district);
		dc.setPhuongXa(ward);
		dc.setNguoiDungDC(daoUser.findById(75600));
		dao.update(dc);
		model.addAttribute("dcs", dao.findAll());
		return "redirect:/admin/diachi/edit/"+dc.getMaDiaChi();
	}

	@RequestMapping("/admin/diachi/delete")
	public String delete(Model model, @ModelAttribute("dc") DanhSachDiaChi entity) {
		dao.delete(entity.getMaDiaChi());
		model.addAttribute("dcs", dao.findAll());
		return "redirect:/admin/diachi/index";
	}

	@GetMapping("admin/diachi/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		DanhSachDiaChi entity = dao.findById(id);
		model.addAttribute("dcs", dao.findAll());
		model.addAttribute("dc", entity);
		return "admin/diachi/index";
	}
}
