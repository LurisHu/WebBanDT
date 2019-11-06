package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.TinhTrangHoaDon;

public interface TinhTrangHoaDonDAO {
	TinhTrangHoaDon findById(Integer id);
	List<TinhTrangHoaDon> findAll();
	TinhTrangHoaDon create(TinhTrangHoaDon entity);
	void update(TinhTrangHoaDon entity);
	TinhTrangHoaDon delete(Integer id);
}
