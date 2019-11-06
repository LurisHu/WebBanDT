package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.SanPham;

public interface SanPhamDAO {
	SanPham findById(Integer id);
	List<SanPham> findAll();
	SanPham create(SanPham entity);
	void update(SanPham entity);
	SanPham delete(Integer id);
}
