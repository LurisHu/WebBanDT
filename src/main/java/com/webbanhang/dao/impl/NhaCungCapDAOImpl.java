package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.NhaCungCapDAO;
import com.webbanhang.entity.NhaCungCap;
@Transactional
@Repository
public class NhaCungCapDAOImpl implements NhaCungCapDAO{
	@Autowired
	SessionFactory factory;
	
	@Override
	public NhaCungCap findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(NhaCungCap.class, id);
	}

	@Override
	public List<NhaCungCap> findAll() {
		String hql = "FROM NhaCungCap";
		Session session = factory.getCurrentSession();
		TypedQuery<NhaCungCap> query = session.createQuery(hql,NhaCungCap.class);
		return query.getResultList();
	}

	@Override
	public NhaCungCap create(NhaCungCap entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(NhaCungCap entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public NhaCungCap delete(Integer id) {
		NhaCungCap entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
}
