package com.webbanhang.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nhacungcap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaNCC",nullable = false)
	private Integer maNCC;
	@Column(name="TENNCC")
	private String tenNCC;
	@Column(name="MOTA")
	private String moTa;
	
	@OneToMany(mappedBy = "nhaCungCap")
	List<SanPham> sanPham;

	public Integer getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(Integer maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<SanPham> getSanPham() {
		return sanPham;
	}

	public void setSanPham(List<SanPham> sanPham) {
		this.sanPham = sanPham;
	}
}
