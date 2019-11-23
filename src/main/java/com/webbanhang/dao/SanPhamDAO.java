package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.SanPham;

public interface SanPhamDAO {
	SanPham findById(Integer id);
	List<SanPham> findAll();
	List<SanPham> findPageProduct(int PageNo);
	SanPham create(SanPham entity);
	void update(SanPham entity);
	SanPham delete(Integer id);
	List<SanPham> BestSellerPhone(int PageNo);
	List<SanPham> BestSellerLaptop(int PageNo);
	List<SanPham> BestSellerPhuKien(int PageNo);
	List<SanPham> findPagePhone(int PageNo);
	List<SanPham> findPageLaptop(int PageNo);
	int getPageCountPhone();
	int getPageCountLaptop();
	int getPageCountProducts();
}
