package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.NguoiDung;

public interface NguoiDungDAO {
	NguoiDung findById(Integer id);
	List<NguoiDung> findAll();
	List<NguoiDung> findPageAdmin(int pageNo);
	List<NguoiDung> findPageCustomer(int pageNo);
	List<NguoiDung> searchAdmin(String email);
	List<NguoiDung> searchCustomer(String email);
	NguoiDung create(NguoiDung entity);
	void update(NguoiDung entity);
	NguoiDung delete(Integer id);
	NguoiDung findByEmail(String email);
	int getPageCountAdmin();
	int getPageCountCustomer();
}
