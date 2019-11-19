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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
//push test 19/11

@Entity
@Table(name="nguoidung")

public class NguoiDung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaNGUOIDUNG")
	private Integer maNguoiDung;
	
	@Column(name="MATKHAU")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Mật khẩu bạn nhập phải thỏa mãn độ dài ít nhất 8 ký tự, chứa ít nhất một chữ số, chứa ít nhất một ký tự viết thường và một ký tự viết hoa và có ít nhất một ký tự đặc biệt(@#%$^ etc.).Không chứa khoảng trắng, tab.")
	private String matKhau;
	@Column(name="HOTEN")
	@NotEmpty(message = "Họ tên không được để trống")
	private String hoTen;
	@Column(name="NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Vui lòng chọn ngày sinh")
	private Date ngaySinh;
	@Column(name="GIOITINH")
	@NotNull(message = "Vui lòng chọn giới tính")
	private Boolean gioiTinh;
	@Column(name="MANGXH")
	private String mangXH;
	@Column(name="LOAIKH")
	private Integer loaiKH;
	@Column(name="PHONE")
	@Pattern(regexp = "(03|04|05|07|08|09)[0-9]{8}", message = "Số điện thoại phải là 10 số và các đầu số thuộc các nhà mạng Việt Nam(03|04|05|07|08|09)")
	private String phone;
	@Column(name="EMAIL")
	@Email(message = "Email không đúng định dạng")
	@NotBlank(message = "Email không được để trống")
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
