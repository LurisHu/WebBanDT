package com.webbanhang.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaHD")
	private Integer maHD;
	
	@Column(name="NGAYDAT")
	@Temporal(TemporalType.DATE)
	private Date ngayDat;
	@Column(name="TONGTIEN")
	private Double tongTien;
	@Column(name="DIACHIGIAO")
	private String diaChiGiao;
	@Column(name="PHIVANCHUYEN")
	private Double phiVanChuyen;
	@Column(name="COMMENT")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="MaKH")
	private NguoiDung nguoiDungHD;
	
	@ManyToOne
	@JoinColumn(name="TINHTRANG")
	private TinhTrangHoaDon tinhTrangHD;
	
	@OneToMany(mappedBy = "hoaDonHDCT")
	List<HoaDonChiTiet> hoaDonChiTiet;

	public Integer getMaHD() {
		return maHD;
	}

	public void setMaHD(Integer maHD) {
		this.maHD = maHD;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public String getDiaChiGiao() {
		return diaChiGiao;
	}

	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}

	public Double getPhiVanChuyen() {
		return phiVanChuyen;
	}

	public void setPhiVanChuyen(Double phiVanChuyen) {
		this.phiVanChuyen = phiVanChuyen;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public NguoiDung getNguoiDungHD() {
		return nguoiDungHD;
	}

	public void setNguoiDungHD(NguoiDung nguoiDungHD) {
		this.nguoiDungHD = nguoiDungHD;
	}

	public TinhTrangHoaDon getTinhTrangHD() {
		return tinhTrangHD;
	}

	public void setTinhTrangHD(TinhTrangHoaDon tinhTrangHD) {
		this.tinhTrangHD = tinhTrangHD;
	}

	public List<HoaDonChiTiet> getHoaDonChiTiet() {
		return hoaDonChiTiet;
	}

	public void setHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTiet) {
		this.hoaDonChiTiet = hoaDonChiTiet;
	}
}
