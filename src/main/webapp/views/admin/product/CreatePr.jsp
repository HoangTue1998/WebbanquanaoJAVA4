
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class=" p-4">
	<form action="${pageContext.request.contextPath}/product/Createpr"
		method="POST">
		<label class="text-info fs-4 fw-bold">Thêm sản phẩm:</label>
		<div class="col">
			<label>Tên sản phẩm:<span class="text-danger">*</span>
			</label> <input class="form-control" type="text" name="ten" />
		</div>
		<div class="col">
			<label>Số lượng: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="soLuong" />
		</div>
		<div class="col">
			<label>Đơn giá: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="donGia" />
		</div>
			<div class="col">
			<label>Màu sắc: <span class="text-danger">*</span></label> <input
				class="form-control" type="text" name="mauSac" />
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
<div class="col">
<label>Ảnh sản phẩm: <span class="text-danger">*</span></label>
<input class="form-control" type="file" name="img">

</div>
		</div>
		<div class="col">
			<label>Thể loại: <span class="text-danger">*</span></label> <select
				class="form-select" name="category_id">
				<c:forEach items="${ dsCate }" var="category">
					<option value="${ category.id }">${ category.ten }</option>
				</c:forEach>
			</select>
		</div>
		<br>

		<div class="col">
			<button class="btn btn-primary" type="submit">Xác nhận</button>
			<button type="reset" class="btn btn-info"> làm mớt</button>
</div>
</form>


