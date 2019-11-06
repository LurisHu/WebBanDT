<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="dc">
	<form:hidden path="maDiaChi" class="form-control" />
	<div class="form-group">
		<label>Địa chỉ</label>
		<form:input path="diaChi" class="form-control" />
	</div>
	<div class="form-group">
		<label for="first">Tỉnh thành</label> 
		<select id="first" name="city" class="form-control" role="listbox">
			<option value="0" selected="selected">Select Option</option>
		</select>
	</div>
	<div class="form-group">
		<label for="second">Quận/Huyện</label> 
		<select id="second" name="district" class="form-control" role="listbox" disabled="disabled">
			<option value="0" selected="selected">Select Option</option>
		</select>
	</div>
	<div class="form-group">
		<label for="third">Phường xã</label> 
		<select id="third" name="ward" class="form-control" role="listbox" disabled="disabled">
			<option value="0" selected="selected">Select Option</option>
		</select>
	</div>
	<div id="testData"></div>
	<div class="form-group">
		<button class="btn btn-primary" formaction="/admin/diachi/create">Create</button>
		<button class="btn btn-warning" formaction="/admin/diachi/update">Update</button>
		<button class="btn btn-danger" formaction="/admin/diachi/delete">Delete</button>
		<button class="btn btn-info" formaction="/admin/diachi/index">Reset</button>
	</div>
</form:form>