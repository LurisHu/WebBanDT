package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.NguoiDung;

@Transactional
@Repository
public class NguoiDungDAOImpl implements NguoiDungDAO {
	@Autowired
	SessionFactory factory;

	@Autowired
	private EntityManager entityManager;

	@Override
	public NguoiDung findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.find(NguoiDung.class, id);
	}

	@Override
	public List<NguoiDung> findAll() {
		String hql = "FROM NguoiDung";
		Session session = factory.getCurrentSession();
		TypedQuery<NguoiDung> query = session.createQuery(hql, NguoiDung.class);
		return query.getResultList();
	}

	@Override
	public List<NguoiDung> findPageAdmin(int pageNo) {
		int pageSize = 10;
		String hql = "FROM NguoiDung WHERE isAdmin = '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<NguoiDung> query = session.createQuery(hql, NguoiDung.class);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<NguoiDung> findPageCustomer(int pageNo) {
		int pageSize = 10;
		String hql = "FROM NguoiDung WHERE isAdmin = '0'";
		Session session = factory.getCurrentSession();
		TypedQuery<NguoiDung> query = session.createQuery(hql, NguoiDung.class);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public NguoiDung create(NguoiDung entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(NguoiDung entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public NguoiDung delete(Integer id) {
		NguoiDung entity = this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}

	@Override
	public NguoiDung findByEmail(String email) {
		try {
			String hql = "Select e from " + NguoiDung.class.getName() + " e " //
					+ " Where e.email = :email and e.isActive = true ";

			Query query = entityManager.createQuery(hql, NguoiDung.class);
			query.setParameter("email", email);

			return (NguoiDung) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public int getPageCountAdmin() {
		int pageSize = 10;
		String hql = "SELECT count(h) FROM NguoiDung h WHERE isAdmin = '1'";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql,Long.class);
		long count = query.getSingleResult();
		int pageCount = (int) Math.ceil(1.0*count/pageSize);
		return pageCount;
	}

	@Override
	public int getPageCountCustomer() {
		int pageSize = 10;
		String hql = "SELECT count(h) FROM NguoiDung h WHERE isAdmin = '0'";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(hql,Long.class);
		long count = query.getSingleResult();
		int pageCount = (int) Math.ceil(1.0*count/pageSize);
		return pageCount;
	}

	@Override
	public List<NguoiDung> searchAdmin(String email) {
		try {
			int pageSize = 10;
			String hql = "Select e from " + NguoiDung.class.getName() + " e " //
					+ " Where e.email like :email and isAdmin = '1'";
			Session session = factory.getCurrentSession();
			TypedQuery<NguoiDung> query = session.createQuery(hql, NguoiDung.class);
			query.setParameter("email", "%"+email+"%");
			query.setMaxResults(pageSize);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<NguoiDung> searchCustomer(String email) {
		try {
			int pageSize = 10;
			String hql = "Select e from " + NguoiDung.class.getName() + " e " //
					+ " Where e.email like :email and isAdmin = '0'";
			Session session = factory.getCurrentSession();
			TypedQuery<NguoiDung> query = session.createQuery(hql, NguoiDung.class);
			query.setParameter("email", "%"+email+"%");
			query.setMaxResults(pageSize);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
