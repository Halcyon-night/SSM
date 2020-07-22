<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页展示信息</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<script src="static/js/jquery-1.8.2.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	th:src="@{https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js}"></script>
<link
	th:href="@{https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css}"
	rel="stylesheet" />
<link th:href="@{/css/default.css}" rel="stylesheet" />
<link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
</head>
<body>
	<c:forEach var="department" items="${list }">
	<table id="fptable" border="1px" class="table table-striped">
				<tr>
					<td rowspan="2" width="100px" align="center">科室</td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="50px">${department.departmentName }</td>
				</tr>
				<tr>
					<td colspan="1" width="100px" align="center">医生</td>
					<c:forEach var="doctor" items="${department.doctorList }">
						<td>${doctor.doctorName }</td>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="1" width="100px" align="center">职业</td>
					<c:forEach var="occupation" items="${department.occupationList }">
						<td>${occupation.occupationName }</td>
					</c:forEach>
				</tr>
				<tr>
					<td colspan="1" width="100px" align="center">科室描述</td>
					<td rowspan="2" colspan="2">${department.departmentDescribe }</td>
				</tr>
			</table>
	</c:forEach>
</body>
</html>