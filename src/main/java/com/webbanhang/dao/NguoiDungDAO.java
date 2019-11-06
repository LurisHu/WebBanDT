package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.NguoiDung;

public interface NguoiDungDAO {
	NguoiDung findById(Integer id);
	List<NguoiDung> findAll();
	NguoiDung create(NguoiDung entity);
	void update(NguoiDung entity);
	NguoiDung delete(Integer id);
}
