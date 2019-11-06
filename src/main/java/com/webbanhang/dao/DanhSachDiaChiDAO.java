package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.DanhSachDiaChi;

public interface DanhSachDiaChiDAO {
	DanhSachDiaChi findById(Integer id);
	List<DanhSachDiaChi> findAll();
	DanhSachDiaChi create(DanhSachDiaChi entity);
	void update(DanhSachDiaChi entity);
	DanhSachDiaChi delete(Integer id);
}
