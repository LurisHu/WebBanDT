/*
*
* Fresher Academy 2019
* @author Kay
* @date Oct 26, 2019
* @version 1.8
* 
*/
package com.webbanhang.controller.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.HoaDonChiTietDAO;
import com.webbanhang.dao.HoaDonDAO;
import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.dao.TinhTrangHoaDonDAO;
import com.webbanhang.entity.HoaDon;
import com.webbanhang.entity.HoaDonChiTiet;
import com.webbanhang.entity.SanPham;
import com.webbanhang.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cart;
	@Autowired
	HoaDonDAO hdDao;
	@Autowired
	HoaDonChiTietDAO dao;
	@Autowired
	NguoiDungDAO ndDao;
	@Autowired
	TinhTrangHoaDonDAO ttDao;
	@Autowired
	SanPhamDAO spDao;

	@RequestMapping("/cart/view")
	public String info() {
		return "customer/cart/index";
	}

	@RequestMapping("cart/buynow/{id}")
	public String buynow(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/cart/view";
	}
	
	@RequestMapping("cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/customer/sanpham/index";
	}

	@RequestMapping("addQty/{id}")
	public String addQty(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("removeQty/{id}")
	public String removeQty(@PathVariable("id") Integer id) {
		cart.removeQty(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("cart/update")
	public String update(@RequestParam("id") Integer id, @RequestParam("qty") Integer qty) {
		cart.update(id, qty);
		return "redirect:/cart/view";
	}

	@RequestMapping("cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/thanhtoan")
	public String thanhtoan(@RequestParam("hoTen") String hoTen, @RequestParam("SDT") String SDT,
			@RequestParam("tinhThanh") String tinhThanh, @RequestParam("quanHuyen") String quanHuyen,
			@RequestParam("phuongXa") String phuongXa, @RequestParam("diaChi") String diaChi,
			@RequestParam("comment") String comment,
			@CookieValue(value = "userId", defaultValue = "not") Integer userId) {
		// Tạo hóa đơn
		Double thanhTien = cart.getAmount();
		HoaDon hd = new HoaDon();
		hd.setNguoiDungHD(ndDao.findById(userId));
		hd.setNgayDat(new Date());
		hd.setTongTien(thanhTien);
		hd.setDiaChiGiao(diaChi + " Phường " + phuongXa + " Quận/Huyện " + quanHuyen + " Tỉnh " + tinhThanh);
		hd.setPhiVanChuyen(20000.0);
		hd.setComment(comment);
		hd.setTinhTrangHD(ttDao.findById(2));
		hdDao.create(hd);
		// Bổ sung các hóa đơn chi tiết
		// Lấy thông tin sản phẩm có trong cart
		List<SanPham> listSP = cart.getItems();
		// Tạo list các HDCT
		List<HoaDonChiTiet> listHDCT = new ArrayList<HoaDonChiTiet>();
		// Dùng vòng for để tạo các hdct
		for (int i = 0; i < listSP.size(); i++) {
			SanPham sp = listSP.get(i);
			HoaDonChiTiet temp = new HoaDonChiTiet();
			temp.setGiaSP(sp.getGiaSP());
			temp.setSoLuong(1);
			temp.setGiamGia(sp.getGiamGia());
			temp.setHoaDonHDCT(hdDao.findById(hd.getMaHD()));
			temp.setSanPhamHDCT(sp);
			listHDCT.add(temp);
		}
		// Dùng vòng for để insert các HDCT đã tạo vào database
		for (int i = 0; i < listHDCT.size(); i++) {
			dao.create(listHDCT.get(i));
		}
		return "customer/cart/bill";
	}
}
