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
<form action="${pageContext.request.contextPath}/cate/Categorycreate"
	method="POST">
	<div class="m-4">
		<label>Tên loại sản phẩm:</label> <input class="form-control"
			type="text" name="ten">
	</div>

	<div>
		<label>Người tạo</label>
		 <select name="User_id">
			<c:forEach items="${ dsUser }" var="user">
				<option value="${ user.id }">${ user.hoTen }</option>
			</c:forEach>
		</select>
	</div>

	</div>

	<div class="m-4">
		<button class="btn btn-primary">Xác nhận</button>
		<button class="btn btn-secondary" type="reset">Làm mới</button>
	</div>

</form>
<hr>

<c:if test="${ empty dsCate }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<h3 class="text-center">Danh sách loại sản phẩm</h3>

<c:if test="${ !empty dsCate }">
	<table class="table table-secondary table-hover mt-4">
		<thead>
			<th>Tên thể loại</th>
			<th>Người thêm</th>
			<th colspan="2" class="ms-5">Thao tac</th>
		</thead>
		<tbody>
			<c:forEach items="${ dsCate }" var="category">
				<tr>
					<th>${category.ten }</th>
					<th>${category.user.hoTen }</th>
					<td><a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/cate/viewUpdate?id=${ category.id }">Update </a></td>
						<td>
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#exampleModal${ category.id }">
							Xóa</button>
						<div class="modal fade" id="exampleModal${ category.id }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">Bạn muốn xoá tài khoản này?</div>
									<div class="modal-footer">
								   <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
										<a class="btn btn-danger"
											href="${pageContext.request.contextPath}/cate/Categorydelete?id=${ category.id }">
											Xóa </a>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>




