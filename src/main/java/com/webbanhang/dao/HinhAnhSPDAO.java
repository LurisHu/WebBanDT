package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.HinhAnhSP;

public interface HinhAnhSPDAO {
	HinhAnhSP findById(Integer id);
	List<HinhAnhSP> findAll();
	HinhAnhSP create(HinhAnhSP entity);
	void update(HinhAnhSP entity);
	HinhAnhSP delete(Integer id);
}
