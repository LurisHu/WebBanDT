package com.webbanhang.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="danhmuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaDM",nullable = false)
	private Integer maDM;
	@Column(name="TENDM")
	@NotEmpty(message="Không để trống tên danh mục")
	private String tenDM;
	@Column(name="MOTADM")
	private String moTa;
	
	@OneToMany(mappedBy = "danhMuc",fetch = FetchType.EAGER)
	List<SanPham> sanPham;

	public Integer getMaDM() {
		return maDM;
	}

	public void setMaDM(Integer maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
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

	@Override
	public String toString() {
		return "" + tenDM + "";
	}
	
	
}
