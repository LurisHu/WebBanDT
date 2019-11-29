<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${isValidValidate}">
		<form action="/reset" method="post">
			<label style="color: red">${message}</label>
			<div class="form-group">
				<label for="password">Mật khẩu mới:</label> <input id="password"
					type="password" class="form-control" name="password"
					placeholder="Nhập mật khẩu mới" required="required">
			</div>
			<div class="form-group">
				<label for="re-password">Nhập lại mật khẩu mới:</label> <input
					id="re-password" type="password" class="form-control"
					name="re-password" placeholder="Nhập lại mật khẩu mới"
					required="required">
			</div>
			<input type="hidden" name="validateKey" value="${validateKeyFromEmail}"/>
			<button type="submit" class="btn btn-primary">Xác nhận</button>
		</form>
	</c:when>
	<c:otherwise>
		<div class="card container style-transparent">
			<div class="card-body">
				<h1 class="text-danger">Thông báo lỗi</h1>
				<h2 class="text-danger">ValidateKey không tồn tại, vui lòng kiểm tra lại.</h2>
			</div>
			<!--end .card-body -->
		</div>
	</c:otherwise>
</c:choose>
