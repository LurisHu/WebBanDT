package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.HoaDonChiTietDAO;
import com.webbanhang.entity.HoaDonChiTiet;
@Transactional
@Repository
public class HoaDonChiTietDAOImpl implements HoaDonChiTietDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public HoaDonChiTiet findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(HoaDonChiTiet.class, id);
	}

	@Override
	public List<HoaDonChiTiet> findAll() {
		String hql = "FROM HoaDonChiTiet";
		Session session = factory.getCurrentSession();
		TypedQuery<HoaDonChiTiet> query = session.createQuery(hql,HoaDonChiTiet.class);
		return query.getResultList();
	}

	@Override
	public HoaDonChiTiet create(HoaDonChiTiet entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(HoaDonChiTiet entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public HoaDonChiTiet delete(Integer id) {
		HoaDonChiTiet entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
}
