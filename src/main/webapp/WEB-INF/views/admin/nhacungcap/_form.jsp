<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<span id="error">${message}</span>
<form:form modelAttribute="ncc">
	<form:hidden cssClass="form-control" path="maNCC" />
	<div class="form-group">
		<label for="formGroupExampleInput">Tên nhà cung cấp</label>
		<form:input cssClass="form-control" path="tenNCC" />
		<form:errors path="tenNCC" />
	</div>
	<div class="form-group">
		<label for="formGroupExampleInput2">Mô tả</label>
		<form:input cssClass="form-control" path="moTa" />
	</div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/nhacungcap/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/nhacungcap/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/nhacungcap/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/nhacungcap/index">Reset</button>
	</div>
</form:form>