package com.webbanhang.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSP", nullable = false)
	private Integer maSP;
	@NotEmpty(message = "Không để trống tên sản phẩm")
	@Column(name = "TENSP")
	private String tenSP;
	@Column(name = "MOTA")
	private String moTa;
	@Column(name = "GIASP")
	@NotNull(message = "Không để trống giá sản phẩm")
	private Double giaSP;
	@Column(name = "SOLUONG")
	@NotNull(message = "Không để trống số lượng sản phẩm")
	private Integer soLuong;
	@Column(name = "SOLUONGBAN")
	private Integer soLuongBan;
	@Column(name = "SPDACBIET")
	private Boolean spDacBiet;
	@Column(name = "SOLANXEM")
	private Integer soLanXem;
	@Column(name = "GIAMGIA")
	@NotNull(message = "Không để trống giảm giá sản phẩm")
	private Double giamGia;
	@Column(name = "HINHANH")
	@NotEmpty(message = "Không để trống hình ảnh sản phẩm")
	private String image;
	@Column(name = "CAUHINHCHITIET")
	@NotEmpty(message = "Không được để trống cấu hình sản phẩm")
	private String cauHinhSP;

	@ManyToOne
	@JoinColumn(name = "MaNCC")
	NhaCungCap nhaCungCap;

	@ManyToOne
	@JoinColumn(name = "MaDM")
	DanhMuc danhMuc;

	@OneToMany(mappedBy = "sanPhamBL")
	List<BinhLuan> binhLuan;

	@OneToMany(mappedBy = "sanPhamDG")
	List<DanhGia> danhGia;

	@OneToMany(mappedBy = "sanPhamHDCT")
	List<HoaDonChiTiet> hoaDonChiTiet;

	public Integer getMaSP() {
		return maSP;
	}

	public void setMaSP(Integer maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public Integer getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(Integer soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public Boolean getSpDacBiet() {
		return spDacBiet;
	}

	public void setSpDacBiet(Boolean spDacBiet) {
		this.spDacBiet = spDacBiet;
	}

	public Integer getSoLanXem() {
		return soLanXem;
	}

	public void setSoLanXem(Integer soLanXem) {
		this.soLanXem = soLanXem;
	}

	public Double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(Double giamGia) {
		this.giamGia = giamGia;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
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

	public List<HoaDonChiTiet> getHoaDonChiTiet() {
		return hoaDonChiTiet;
	}

	public void setHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTiet) {
		this.hoaDonChiTiet = hoaDonChiTiet;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "" + tenSP + "";
	}

	public String getCauHinhSP() {
		return cauHinhSP;
	}

	public void setCauHinhSP(String cauHinhSP) {
		this.cauHinhSP = cauHinhSP;
	}

}
