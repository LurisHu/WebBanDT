package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.NguoiDung;

public interface NguoiDungDAO {
	NguoiDung findById(Integer id);
	List<NguoiDung> findAll();
	List<NguoiDung> findAllAdmin();
	List<NguoiDung> findAllCustomer();
	NguoiDung create(NguoiDung entity);
	void update(NguoiDung entity);
	NguoiDung delete(Integer id);
	NguoiDung findByEmail(String email);
}
