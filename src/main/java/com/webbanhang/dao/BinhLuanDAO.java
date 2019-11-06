package com.webbanhang.dao;

import java.util.List;

import com.webbanhang.entity.BinhLuan;

public interface BinhLuanDAO {
	BinhLuan findById(Integer id);
	List<BinhLuan> findAll();
	BinhLuan create(BinhLuan entity);
	void update(BinhLuan entity);
	BinhLuan delete(Integer id);
}
