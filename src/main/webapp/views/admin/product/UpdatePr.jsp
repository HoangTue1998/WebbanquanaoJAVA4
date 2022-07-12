
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class=" p-4">
	<form
		action="${pageContext.request.contextPath}/product/Updatepr?id=${ product.id }"
		method="POST">
		<label class="text-info fs-4 fw-bold">Thêm sản phẩm:</label>
		<div class="col">
			<label>Tên sản phẩm:<span class="text-danger">*</span>
			</label> <input class="form-control" type="text" name="ten"
				value="${ product.ten }" />
		</div>
		<div class="col">
			<label>Số lượng: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="soLuong"
				value="${ product.soLuong }" />
		</div>
		<div class="col">
			<label>Đơn giá: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="donGia"
				value="${ product.donGia }" />
		</div>
		<div class="col">
			<label>Màu sắc: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="mauSac"
				value="${ product.mauSac }" />
		</div>
		<div class="col">
			<label>Kích thước: <span class="text-danger">*</span></label> <select
				class="form-select" name="kichThuoc">
				<option value="S">Sire: S</option>
				<option value="M">Sire: M</option>
				<option value="L">Sire: L</option>
				<option value="XL">Sire: XL</option>
				<option value="XXL">Sire: XXL</option>
			</select>

		</div>
		<div class="col">
			<label>Thể loại: <span class="text-danger">*</span></label> <select
				name="category_id" class="form-select">
				<c:forEach items="${ dsCate }" var="categori">
					<c:choose>
						<c:when test="${ categori.id == product.category.id }">
							<option value="${product.category.id }" selected>
								${product.category.ten }</option>
						</c:when>

						<c:otherwise>
							<option value="${categori.id }">${categori.ten }</option>
						</c:otherwise>

					</c:choose>


				</c:forEach>
			</select>
		</div>
		<br>

		<div class="col">
			<button class="btn btn-primary" type="submit">Xác nhận</button>
		</div>
	</form>