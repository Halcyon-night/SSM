<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>护士管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
    .layui-table{
      width: 50%;
      margin-left: 25%;
    }
  </style>

<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<script src="static/js/jquery-1.8.2.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	th:src="@{https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js}"></script>
<link
	th:href="@{https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css}"
	rel="stylesheet" />
<link th:href="@{/css/default.css}" rel="stylesheet" />
<style type="text/css">
		.layui-form{
			width: 50%;
			margin-left: 10%;
			margin-top: 5%;
		}
		.layui-input-block{
			margin-top: 50px;
		}
		
		#doctorName{
			position: relative;
  			left: -200px;
  			top: 20px;
		}
		
		#doctor_occupationId{
			position: relative;
  			top: -18px;
		}
	</style>
</head>
<body>
<br/>
<!-- 模糊查询start -->
	<form class="form-inline" role="form" action="">
		<div class="form-group" style="margin-left:600px;">
			<input type="text" class="layui-input" id="doctorName" name="doctorName" placeholder="请输入姓名"  autocomplete="off">
			<select id="doctor_occupationId" name="doctor_occupationId" class="layui-input">
	      		<option value= "8">护士</option>
	      	</select>
		</div>
		<input type="button" onclick="Fuzzyquery();"  value="查询" class="btn btn-success" style="margin-left:20px;">
	</form>
	<!-- 模糊查询end -->
<br/>
<table class="table table-bordered" >
	<tr style="text-align: center;">
		<td>编号</td>
		<td>姓名</td>
		<td>职业</td>
		<td>密码</td>
		<td>性别</td>
		<td>地址</td>
		<td colspan="2" style="text-align: center;">操作</td>
	</tr>
	<c:forEach var="nurse" items="${nurselist }">
		<tr style="text-align: center;">
			<td>${nurse.doctorCode }</td>
			<td>${nurse.doctorName }</td>
			<td>${nurse.occupation.occupationName }</td>
			<td>${nurse.doctorPassword }</td>
			<c:if test="${nurse.doctorSex == 1 }">
				<td>男</td>
			</c:if>
			<c:if test="${nurse.doctorSex == 2 }">
				<td>女</td>
			</c:if>
			<td>${nurse.doctorAddress }</td>
			<td><input type="button" onclick="update(${nurse.doctorId})" value="修改" class="layui-btn"></td>
			<td><input type="button" onclick="dele(${nurse.doctorId})" value="删除" class="layui-btn"></td>
		</tr>
	</c:forEach>
	
</table>
	<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		function dele(doctorId) {
			alert(doctorId);
			var $dele = confirm("确定要删除吗?");
			if ($dele == true) {
				$.ajax({
					url : "deletenurse",
					type : "post",
					data : {
						"doctorId" : doctorId
					},
					dataType : "json",
					success : function callBack(data) {
						var result = data[0].result;
						if (result == "1") {
							alert("删除成功!");
							location.href = "welcome";
						} else {
							alert("删除失败!");
						}
					},
					error : function err() {
						alert("删除信息请求失败");
					}
				});
			}
		}
		
		function update(doctorId){
			location.href = "updatenurse?doctorId=" + doctorId;
		}
		
		function Fuzzyquery(){
			var doctor_powerId = ${doctor_powerIdFour};
			var doctorName = $("#doctorName").val();
			var doctor_occupationId = $("#doctor_occupationId").val();
			/* alert(doctor_powerId)
			alert(doctorName)
			alert(doctor_occupationId) */
			location.href="FuzzyqueryNurse?doctor_powerId=" + doctor_powerId + "&doctorName=" + doctorName + "&doctor_occupationId=" + doctor_occupationId;
		}
	</script>

</body>
</html>
