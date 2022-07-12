<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<c:if test="${ empty dsPro }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<p class="alert alert-danger">${ sessionScope.error }</p>
	<c:remove var="error" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<p class="alert alert-success">${ sessionScope.message }</p>
	<c:remove var="message" scope="session" />
</c:if>
	<a href="${pageContext.request.contextPath}/product/viewCreatepr" class=" m-2 btn btn-info">Thêm mới sản phẩm</a>
	<hr>
<c:if test="${ !empty dsPro }">
	<div>
		<table class="table table-primary">
			<thead>
				<th>Tên sản phẩm</th>
				<th>Số lượng</th>
				<th>Đơn giá</th>
				<th>Màu sắc</th>
				<th>Kích thước</th>
				<th>Ảnh sản phẩm</th>
				<th>Loại sản phẩm</th>
				<th colspan="2">Thao tác</th>
			</thead>
			<tbody>
				<c:forEach items="${ dsPro }" var="product">
					<tr>
						<td>${ product.ten }</td>
						<td>${ product.soLuong}</td>
						<td>${ product.donGia }</td>
						<td>${ product.mauSac }</td>
						<td>${ product.kichThuoc }</td>
						<td><img
							src="${ pageContext.request.contextPath }/views/imgproduct/${ product.img }"
							height="70" /></td>
						<td>${ product.category.ten }</td>
						<td><a
							href="${ pageContext.request.contextPath }/product/viewUpdatepr?id=${ product.id }"
							class="btn btn-warning">Sửa 	</a></td>
						<td>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary"
								data-bs-toggle="modal"
								data-bs-target="#exampleModal${ product.id }">Xóa</button>
							<div class="modal fade" id="exampleModal${ product.id }"
								tabindex="-1" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Bạn muốn xoá sản phẩm này?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Huỷ</button>
											<a class="btn btn-danger"
												href="${pageContext.request.contextPath}/product/Deletepr?id=${ product.id }">
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
	
	</div>

</c:if>