<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>bootstrap</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3">상품관리 - 상품 상세정보</h1>
			
			<div class="row">
					<div class="col-5">
						<img src="/resources/images/product/${product.filename }" class="img-thumbnail" />
					</div>
					<div class="col-8">
						<table class="table">
							<tr>
								<th>이름</th>
								<td colspan="3">${product.name }</td>
							</tr>
							<tr>
								<th>등록일</th>
								<td><fmt:formatDate value="${emp.createdDate }" pattern="yyyy-MM-dd"/></td>
								<th>수정일</th>
								<td><fmt:formatDate value="${emp.updatedDate }" pattern="yyyy-MM-dd"/></td>
							</tr>
						</table>
						
					<div class="text-end">
						<a href="" class="btn btn-primary">수정</a>
						<a href="" class="btn btn-danger">삭제</a>
					</div>
				</div>	
			</div>
		</div>
	</div>
</div>
</body>
</html>