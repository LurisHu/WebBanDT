/*
*
* Fresher Academy 2019
* @author Kay
* @date Oct 26, 2019
* @version 1.8
* 
*/
package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webbanhang.dao.DanhMucDAO;
import com.webbanhang.dao.NhaCungCapDAO;
import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.entity.SanPham;
import com.webbanhang.service.UploadService;



@Controller
public class QuanLySanPhamController {
	@Autowired
	SanPhamDAO dao;
	
	@Autowired
	NhaCungCapDAO nccdao;
	
	@Autowired
	DanhMucDAO dmdao;
	
	@Autowired
	UploadService uploadService;
	
	@RequestMapping("admin/sanpham/index")
	public String index(Model model) {
		model.addAttribute("form", new SanPham());
		model.addAttribute("products", dao.findAll());
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}
	
	@RequestMapping("admin/sanpham/edit/{id}")
	public String edit(Model model, @PathVariable("id")Integer id) {
		SanPham entity = dao.findById(id);
		model.addAttribute("form", entity);
		model.addAttribute("products", dao.findAll());
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}
	
	@RequestMapping("admin/sanpham/create")
	public String create(Model model, SanPham entity,@RequestParam("up_photo") MultipartFile file) {
		entity.setHinhAnh(uploadService.uploadImage(file));
		dao.create(entity);
		model.addAttribute("form", entity);
		model.addAttribute("products", dao.findAll());
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "redirect:/admin/sanpham/index";
	}
	
	@RequestMapping("admin/sanpham/update")
	public String update(Model model, SanPham entity) {
		dao.update(entity);
		model.addAttribute("form", entity);
		model.addAttribute("products", dao.findAll());
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}
	
	@RequestMapping("admin/sanpham/delete")
	public String delete(Model model, SanPham entity) {
		dao.delete(entity.getMaSP());
		model.addAttribute("form", entity);
		model.addAttribute("products", dao.findAll());
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}
}
