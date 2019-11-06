package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.DanhMucDAO;
import com.webbanhang.entity.DanhMuc;
@Transactional
@Repository
public class DanhMucDAOImpl implements DanhMucDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public DanhMuc findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(DanhMuc.class, id);
	}

	@Override
	public List<DanhMuc> findAll() {
		String hql = "FROM DanhMuc";
		Session session = factory.getCurrentSession();
		TypedQuery<DanhMuc> query = session.createQuery(hql,DanhMuc.class);
		return query.getResultList();
	}

	@Override
	public DanhMuc create(DanhMuc entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(DanhMuc entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public DanhMuc delete(Integer id) {
		DanhMuc entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
	
	
}
