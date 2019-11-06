package com.webbanhang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="binhluan")
public class BinhLuan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaBL")
	private Integer maBL;
	
	@Column(name="NDUNGBL")
	private String noiDung;
	@Column(name="TINHTRANG")
	private Integer tinhTrang;
	@Column(name="NGAYBL")
	@Temporal(TemporalType.DATE)
	private Date ngayBL;
	
	@ManyToOne
	@JoinColumn(name = "MaKH")
	NguoiDung nguoiDungBL;
	
	@ManyToOne
	@JoinColumn(name = "maSP")
	SanPham sanPhamBL;

	public Integer getMaBL() {
		return maBL;
	}

	public void setMaBL(Integer maBL) {
		this.maBL = maBL;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Integer getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getNgayBL() {
		return ngayBL;
	}

	public void setNgayBL(Date ngayBL) {
		this.ngayBL = ngayBL;
	}

	public NguoiDung getNguoiDungBL() {
		return nguoiDungBL;
	}

	public void setNguoiDungBL(NguoiDung nguoiDungBL) {
		this.nguoiDungBL = nguoiDungBL;
	}

	public SanPham getSanPhamBL() {
		return sanPhamBL;
	}

	public void setSanPhamBL(SanPham sanPhamBL) {
		this.sanPhamBL = sanPhamBL;
	}
}
