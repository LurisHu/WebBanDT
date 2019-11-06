package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.DanhGiaDAO;
import com.webbanhang.entity.DanhGia;
@Transactional
@Repository
public class DanhGiaDAOImpl implements DanhGiaDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public DanhGia findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(DanhGia.class, id);
	}

	@Override
	public List<DanhGia> findAll() {
		String hql = "FROM DanhGia";
		Session session = factory.getCurrentSession();
		TypedQuery<DanhGia> query = session.createQuery(hql,DanhGia.class);
		return query.getResultList();
	}

	@Override
	public DanhGia create(DanhGia entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(DanhGia entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public DanhGia delete(Integer id) {
		DanhGia entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
	
	
}
