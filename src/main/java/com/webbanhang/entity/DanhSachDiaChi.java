package com.webbanhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="danhsachdiachi")
public class DanhSachDiaChi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaDSDIACHI")
	private Integer maDiaChi;
	
	@Column(name="DIACHI")
	private String diaChi;
	@Column(name="TENTINH")
	private String tenTinh;
	@Column(name="QUANHUYEN")
	private String quanHuyen;
	@Column(name="PHUONGXA")
	private String phuongXa;

	@ManyToOne
	@JoinColumn(name = "MaKH")
	NguoiDung nguoiDungDC;

	public Integer getMaDiaChi() {
		return maDiaChi;
	}

	public void setMaDiaChi(Integer maDiaChi) {
		this.maDiaChi = maDiaChi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}

	public NguoiDung getNguoiDungDC() {
		return nguoiDungDC;
	}

	public void setNguoiDungDC(NguoiDung nguoiDungDC) {
		this.nguoiDungDC = nguoiDungDC;
	}
}
