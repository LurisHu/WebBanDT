package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.HoaDonChiTiet;

public interface HoaDonChiTietDAO {
	HoaDonChiTiet findById(Integer id);
	List<HoaDonChiTiet> findAll();
	HoaDonChiTiet create(HoaDonChiTiet entity);
	void update(HoaDonChiTiet entity);
	HoaDonChiTiet delete(Integer id);
}
