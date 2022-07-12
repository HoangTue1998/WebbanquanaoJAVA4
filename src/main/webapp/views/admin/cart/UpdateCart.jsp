<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<form
	action="${ pageContext.request.contextPath }/categories/update?id=${ category.id }"
	method="POST">

	<div class="mb-3">
		<label for="exampleInputEmail1" class="form-label">Họ tên</label> <input
			class="form-control" type="text" name="name"
			value="${ category.name }">
	</div>
	<div class="form-floating mb-3">
		<select name="user_id" class="form-select">
			<c:forEach items="${ dsUser }" var="user">
				<option value="${ user.id }">${ user.hoTen }</option>
			</c:forEach>
		</select> <label for="floatingSelect">Người tạo</label>
	</div>
	<div>
		<button>Sửa</button>
		<button type="reset">Xóa Form</button>
	</div>
</form>