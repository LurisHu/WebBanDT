/*
*
* Fresher Academy 2019
* @author Kay
* @date Dec 7, 2019
* @version 1.8
* 
*/
package com.webbanhang.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.dao.ReportDAO;

@Transactional
@Repository
public class ReportDAOImpl implements ReportDAO {
	@Autowired
	SessionFactory factory;

	@Override
	public List<Object[]> inventoryByCategory() {
		String hql = "SELECT p.danhMuc.tenDM, " + "SUM(p.soLuong), " + "SUM(p.soLuong*p.giaSP) " + "FROM SanPham p "
				+ "GROUP BY p.danhMuc.tenDM ";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByCategory() {
		String hql = "SELECT d.sanPhamHDCT.danhMuc.tenDM, " + "SUM(d.soLuong), " + "SUM(d.soLuong*d.giaSP) "
				+ "FROM HoaDonChiTiet d " + "GROUP BY d.sanPhamHDCT.danhMuc.tenDM ";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByCustomer() {
		String hql = "SELECT d.hoaDonHDCT.nguoiDungHD.maNguoiDung, " + "SUM(d.soLuong), " + "SUM(d.soLuong*d.giaSP) "
				+ "FROM HoaDonChiTiet d " + "GROUP BY d.hoaDonHDCT.nguoiDungHD.maNguoiDung "
				+ "ORDER BY SUM(d.soLuong*d.giaSP) DESC";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByMonth() {
		String hql = "SELECT MONTH(d.hoaDonHDCT.ngayDat), " + "SUM(d.soLuong), " + "SUM(d.soLuong*d.giaSP) "
				+ "FROM HoaDonChiTiet d " + "GROUP BY MONTH(d.hoaDonHDCT.ngayDat)"
				+ "ORDER BY MONTH(d.hoaDonHDCT.ngayDat)";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> quantityByNCC() {
		String hql = "SELECT d.sanPhamHDCT.nhaCungCap, " + "SUM(d.soLuong), " + "SUM(d.soLuong*d.giaSP)"
				+ "FROM HoaDonChiTiet d " + "GROUP BY d.sanPhamHDCT.nhaCungCap";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public Double revenueByMonthNow() {
		String hql = "SELECT SUM(d.soLuong*d.giaSP) " + "FROM HoaDonChiTiet d "
				+ "WHERE MONTH(d.hoaDonHDCT.ngayDat) = MONTH(SYSDATE())";
		Session session = factory.getCurrentSession();
		TypedQuery<Double> query = session.createQuery(hql, Double.class);
		Double revenue = query.getSingleResult();
		return revenue;
	}

	@Override
	public Double revenueByYearNow() {
		String hql = "SELECT SUM(d.soLuong*d.giaSP) " + "FROM HoaDonChiTiet d "
				+ "WHERE YEAR(d.hoaDonHDCT.ngayDat) = YEAR(SYSDATE())";
		Session session = factory.getCurrentSession();
		TypedQuery<Double> query = session.createQuery(hql, Double.class);
		Double revenue = query.getSingleResult();
		return revenue;
	}
}
