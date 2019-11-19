/*
*
* Fresher Academy 2019
* @author Kay
* @date Oct 26, 2019
* @version 1.8
* 
*/
package com.webbanhang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.HoaDonChiTietDAO;
import com.webbanhang.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cart;
	
	@Autowired
	HoaDonChiTietDAO dao;
	
	@RequestMapping("/cart/view")
	public String info() {
		return "customer/cart/index";
	}
	
	@RequestMapping("cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/customer/sanpham/index";
	}
	
	@RequestMapping("cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}
	
	@RequestMapping("cart/update")
	public String update(@RequestParam("id") Integer id,
			@RequestParam("qty") Integer qty) {
		cart.update(id, qty);
		return "redirect:/cart/view";
	}
	
	@RequestMapping("cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}
	
	@RequestMapping("cart/thanhtoan")
	public String thanhtoan() {
		return "customer/cart/bill";
	}
}
