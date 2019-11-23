package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webbanhang.dao.NhaCungCapDAO;

@Controller
public class AdminController {
	@Autowired
	NhaCungCapDAO dao;

	@RequestMapping("admin/dashboard/index")
	public String index() {
		return "admin/dashboard/index";
	}

}
