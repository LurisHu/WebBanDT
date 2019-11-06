package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.HoaDon;

public interface HoaDonDAO {
	HoaDon findById(Integer id);
	List<HoaDon> findAll();
	HoaDon create(HoaDon entity);
	void update(HoaDon entity);
	HoaDon delete(Integer id);
}
