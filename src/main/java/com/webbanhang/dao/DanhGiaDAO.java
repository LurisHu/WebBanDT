package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.DanhGia;

public interface DanhGiaDAO {
	DanhGia findById(Integer id);

	List<DanhGia> findAll();

	DanhGia create(DanhGia entity);

	void update(DanhGia entity);

	DanhGia delete(Integer id);
}
