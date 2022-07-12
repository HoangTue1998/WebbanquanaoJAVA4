<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form
	action="${pageContext.request.contextPath}/cate/Categoryupdate?id=${ category.id }"
	method="POST">
	<c:if test="${ !empty sessionScope.error }">
		<p class="alert alert-danger">${ sessionScope.error }</p>
		<c:remove var="error" scope="session" />
	</c:if>

	<c:if test="${ !empty sessionScope.message }">
		<p class="alert alert-success">${ sessionScope.message }</p>
		<c:remove var="message" scope="session" />
	</c:if>
	<div class="m-4">
		<label>Tên loại sản phẩm:</label> <input class="form-control"
			type="text" name="ten" id="ten" value="${ category.ten }">
	</div>
	<div class="m-4">
		<div>
			<label for="floatingSelect">Người tạo</label> <select name="User_id"
				class="form-select">
				<c:forEach items="${ dsUser }" var="user">
					<option value="${ user.id }">${ user.hoTen }</option>
				</c:forEach>
			</select>
		</div>

	</div>
	<div class="m-4">
		<button class="btn btn-primary">Xác nhận</button>
	</div>

</form>