<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span id="error">${message}</span>
<form:form modelAttribute="dm">
	<form:hidden cssClass="form-control" path="maDM" />
	<div class="form-group">
		<label for="formGroupExampleInput">Tên danh mục</label>
		<form:input cssClass="form-control" path="tenDM" />
		<form:errors path="tenDM" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Mô tả</label>
		<form:input cssClass="form-control" path="moTa" />
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/danhmuc/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/danhmuc/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/danhmuc/delete" onclick="return confirm(' Bạn có muốn xóa danh mục này không?');">Delete</button>
		<button class="btn btn-info" formaction="/admin/danhmuc/index">Reset</button>
	</div>
</form:form>