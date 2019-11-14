package com.webbanhang.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="nguoidung")
//test nha 
public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaNGUOIDUNG")
	private Integer maNguoiDung;
	
	@Column(name="MATKHAU")
	@Length(min = 6)
	private String matKhau;
	@Column(name="HOTEN")
	@NotEmpty
	private String hoTen;
	@Column(name="NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	@Column(name="GIOITINH")
	private Boolean gioiTinh;
	@Column(name="MANGXH")
	private String mangXH;
	@Column(name="LOAIKH")
	private Integer loaiKH;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	@NotNull
	@Email
	private String email;
	@Column(name="isAdmin")
	private Boolean isAdmin;
	@Column(name="isActive")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "nguoiDungBL")
	List<BinhLuan> binhLuan;
 
	@OneToMany(mappedBy = "nguoiDungDG")
	List<DanhGia> danhGia;
	
	@OneToMany(mappedBy = "nguoiDungDC")
	List<DanhSachDiaChi> danhSachDiaChi;
	
	@OneToMany(mappedBy = "nguoiDungHD")
	List<HoaDon> hoaDon;
	
	@Override
	public String toString() {
		return hoTen;
	}

	public Integer getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(Integer maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getMangXH() {
		return mangXH;
	}

	public void setMangXH(String mangXH) {
		this.mangXH = mangXH;
	}

	public Integer getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(Integer loaiKH) {
		this.loaiKH = loaiKH;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<BinhLuan> getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(List<BinhLuan> binhLuan) {
		this.binhLuan = binhLuan;
	}

	public List<DanhGia> getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(List<DanhGia> danhGia) {
		this.danhGia = danhGia;
	}

	public List<DanhSachDiaChi> getDanhSachDiaChi() {
		return danhSachDiaChi;
	}

	public void setDanhSachDiaChi(List<DanhSachDiaChi> danhSachDiaChi) {
		this.danhSachDiaChi = danhSachDiaChi;
	}

	public List<HoaDon> getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(List<HoaDon> hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
