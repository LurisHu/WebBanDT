<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span id="error">${message}</span>
<form:form modelAttribute="hoadon">
	<div class="form-group">
		<label for="formGroupExampleInput">Mã hóa đơn</label>
		<form:input cssClass="form-control" path="maHD"
			readonly="true" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput">Người Đặt</label>
		<form:input cssClass="form-control" path="nguoiDungHD.maNguoiDung"
			readonly="true" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput">Ngày Đặt</label>
		<form:input cssClass="form-control" path="ngayDat" type="date" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Tổng tiền</label>
		<form:input cssClass="form-control" path="tongTien" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Địa chỉ giao</label>
		<form:input cssClass="form-control" path="diaChiGiao" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Phí vận chuyển</label>
		<form:input cssClass="form-control" path="phiVanChuyen" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Comment</label>
		<form:input cssClass="form-control" path="comment" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Trạng thái</label>
		<form:select path="tinhTrangHD.maTinhTrang" class="form-control">
			<form:options items="${trangThai}" itemValue="maTinhTrang"
				itemLabel="tenTinhTrang" />
		</form:select>
	</div>
	<div class="form-group">
		<button class="btn btn-warning" formaction="/admin/hoadon/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/hoadon/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/hoadon/index">Reset</button>
	</div>
</form:form>