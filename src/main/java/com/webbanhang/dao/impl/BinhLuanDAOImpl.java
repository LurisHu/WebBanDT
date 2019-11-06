package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.BinhLuanDAO;
import com.webbanhang.entity.BinhLuan;
@Transactional
@Repository
public class BinhLuanDAOImpl implements BinhLuanDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public BinhLuan findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(BinhLuan.class, id);
	}

	@Override
	public List<BinhLuan> findAll() {
		String hql = "FROM BinhLuan";
		Session session = factory.getCurrentSession();
		TypedQuery<BinhLuan> query = session.createQuery(hql,BinhLuan.class);
		return query.getResultList();
	}

	@Override
	public BinhLuan create(BinhLuan entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(BinhLuan entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public BinhLuan delete(Integer id) {
		BinhLuan entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
	
	
}
