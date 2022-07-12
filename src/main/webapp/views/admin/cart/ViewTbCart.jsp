<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:if test="${!empty  sessionScope.error }">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong>${ sessionScope.error }</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<c:remove var="error" scope="session" />
</c:if>
<c:if test="${!empty  sessionScope.message }">
	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<strong>${ sessionScope.message }</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<c:remove var="message" scope="session" />
</c:if>
   
   <c:if test="${ empty carts }">
	<p class="alert alert warning">Không có dữ liệu</p>
</c:if>


	<table class="table">
	<thead>
		<th>Ảnh</th>
		<th>Tên sản phẩm</th>
		<th>Số lượng</th>
		<th>Giá</th>
		<th>Tổng tiền</th>
		<th>Thao tác</th>
	</thead>
	<tbody>
		<c:forEach items="${ carts }" var="cart">
			<c:if test="${!empty sessionScope.user}">
				<form action="${ pageContext.request.contextPath }/cart/update?id=${ cart.product.id }" method="post">
					<tr>

						<td><img
							src="${ pageContext.request.contextPath }/views/imgproduct/${ product.img }"
							height="100"></td>
						<td>${cart.product.name }</td>

						<td><input name="sloLuong" value="${ cart.soLuong }"></td>
						<td><fmt:formatNumber value="${ cart.product.donGia }"
								type="currency" /></td>
						<td><fmt:formatNumber
								value="${ cart.soLuong * cart.product.donGia }" type="currency" />
						</td>
						<td><a class="btn btn-danger"
							href="${ pageContext.request.contextPath }/cart/delete?id=${ cart.product.id }">Xóa</a>

							<button class="btn btn-danger ">Cập nhật</button></td>
					</tr>

				</form>
			</c:if>
		</c:forEach>

	</tbody>
</table>


<div class="card" style="width: 18rem;">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">Số tiền phải thanh toán: <fmt:formatNumber
				value="${ tong }" type="currency" />
		</li>
	</ul>
	<div class="card-footer">
		<a class="btn btn-danger "
			href="${pageContext.request.contextPath}/cart/update?id=${cart.id}">Đặt
			hàng</a>
	</div>
</div>