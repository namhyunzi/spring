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
	<div class="row">
		<div class="col-12">
			<h1 class="fs-3">직원관리 - 직원 목록 정보 </h1>
			
			<form id="form-Employees" method="get" action="list">
			<table class="table">
				<colgroup>
						<col width="5%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox"></th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>급여</th>
						<th>고용일</th>
						<th>부서번호</th>
						<th>생성일</th>
						<th>수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empList }">
						<tr>
							<td><input type="checkbox" name="no" value="${emp.no }"></td>
							<td><a href="detail?no=${emp.no }">${emp.name }</a></td>
							<td>${emp.tel }</td>
							<td>${emp.email }</td>
							<td>${emp.salary }</td>
							<td><fmt:formatDate value="${emp.hireDate }"/></td>
							<td>${emp.dept.no }</td>
							<td><fmt:formatDate value="${emp.createdDate }"/></td>
							<td><fmt:formatDate value="${emp.updatedDate }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-4">
				<c:if test="${paging.totalRows ne 0 }">
					<nav>
						<ul class="pagination">
							<li class="page-item">
								<a href="list?page=${paging.currentPage - 1 }"
									class="page-link ${paging.first ? 'disabled' : '' }"
									onclick="changePage(${paging.currentPage - 1}, event)">이전</a>
							</li>
							
							<c:forEach var="num" begin="${paging.beginPage }" end="${paging.endPage }">
								<li class="page-item ${paging.currentPage eq num ? 'active': '' }">
									<a href="list?page=${num }"
										class="page-link"
										onclick="changePage(${num }, event)">${num }</a>
								</li>
							</c:forEach>
						
							<li class="page-item">
								<a href="list?page=${paging.currentPage + 1 }"
									class="page-link ${paging.last ? 'disabled' : '' }"
									onclick="changePage(${paging.currentPage + 1}, event)">다음</a>
							</li>
						</ul>
					</nav>
				</c:if>
			</div>			
				<div class="row mb-3">
					<div class="col-12">
						<div class="text-end">
							<a href="add" class="btn btn-primary">신규 직원 등록</a>
						</div>
					</div>
				</div>
				<div class="col-4">
					<button type="btn btn-outline-secondary btn-sm" onclick="removeCheckedEmployees()">선택삭제</button>
				</div>
			</form>
			
		</div>
	</div>
</div>	
<script type="text/javascript">
function removeCheckedEmployees() {

	let checkedCheckboxes = document.querySelectorAll("input[type=checkbox][name=no]:checked");
	if (checkedCheckboxes.length == 0) {
		alert("체크된 체크박스가 없습니다.")
		return;
	}
	
	let form = document.getElementById("form-Employees");
	form.setAttribute("action", "delete");
	form.submit();
}
</script>
</body>
</html>