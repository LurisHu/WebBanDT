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
@Table(name="hinhanhsp")
public class HinhAnhSP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaHINH")
	private Integer maHinh;
	
	@Column(name="LINKANH")
	private String linkAnh;
	@Column(name="MOTAHINH")
	private String moTaHinh;
	
	@ManyToOne
	@JoinColumn(name = "MaSP")
	SanPham sanPhamHA;

	public Integer getMaHinh() {
		return maHinh;
	}

	public void setMaHinh(Integer maHinh) {
		this.maHinh = maHinh;
	}

	public String getLinkAnh() {
		return linkAnh;
	}

	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	public String getMoTaHinh() {
		return moTaHinh;
	}

	public void setMoTaHinh(String moTaHinh) {
		this.moTaHinh = moTaHinh;
	}

	public SanPham getSanPhamHA() {
		return sanPhamHA;
	}

	public void setSanPhamHA(SanPham sanPhamHA) {
		this.sanPhamHA = sanPhamHA;
	}
}
