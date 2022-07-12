<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="POST"
	action="${pageContext.request.contextPath}/cate/Categorycreate">
	<div class="mb-3">
		<label class="form-label">Tên danh mục</label> <input type="text" name="name"  class="form-control">
	</div>
	<div class="form-floating mb-3">
		<table class="table table-dark">
  <thead>
    <tr>
      <th>Tên sản phẩm</th>
      <th>giá</th>
      <th>Số lượng</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
  </tbody>
</table>
	</div>
	<button>Thêm mới</button>
</form>