package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.SanPhamDAO;
import com.webbanhang.entity.SanPham;
@Transactional
@Repository
public class SanPhamDAOImpl implements SanPhamDAO{
	@Autowired
	SessionFactory factory;
	
	@Override
	public SanPham findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(SanPham.class, id);
	}

	@Override
	public List<SanPham> findAll() {
		String hql = "FROM SanPham";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		return query.getResultList();
	}

	@Override
	public SanPham create(SanPham entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(SanPham entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public SanPham delete(Integer id) {
		SanPham entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}
	
	@Override
	public List<SanPham> BestSellerPhone(int PageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(PageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> BestSellerLaptop(int PageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '2'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(PageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> BestSellerPhuKien(int PageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '3'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(PageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> AllPhone(int PageNo) {
		int pageSize = 8;
		String hql = "FROM SanPham WHERE MaDM= '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(PageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
}
