package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.DanhSachDiaChiDAO;
import com.webbanhang.entity.DanhSachDiaChi;
@Transactional
@Repository
public class DanhSachDiaChiDAOImpl implements DanhSachDiaChiDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public DanhSachDiaChi findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(DanhSachDiaChi.class, id);
	}

	@Override
	public List<DanhSachDiaChi> findAll() {
		String hql = "FROM DanhSachDiaChi";
		Session session = factory.getCurrentSession();
		TypedQuery<DanhSachDiaChi> query = session.createQuery(hql,DanhSachDiaChi.class);
		return query.getResultList();
	}

	@Override
	public DanhSachDiaChi create(DanhSachDiaChi entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(DanhSachDiaChi entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public DanhSachDiaChi delete(Integer id) {
		DanhSachDiaChi entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
	
	
}
