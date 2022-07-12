<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<meta charset="UTF-8">

<h1 class="text-center p-4">Đăng nhập</h1>
<div class="row">
<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">
		${ sessionScope.error }
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</c:if>
	<div class="d-flex justify-content-center">
		<form id="Formlg" action="${pageContext.request.contextPath}/lg"
			method="POST">
			<div>
				<div class="input-group mb-3">
					<span class="input-group-text" id="email">Tài khoản</span> <input
						type="email" id="email" class="form-control" name="email">
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text" id="password">Mật khẩu</span> <input
						type="password" id="password" class="form-control" name="password">
				</div>
				<div class="row">
					<div class="form-check col-6">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Nhớ
							mật khẩu</label>
					</div>
					<div class="d-flex flex-row-reverse col-6">
						<a href="" class="text-decoration-none " style="color: black;">Quyên
							mật khẩu</a>
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary m-3">Đăng
						nhập</button>

					<a href="${pageContext.request.contextPath}/accCreate"
						class="btn btn-primary">Đăng ký</a>
				</div>
			</div>
		</form>
	</div>



</div>