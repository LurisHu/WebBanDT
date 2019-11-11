package com.webbanhang.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.entity.SanPham;

@SessionScope
@Service
public class CartService {
	@Autowired
	SanPhamDAO dao;
	List<SanPham> items = new ArrayList<>();

	public void add(Integer id) {
		for (SanPham item : items) {
			if (item.getMaSP() == id) {
				item.setSoLuong(item.getSoLuong() + 1);
				return;
			}
		}
		SanPham p = dao.findById(id);
		p.setSoLuong(1);
		items.add(p);
	}

	public void remove(Integer id) {
		for (SanPham item : items) {
			if (item.getMaSP() == id) {
				items.remove(item);
				return;
			}
		}
	}

	public void clear() {
		items.clear();
	}

	public void update(Integer id, int qty) {
		for (SanPham item : items) {
			if (item.getMaSP() == id) {
				item.setSoLuong(qty);
				return;
			}
		}
	}

	public List<SanPham> getItems() {
		return items;
	}

	public int getCount() {
		int count = 0;
		for (SanPham item : items) {
			count += item.getSoLuong();
		}
		return count;
	}

	public double getAmount() {
		double amount = 0;
		for (SanPham item : items) {
			amount += (item.getSoLuong() * item.getGiaSP())-(item.getSoLuong() * item.getGiamGia()) ;
		}
		return amount;
	}
}