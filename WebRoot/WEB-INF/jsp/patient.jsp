<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>医生管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style type="text/css">
		.layui-form{
			width: 50%;
			margin-left: 10%;
			margin-top: 5%;
		}
		.layui-input-block{
			margin-top: 50px;
		}
		
		#patientName{
			position: relative;
  			left: -200px;
  			top: 20px;
		}
		
		#patient_doctorId{
			position: relative;
  			top: -18px;
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
</head>
<body>
<br/>
<!-- 模糊查询start -->
	<form class="form-inline" role="form" action="">
		<div class="form-group" style="margin-left:600px;">
			<input type="text" class="layui-input" id="patientName" name="patientName" placeholder="请输入姓名"  autocomplete="off">
			<select id="patient_doctorId" name="patient_doctorId" class="layui-input">
	      		<option value= 0 >--请选择医生--</option>
	      		<c:forEach var="doctor" items="${doctorlist }">
	      			<option value="${doctor.doctorId }">${doctor.doctorName }</option>
	      		</c:forEach>
	      	</select>
		</div>
		<input type="button" onclick="Fuzzyquery();"  value="查询" class="btn btn-success" style="margin-left:20px;">
	</form>
	<!-- 模糊查询end -->
<br/>
<table class="table table-bordered" >
	<tr style="text-align: center;">
		<td>姓名</td>
		<td>性别</td>
		<td>年龄</td>
		<td>病情描述</td>
		<td>主治医生</td>
		<td colspan="2" style="text-align: center;">操作</td>
	</tr>
	<c:forEach var="patient" items="${patientlist }">
		<tr style="text-align: center;">
			<td>${patient.patientName }</td>
			<c:if test="${patient.patientSex == 1 }">
				<td>男</td>
			</c:if>
			<c:if test="${patient.patientSex == 2 }">
				<td>女</td>
			</c:if>
			<td>${patient.patientAge }</td>
			<td>${patient.patientDescribe }</td>
			<td>${patient.doctor.doctorName }</td>
			<td><input type="button" onclick="update(${patient.patientId},${doctor_powerId })" value="调整" class="layui-btn"></td>
			<td><input type="button" onclick="dele(${patient.patientId})" value="出院" class="layui-btn"></td>
		</tr>
	</c:forEach>
	
</table>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js" ></script>
<script type="text/javascript">
	function update(patientId,doctor_powerId){
		document.location= "updatepatient?patientId=" + patientId+"&doctor_powerId=" + ${doctor_powerId};
	}
	
	
	function dele(patientId) {
			var $dele = confirm("该病人已经痊愈,是否办理出院手续?");
			if ($dele == true) {
				$.ajax({
					url : "deletePatient",
					type : "post",
					data : {
						"patientId" : patientId
					},
					dataType : "json",
					success : function callBack(data) {
						var result = data[0].result;
						if (result == "1") {
							alert("出院手续办理成功!");
							location.href = "hrefpatient";
						} else {
							alert("出院手续办理失败!");
						}
					},
					error : function err() {
						alert("删除信息请求失败");
					}
				});
			}
		}
		
		function Fuzzyquery(){
			var doctor_powerId = ${doctor_powerId};
			var patientName = $("#patientName").val();
			var patient_doctorId = $("#patient_doctorId").val();
			location.href="FuzzyQueryPatient?doctor_powerId=" + doctor_powerId + "&patientName=" + patientName + "&patient_doctorId=" + patient_doctorId;
		}
</script>


 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  <a class="layui-btn layui-btn-warm  layui-btn-xs" lay-event="edit">修改</a>
</script>


</body>
</html>
