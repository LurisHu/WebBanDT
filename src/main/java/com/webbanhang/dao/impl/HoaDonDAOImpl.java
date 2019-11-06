package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.HoaDonDAO;
import com.webbanhang.entity.HoaDon;
@Transactional
@Repository
public class HoaDonDAOImpl implements HoaDonDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public HoaDon findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(HoaDon.class, id);
	}

	@Override
	public List<HoaDon> findAll() {
		String hql = "FROM HoaDon";
		Session session = factory.getCurrentSession();
		TypedQuery<HoaDon> query = session.createQuery(hql,HoaDon.class);
		return query.getResultList();
	}

	@Override
	public HoaDon create(HoaDon entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(HoaDon entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public HoaDon delete(Integer id) {
		HoaDon entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
}
