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
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaHDCT")
	private Integer maHDCT;
	@Column(name = "GIASP")
	private Double giaSP;
	@Column(name = "SOLUONG")
	private Integer soLuong;
	@Column(name = "GIAMGIA")
	private Double giamGia;

	@ManyToOne
	@JoinColumn(name = "MaHD")
	private HoaDon hoaDonHDCT;

	@ManyToOne
	@JoinColumn(name = "MaSP")
	private SanPham sanPhamHDCT;

	public Integer getMaHDCT() {
		return maHDCT;
	}

	public void setMaHDCT(Integer maHDCT) {
		this.maHDCT = maHDCT;
	}

	public Double getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(Double giaSP) {
		this.giaSP = giaSP;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(Double giamGia) {
		this.giamGia = giamGia;
	}

	public HoaDon getHoaDonHDCT() {
		return hoaDonHDCT;
	}

	public void setHoaDonHDCT(HoaDon hoaDonHDCT) {
		this.hoaDonHDCT = hoaDonHDCT;
	}

	public SanPham getSanPhamHDCT() {
		return sanPhamHDCT;
	}

	public void setSanPhamHDCT(SanPham sanPhamHDCT) {
		this.sanPhamHDCT = sanPhamHDCT;
	}
}
