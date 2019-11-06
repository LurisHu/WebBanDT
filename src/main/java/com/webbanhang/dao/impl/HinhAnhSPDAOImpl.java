package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.HinhAnhSPDAO;
import com.webbanhang.entity.HinhAnhSP;
@Transactional
@Repository
public class HinhAnhSPDAOImpl implements HinhAnhSPDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public HinhAnhSP findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(HinhAnhSP.class, id);
	}

	@Override
	public List<HinhAnhSP> findAll() {
		String hql = "FROM HinhAnhSP";
		Session session = factory.getCurrentSession();
		TypedQuery<HinhAnhSP> query = session.createQuery(hql,HinhAnhSP.class);
		return query.getResultList();
	}

	@Override
	public HinhAnhSP create(HinhAnhSP entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(HinhAnhSP entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public HinhAnhSP delete(Integer id) {
		HinhAnhSP entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}

}
