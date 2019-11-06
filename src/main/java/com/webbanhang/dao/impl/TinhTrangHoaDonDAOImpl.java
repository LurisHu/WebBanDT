package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.TinhTrangHoaDonDAO;
import com.webbanhang.entity.TinhTrangHoaDon;
@Transactional
@Repository
public class TinhTrangHoaDonDAOImpl implements TinhTrangHoaDonDAO{
	@Autowired
	SessionFactory factory;

	@Override
	public TinhTrangHoaDon findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(TinhTrangHoaDon.class, id);
	}

	@Override
	public List<TinhTrangHoaDon> findAll() {
		String hql = "FROM TinhTrangHoaDon";
		Session session = factory.getCurrentSession();
		TypedQuery<TinhTrangHoaDon> query = session.createQuery(hql,TinhTrangHoaDon.class);
		return query.getResultList();
	}

	@Override
	public TinhTrangHoaDon create(TinhTrangHoaDon entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(TinhTrangHoaDon entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public TinhTrangHoaDon delete(Integer id) {
		TinhTrangHoaDon entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
}
