<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<c:if test="${ !empty sessionScope.error }">
	<p class="alert alert-danger">${ sessionScope.error }</p>
	<c:remove var="error" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<p class="alert alert-success">${ sessionScope.message }</p>
	<c:remove var="message" scope="session" />
</c:if>
<h1 class="text-center p-4">Đăng ký tài khoản</h1>
<div class="d-flex justify-content-center ">
	<form action="${pageContext.request.contextPath}/accCreate"
		method="POST" class="needs-validation" enctype="multipart/form-data">
		<div class="row">
			<div class="col">
				<label>Họ và tên:</label> <input type="text" name="hoTen" id="hoTen"
					class="form-control" placeholder="Họ và tên" aria-label="Họ và tên">
				<div class="invalid-feedback">Xin mời nhập họ tên</div>
				<div class="valid-feedback">Có vẻ tốt</div>

			</div>
			<div class="col">
				<label>Số điện thoại:</label> <input name="sdt" type="tel"
					class="form-control" placeholder="Số điện thoại"
					aria-label="Số điện thoại">
			</div>

		</div>
		<div class="col">
			<label>Giới tính:</label> <br> <input type="radio"
				name="gioiTinh" value="0" checked="checked"> <label>Nam</label>
			<input class="m-2" type="radio" name="gioiTinh" value="1"> <label>Nữ</label>
		</div>
		<div class="col">
			<label>Địa chỉ:</label> <input name="diaChi" type="text" id="diaChi"
				class="form-control" placeholder="Địa chỉ" aria-label="Địa chỉ">
		</div>
		<div class="col">
			<label>Email:</label> <input name="email" type="email"
				class="form-control" placeholder="Email" aria-label="Email">
		</div>
		<div class="col">
			<label>Mật khẩu:</label> <input name="password" type="password"
				class="form-control" placeholder="Mật khẩu" aria-label="Mật khẩu">

		</div>
		<div class="col">
			<label>Avatar:</label> <input id="avatar" name="avatar" type="file"
				class="form-control">
		</div>
		<div class="col">
			<label>Vai trò:</label> <br> <input type="radio"
				name="vaitro" value="1" checked="checked"> <label>Nhân viên</label>
		
		</div>
		<button class="btn btn-primary m-2">Xác nhận</button>
		<button type="reset" class="btn btn-danger">Làm mới</button>
	</form>
</div>
