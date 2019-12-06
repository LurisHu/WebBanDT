package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.HoaDon;

public interface HoaDonDAO {
	HoaDon findById(Integer id);
	List<HoaDon> findAll();
	List<HoaDon> SearchHoaDon(Integer id);
	HoaDon create(HoaDon entity);
	void update(HoaDon entity);
	HoaDon delete(Integer id);
	List<HoaDon> findPageHoaDon(int pageNo);
	int getPageCountHoaDon();
	List<HoaDon> findHoaDonCustomer(Integer customerId);
}
