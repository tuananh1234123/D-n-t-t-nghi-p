<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	${message }
	<div>
		<form:form action="index.php" modelAttribute="sinhvien">
			<div>
				<label for="nameStaff">Ma nhan vien</label>
				<div>
					<form:input path="manv" class="form-control" required="true"
						placeholder="Tên nhân viên" />
				</div>
				<label for="nameStaff">Tên nhân viên</label>
				<div>
					<form:input path="hoten" class="form-control" required="true"
						placeholder="Tên nhân viên" />
				</div>
				<label for="nameStaff">Dia chi</label>
				<div>
					<form:input path="diachi" class="form-control" required="true"
						placeholder="Diem" />
				</div>
				<label for="staffGender">Giới tính</label>
				<div class="form-check">
					<form:radiobutton path="gioitinh" class="form-check-input"
						value="True" />
					Nam </label> 
					<label class="form-check-label ml-4"> <form:radiobutton
							path="gioitinh" class="form-check-input" value="false" />Nữ 
				</div>
				<div class="modal-footer">
					<button name="btnInsert" class="btn btn-primary">Insert</button>
					<button name="btnUpdate" class="btn btn-primary">Update</button>
				</div>
		</form:form>
	</div>

	<table class="table table-responsive">
		<thead>
			<tr>
				<th>Mã Nhan Vien</th>
				<th>Họ tên</th>
				<th>Dia chi</th>
				<th>Gioi Tinh</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="s" items="${index}">
				<tr>
					<td>${s.manv}</td>
					<td>${s.hoten}</td>
					<td>${s.diachi}</td>
					<td>${s.gioitinh?"Nam":"Nu"}</td>
					<td><a href="index.php?edit&masv=${s.manv}">Edit</a></td>
					<td><a href="index.php?btnDelete&masv=${s.manv}">Delete</a></td>
				</tr>
			</c:forEach>
</body>
</html>