package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.DanhMuc;

public interface DanhMucDAO {
	DanhMuc findById(Integer id);
	List<DanhMuc> findAll();
	DanhMuc create(DanhMuc entity);
	void update(DanhMuc entity);
	DanhMuc delete(Integer id);
}
