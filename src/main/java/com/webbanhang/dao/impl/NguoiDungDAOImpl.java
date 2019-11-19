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
public class NguoiDungDAOImpl implements NguoiDungDAO{
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
		TypedQuery<NguoiDung> query = session.createQuery(hql,NguoiDung.class);
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
		NguoiDung entity=this.findById(id);
		Session session = factory.getCurrentSession();
		session.remove(entity);
		return entity;
	}

	@Override
	public NguoiDung findByEmail(String email) {
		 try {
	            String hql = "Select e from " + NguoiDung.class.getName()+ " e " //
	                    + " Where e.email = :email ";
	 
	            Query query = entityManager.createQuery(hql, NguoiDung.class);
	            query.setParameter("email", email);
	 
	            return (NguoiDung) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	}
}
