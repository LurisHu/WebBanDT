<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Product List</h1>
<hr />
<jsp:include page="../cart/info.jsp" />
<hr />
<c:forEach var="p" items="${productUser}">
	<div class="col-sm-3">
		<div class="panel panel-default">

			<div class="panel-body">
				<a href="/product/detail/${p.maSP}"> <label>${p.tenSP}</label> <br />
					<img src="/static/images/${p.image}" height="200px" width="200px" />
				</a>
			</div>
			<form method="post">
				<div class="text-right">
					<button class="btn btn-default" formaction="/cart/add/${p.maSP}">Add</button>
					<button class="btn btn-success">Star</button>
					<button class="btn btn-primary">Email</button>
				</div>
			</form>
		</div>
	</div>
</c:forEach>
