<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<c:if test="${empty ListUser }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<c:if test="${ !empty sessionScope.error }">
	<p class="alert alert-danger">${ sessionScope.error }</p>
	<c:remove var="error" scope="session"/>
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<p class="alert alert-success">${ sessionScope.message }</p>
		<c:remove var="message" scope="session"/>
</c:if>
<c:if test="${!empty ListUser }">

	<table class="table table-primary">
		<thead>
			<th>Họ và tên</th>
			<th>Giới tính</th>
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Email</th>
			<th>Avatar</th>
			<th>Vai trò</th>
			<th colspan="2">Thao tác</th>

		</thead>
		<tbody>
			<c:forEach items="${ ListUser }" var="user">
				<tr>
					<td>${ user.hoTen }</td>
					<td><c:choose>
							<c:when test="${ user.gioiTinh == 0 }">Nam</c:when>
							<c:when test="${ user.gioiTinh == 1 }">Nữ</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></td>
					<td>${ user.sdt }</td>
					<td>${ user.diaChi }</td>
					<td>${ user.email }</td>
					<td><img
						src="${pageContext.request.contextPath}/views/img_user/${user.avatar }"
						height="70" /></td>
					<td><c:choose>
							<c:when test="${user.vaitro == 0 }">Admin</c:when>
							<c:when test="${user.vaitro == 1 }">Nhân viên</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></td>
					<td><a class="btn btn-info"
						href="${pageContext.request.contextPath}/users/viewUpdate?id=${ user.id }">Cập
							nhật</a></td>
					<td>
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#exampleModal${ user.id }">
							Xóa</button>
						<div class="modal fade" id="exampleModal${ user.id }" tabindex="-1"
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
											href="${pageContext.request.contextPath}/users/Delete?id=${ user.id }">
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
<a href="" class="btn btn-primary">

</a>