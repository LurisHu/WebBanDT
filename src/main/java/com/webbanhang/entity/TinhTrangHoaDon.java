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
@Table(name="tinhtranghoadon")
public class TinhTrangHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaTINHTRANG")
	private Integer maTinhTrang;
	
	@Column(name="TENTINHTRANG")
	private String tenTinhTrang;
	
	@OneToMany(mappedBy = "tinhTrangHD")
	List<HoaDon> hoaDon;

	public Integer getMaTinhTrang() {
		return maTinhTrang;
	}

	public void setMaTinhTrang(Integer maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}

	public String getTenTinhTrang() {
		return tenTinhTrang;
	}

	public void setTenTinhTrang(String tenTinhTrang) {
		this.tenTinhTrang = tenTinhTrang;
	}

	public List<HoaDon> getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(List<HoaDon> hoaDon) {
		this.hoaDon = hoaDon;
	}

	@Override
	public String toString() {
		return "" + tenTinhTrang + "";
	}
	
	
}
