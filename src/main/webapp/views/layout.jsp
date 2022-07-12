<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASM - Tuehvph13476</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<a class="navbar-brand" href="#"> <img
				src="${pageContext.request.contextPath}/views/image/logo.jpg" alt=""
				width="50" height="50">
			</a>

			<div class="container-fluid">
				<a class="navbar-brand" href="">Trang chủ</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="hang" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Hàng mới </a>
							<ul class="dropdown-menu" aria-labelledby="hang">
								<li><a class="dropdown-item" href="#">Quần</a></li>
								<li><a class="dropdown-item" href="#">Áo</a></li>
								<li><a class="dropdown-item" href="#">Giày</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link" href="#">Quần</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Áo</a></li>
						<li class="nav-item"><a class="nav-link">Váy</a></li>


						<li class="nav-item dropdown "><a
							class="nav-link dropdown-toggle" href="#" id="taikhoan"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Tài khoản </a>
							<ul class="dropdown-menu" aria-labelledby="taikhoan">

								<c:if test="${ empty user }">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/users/viewUpdate?id=${ user.id }">Đăng
											nhập</a></li>
								</c:if>

								<c:if test="${ empty user }">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/accCreate">Đăng
											ký</a></li>
								</c:if>


								<c:if test="${ empty user }">
									<li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
								</c:if>


								<c:if test="${ user.vaitro == 0 }">
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/users/viewUser">Quản lý tài
											khoản</a></li>
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/cate/viewCate">Quản lý loại sản
											phẩm</a></li>
									<li><a class="dropdown-item" href="${pageContext.request.contextPath}/product/Tablepr">Quản lý sản phẩm</a>
									</li>
								</c:if>
								<c:if test="${ !empty user }">
									<li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
								</c:if>

								<c:if test="${ !empty user }">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/logOut">Đăng xuất</a></li>
								</c:if>
									<c:if test="${ !empty user }">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/cart/ViewTb">Xem giỏ hàng</a></li>
								</c:if>
							</ul></li>



					</ul>
				</div>
			</div>
		</nav>
		<div class="row">
			<div class="col-12">
				<jsp:include page="${ view }"></jsp:include>
			</div>
		</div>
		<footer class="bg-danger">
			<h4 class="text-center">Tuehvph13476</h4>
		</footer>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>