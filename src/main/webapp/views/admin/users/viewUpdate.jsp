<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<h1 class="text-center p-4">Cập nhật tài khoản</h1>
<div class="d-flex justify-content-center ">
	<form action="${pageContext.request.contextPath}/users/Update?id=${ user.id }"
		method="POST">
		<div class="row">
			<div class="col">
				<label>Họ và tên:</label> <input type="text" name="hoTen" id="hoTen"
					class="form-control" placeholder="Họ và tên" value="${ user.hoTen }">
			</div>
			<div class="col">
				<label>Số điện thoại:</label> <input name="sdt" type="tel"
					class="form-control" placeholder="Số điện thoại"
					value="${user.sdt }">
			</div>

		</div>
		<div class="col">
			<label>Giới tính:</label> <br> <input type="radio"
				name="gioiTinh" value="0" checked="checked"
				${user.gioiTinh == 0 ? "checked" : ""}> <label>Nam</label> <input
				class="m-2" type="radio" name="gioiTinh" value="1"
				${user.gioiTinh == 1 ? "checked" : ""}> <label>Nữ</label>
		</div>
		<div class="col">
			<label>Địa chỉ:</label> <input name="diaChi" type="text"
				class="form-control" placeholder="Địa chỉ" value="${ user.diaChi }">
		</div>
		<div class="col">
			<label>Email:</label> <input name="email" type="email"
				class="form-control" placeholder="Email" value="${ user.email }">
		</div>
		<div class="col">
				<label>Avatar:</label> <input name="avatar" type="file" class="form-control"
				 value="${pageContext.request.contextPath}/views/img_user/+${ user.avatar }">
		</div>
		<div class="col">
			<label>Vai trò:</label> <br> <input type="radio" name="vaitro"
				value="0" checked="checked" ${ user.vaitro == 0 ? "checked" : ""}>
			<label>Admin</label> <input class="m-2" type="radio" name="vaitro"
				value="1" ${ user.vaitro == 1 ? "checked" : "" }> <label>Nhân
				viên</label>
		</div>
		<button class="btn btn-primary m-2">Xác nhận</button>
		<button type="reset" class="btn btn-primary">Làm mới</button>
	</form>
</div>