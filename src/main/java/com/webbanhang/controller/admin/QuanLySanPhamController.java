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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		int pageNo = 0;
		model.addAttribute("product", new SanPham());
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@RequestMapping("admin/sanpham/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		int pageNo = 0;
		SanPham product = dao.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@GetMapping("admin/sanpham/create")
	public String create(Model model) {
		int pageNo = 0;
		model.addAttribute("product", new SanPham());
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@PostMapping("admin/sanpham/create")
	public String create(Model model, @RequestParam("up_photo") MultipartFile file,
			@Validated @ModelAttribute("product") SanPham product, BindingResult errors) {
		product.setImage(uploadService.uploadImage(file));
		int pageNo = 0;
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				dao.create(product);
				model.addAttribute("message", "Thêm sản phẩm thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm sản phẩm thất bại");
			}
		}
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@GetMapping("admin/sanpham/update")
	public String update(Model model) {
		int pageNo = 0;
		model.addAttribute("product", new SanPham());
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@PostMapping("admin/sanpham/update")
	public String update(Model model, @RequestParam("up_photo") MultipartFile file,
			@Validated @ModelAttribute("product") SanPham product, BindingResult errors) {
		int pageNo = 0;
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi ");
		} else {
			try {
				if (file.isEmpty() && !(dao.findById(product.getMaSP()).getImage().equals("default.png"))) {
					product.setImage(dao.findById(product.getMaSP()).getImage());
				} else {
					product.setImage(uploadService.uploadImage(file));
				}
				dao.update(product);
				model.addAttribute("message", "Cập nhật sản phẩm thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật sản phẩm thất bại");
			}
		}
		model.addAttribute("product", product);
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@GetMapping("admin/sanpham/delete")
	public String delete(Model model) {
		int pageNo = 0;
		model.addAttribute("product", new SanPham());
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}

	@PostMapping("admin/sanpham/delete")
	public String delete(Model model, @RequestParam("up_photo") MultipartFile file,
			@ModelAttribute("product") SanPham product) {
		product.setImage(uploadService.uploadImage(file));
		int pageNo = 0;
		if (product.getMaSP() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 sản phẩm để xóa ");
		} else {
			try {
				dao.delete(product.getMaSP());
				model.addAttribute("message", "Xóa nhà cung cấp thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa nhà cung cấp thất bại");
			}
		}
		model.addAttribute("product", product);
		model.addAttribute("products", dao.findPageProduct(pageNo));
		model.addAttribute("nccs", nccdao.findAll());
		model.addAttribute("danhmuc", dmdao.findAll());
		return "admin/sanpham/index";
	}
}
