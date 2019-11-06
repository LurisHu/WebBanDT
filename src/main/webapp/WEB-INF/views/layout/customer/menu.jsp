<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark w-100">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Logo</a>
	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/home/home">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/home/index">Index</a>
		</li>
	</ul>
	<ul class="navbar-nav ml-auto">
		<!-- Dropdown -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Thông tin khách hàng </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="/account/register">Register</a> <a
					class="dropdown-item" href="/account/login">Login</a>
			</div></li>
	</ul>
</nav>