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
	public List<SanPham> BestSellerPhone(int pageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> BestSellerLaptop(int pageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '2'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> BestSellerPhuKien(int pageNo) {
		int pageSize = 3;
		String hql = "FROM SanPham WHERE MaDM= '3'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<SanPham> findPagePhone(int pageNo) {
		int pageSize = 8;
		String hql = "FROM SanPham WHERE MaDM= '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	@Override
	public List<SanPham> findPageLaptop(int pageNo) {
		int pageSize = 6;
		String hql = "FROM SanPham WHERE MaDM= '2'";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	@Override
	public int getPageCountPhone() {
		int pageSize = 8;
		String hql = "SELECT count(p) FROM SanPham p WHERE MaDM= '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql,Long.class);
		long count = query.getSingleResult();
		int pageCount = (int) Math.ceil(1.0*count/pageSize);
		return pageCount;
	}

	@Override
	public int getPageCountLaptop() {
		int pageSize = 6;
		String hql = "SELECT count(p) FROM SanPham p WHERE MaDM= '2'";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql,Long.class);
		long count = query.getSingleResult();
		int pageCount = (int) Math.ceil(1.0*count/pageSize);
		return pageCount;
	}

	@Override
	public List<SanPham> findPageProduct(int pageNo) {
		int pageSize = 10;
		String hql = "FROM SanPham ORDER BY MaDM";
		Session session = factory.getCurrentSession();
		TypedQuery<SanPham> query = session.createQuery(hql,SanPham.class);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	@Override
	public int getPageCountProducts() {
		int pageSize = 10;
		String hql = "SELECT count(p) FROM SanPham p";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql,Long.class);
		long count = query.getSingleResult();
		int pageCount = (int) Math.ceil(1.0*count/pageSize);
		return pageCount;
	}
}
