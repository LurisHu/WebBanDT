<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/account/login" method="post">
<label style="color:red">${message}</label>
	<div class="form-group">
		<label for="email">Email address:</label> <input id="email"
			type="email" class="form-control" name="email" placeholder="Email"
			value="${user.email}" required="required">
	</div>
	<div class="form-group">
		<label for="pwd">Password:</label> <input id="password"
			type="password" class="form-control" name="password"
			placeholder="Password" value="${user.matKhau}" required="required">
	</div>
	<div class="form-group form-check">
		<label class="form-check-label"> <input
			class="form-check-input" type="checkbox"> Remember me
		</label>
	</div>
	<button type="submit" class="btn btn-primary">Login</button>
</form>