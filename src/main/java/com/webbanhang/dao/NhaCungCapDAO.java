package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.NhaCungCap;

public interface NhaCungCapDAO {
	NhaCungCap findById(Integer id);
	List<NhaCungCap> findAll();
	NhaCungCap create(NhaCungCap entity);
	void update(NhaCungCap entity);
	NhaCungCap delete(Integer id);
}
