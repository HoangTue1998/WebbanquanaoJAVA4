<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<style>
.product-grid {
	font-family: Raleway, sans-serif;
	text-align: center;
	padding: 0 0 72px;
	border: 1px solid rgba(0, 0, 0, .1);
	overflow: hidden;
	position: relative;
	z-index: 1
}

.product-grid .product-image {
	position: relative;
	transition: all .3s ease 0s
}

.product-grid .product-image a {
	display: block
}

.product-grid .product-image img {
	width: 100%;
	height: auto
}

.product-grid .pic-1 {
	opacity: 1;
	transition: all .3s ease-out 0s
}

.product-grid:hover .pic-1 {
	opacity: 1
}

.product-grid .product-discount-label, .product-grid .product-new-label
	{
	color: #fff;
	background-color: #ef5777;
	font-size: 12px;
	text-transform: uppercase;
	padding: 2px 7px;
	display: block;
	position: absolute;
	top: 10px;
	left: 0
}

.product-grid .product-discount-label {
	background-color: #333;
	left: auto;
	right: 0
}

.product-grid .rating {
	color: #FFD200;
	font-size: 12px;
	padding: 12px 0 0;
	margin: 0;
	list-style: none;
	position: relative;
	z-index: -1
}

.product-grid .rating li.disable {
	color: rgba(0, 0, 0, .2)
}

.product-grid .product-content {
	background-color: #fff;
	text-align: center;
	padding: 12px 0;
	margin: 0 auto;
	position: absolute;
	left: 0;
	right: 0;
	bottom: -27px;
	z-index: 1;
	transition: all .3s
}

.product-grid:hover .product-content {
	bottom: 0
}

.product-grid .title {
	font-size: 13px;
	font-weight: 400;
	letter-spacing: .5px;
	text-transform: capitalize;
	margin: 0 0 10px;
	transition: all .3s ease 0s
}

.product-grid .title a {
	color: #828282
}

.product-grid .title a:hover, .product-grid:hover .title a {
	color: #ef5777
}

.product-grid .price {
	color: #333;
	font-size: 17px;
	font-family: Montserrat, sans-serif;
	font-weight: 700;
	letter-spacing: .6px;
	margin-bottom: 8px;
	text-align: center;
	transition: all .3s
}

.product-grid .price span {
	color: #999;
	font-size: 13px;
	font-weight: 400;
	text-decoration: line-through;
	margin-left: 3px;
	display: inline-block
}

.product-grid .add-to-cart {
	color: #000;
	font-size: 13px;
	font-weight: 600
}

@media only screen and (max-width:990px) {
	.product-grid {
		margin-bottom: 30px
	}
}
</style>



<c:if test="${ empty dsProduct }">
	<p class="alert alert warning">Không có dữ liệu</p>
</c:if>

<c:if test="${!empty sessionScope.message }">
	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<strong>${ sessionScope.message }</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<c:remove var="message" scope="session" />
</c:if>
<div class="row">
	<c:if test="${ !empty dsProduct }">
		<c:forEach items="${ dsProduct }" var="pr">
			<div class="col-md-3 col-sm-6 p-4">
				<div class="product-grid">
					<div class="product-image">
						<a href="#"> <img class="pic-1"
							src="${ pageContext.request.contextPath }/views/imgproduct/${ pr.img }">
						</a>
					</div>

					<div class="product-content">
						<h3 class="title">
							<label>Tên sản phẩm:</label> <a href="#">${ pr.ten }</a>
						</h3>
						<div class="price">Giá: ${ pr.donGia }</div>
						<div class="price">Kích thước: ${ pr.kichThuoc }</div>
						<a class="add-to-cart"
							href="${pageContext.request.contextPath}/cart/viewCreate?id=${pr.id}">+
							Thêm vào giỏ hàng</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
</div>
</div>