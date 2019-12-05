<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="/admin/dashboard/index">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Admin</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0" />

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link"
		href="/admin/dashboard/index"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Quản
				lý người dùng</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Quản lý người dùng:</h6>
				<a class="collapse-item" href="/admin/nguoidung/admin/index">Quản
					lý Admin</a> <a class="collapse-item"
					href="/admin/nguoidung/customer/index">Quản lý Customer</a>
			</div>
		</div></li>

	<li class="nav-item"><a class="nav-link"
		href="/admin/sanpham/index/0"> <i class="	fas fa-pencil-alt"></i> <span>Quản
				lý sản phẩm</span>
	</a></li>
	
	<li class="nav-item"><a class="nav-link"
		href="/admin/nhacungcap/index"> <i class="	fas fa-pencil-alt"></i> <span>Quản
				lý nhà cung cấp</span>
	</a></li>
	
	<li class="nav-item"><a class="nav-link"
		href="/admin/danhmuc/index"> <i class="	fas fa-pencil-alt"></i> <span>Quản
				lý danh mục</span>
	</a></li>
	
	<li class="nav-item"><a class="nav-link"
		href="/admin/diachi/index"> <i class="	fas fa-pencil-alt"></i> <span>Quản
				lý địa chỉ</span>
	</a></li>
	
	<li class="nav-item"><a class="nav-link"
		href="/admin/hoadon/index/0"> <i class="	fas fa-pencil-alt"></i> <span>Quản
				lý hóa đơn</span>
	</a></li>

	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="tables.html"> <i
			class="fas fa-fw fa-table"></i> <span>Tables</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>