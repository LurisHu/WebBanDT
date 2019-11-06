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
@Table(name="danhgia")
public class DanhGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaDG")
	private Integer maDG;
	
	@Column(name="DIEM")
	private Integer diem;
	@Column(name="NDUNGDG")
	private String noiDung;
	@Column(name="NGAYDG")
	@Temporal(TemporalType.DATE)
	private Date ngayDG;
	
	@ManyToOne
	@JoinColumn(name = "MaKH")
	NguoiDung nguoiDungDG;
	
	@ManyToOne
	@JoinColumn(name = "MaSP")
	SanPham sanPhamDG;

	public Integer getMaDG() {
		return maDG;
	}

	public void setMaDG(Integer maDG) {
		this.maDG = maDG;
	}

	public Integer getDiem() {
		return diem;
	}

	public void setDiem(Integer diem) {
		this.diem = diem;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayDG() {
		return ngayDG;
	}

	public void setNgayDG(Date ngayDG) {
		this.ngayDG = ngayDG;
	}

	public NguoiDung getNguoiDungDG() {
		return nguoiDungDG;
	}

	public void setNguoiDungDG(NguoiDung nguoiDungDG) {
		this.nguoiDungDG = nguoiDungDG;
	}

	public SanPham getSanPhamDG() {
		return sanPhamDG;
	}

	public void setSanPhamDG(SanPham sanPhamDG) {
		this.sanPhamDG = sanPhamDG;
	}
}
