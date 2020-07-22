<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!--截取项目的名称  -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改一名医生</title>
	<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
	<style type="text/css">
		.layui-form{
			width: 50%;
			margin-left: 10%;
			margin-top: 5%;
		}
		.layui-input-block{
			margin-top: 50px;
		}
		.blank{
			margin-left: 50%;
		}
	</style>
</head>
<body>
	<form class="layui-form">
	  <div class="layui-form-item">
	    <label class="layui-form-label">编号</label>
	    <div class="layui-input-block">
	      <input type="text" id="doctorCode" name="doctorCode" required  lay-verify="required" value="${doctor.doctorCode }" placeholder="请输入编号" autocomplete="off" class="layui-input">
		</div>
	 </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-inline">
	      <input type="text" id="doctorName" name="doctorName" required lay-verify="required" value="${doctor.doctorName }" placeholder="请输入姓名" autocomplete="off" class="layui-input">
	   	</div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码</label>
	    <div class="layui-input-block">
	      <input type="text" id="doctorPassword" name="doctorPassword" required  lay-verify="required" value="${doctor.doctorPassword }" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	 <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	     	 男<input type="radio" id="doctorSex" name="sex" value="1" class="layui-input" <c:if test="${doctor.doctorSex == 1 }">checked="checked"</c:if>>
	    	 女<input type="radio" id="doctorSex" name="sex" value="2" class="layui-input" <c:if test="${doctor.doctorSex == 2 }">checked="checked"</c:if>>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">地址</label>
	    <div class="layui-input-block">
	      <input type="text" id="doctorAddress" name="doctorAddress" value="${doctor.doctorAddress }" required  lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">权限</label>
	    <div class="layui-input-block">
	      	<select id="doctor_powerId" name="doctor_powerId">
	      		<option value=0>--请选择权限--</option>
	      		<c:forEach var="power" items="${power }">
	      			<option value="${power.powerId }" ${power.powerId == doctor.doctor_powerId ? 'selected' :''   }>${power.powerName }</option>
	      		</c:forEach>
	      	</select>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">职业</label>
	    <div class="layui-input-block">
	      	<select id="doctor_occupationId" name="doctor_occupationId" >
	      		<option value= 0>--请选择职业--</option>
	      		<c:forEach var="occupation" items="${occupation }">
	      			<option value="${occupation.occupationId }" ${occupation.occupationId == doctor.doctor_occupationId ? 'selected' :''   }>${occupation.occupationName }</option>
	      		</c:forEach>
	      	</select>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">科室</label>
	    <div class="layui-input-block">
	      	<select id="doctor_departmentId" name="doctor_departmentId" >
	      		<option value= 0>--请选择科室--</option>
	      		<c:forEach var="department" items="${department }">
	      			<option value="${department.departmentId }" ${department.departmentId == doctor.doctor_departmentId ? 'selected' :''   }>${department.departmentName }</option>
	      		</c:forEach>
	      	</select>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <input type="button" class="layui-btn" lay-submit lay-filter="formDemo" onclick="check(${doctor.doctorId});" value="立即提交">
	      <input type="button" class="layui-btn" lay-submit lay-filter="formDemo" onclick="javascript:history.go(-1);" value="回退">
	      <input type="reset" class="layui-btn" lay-submit lay-filter="formDemo" onclick="" value="重置">
	    </div>
	  </div>
	</form>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
});
</script>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function check(doctorId){
		//编号
		var doctorCode = $("#doctorCode").val();
		//姓名
		var doctorName = $("#doctorName").val();
		//密码
		var doctorPassword = $("#doctorPassword").val();
		//性别
		var doctorSex = $('input[type="radio"]:checked').val();
		//地址
		var doctorAddress = $("#doctorAddress").val();
		//权限
		var doctor_powerId = $("#doctor_powerId").val();
		//职业
		var doctor_occupationId = $("#doctor_occupationId").val();
		//科室
		var doctor_departmentId = $("#doctor_departmentId").val();
		//非空判断
		/* alert(doctorCode);
		alert(doctorName);
		alert(doctorPassword);
		alert(doctorSex);
		alert(doctorAddress);
		alert(doctor_powerId);
		alert(doctor_occupationId);
		alert(doctor_departmentId); */
		if(doctorCode == null || doctorCode == ""){
			alert("编号不能为空");
			return false;
		}else if(doctorName == null || doctorName == ""){
			alert("姓名不能为空");
			return false;
		}else if(doctorPassword == null || doctorPassword == ""){
			alert("密码不能为空");
			return false;
		}else if(doctorSex == null ){
			alert("选择性别");
			return false;
		}else if(doctorAddress == null || doctorAddress == ""){
			alert("地址不能为空");
			return false;
		}else if(doctor_powerId == "0"){
			alert("请选择一种权限");
			return false;
		}else if(doctor_occupationId == "0"){
			alert("请为选填写的用户分分配职业");
			return false;
		}else if(doctor_departmentId == "0"){
			alert("请为选填写的用户分配科室");
			return false;
		}else{
			//ajax验证
			$.ajax({
				url						:		"updateDoctor",
				type					:		"post",
				data					:		{
					"doctorId"				:			doctorId,
					"doctorCode"			:			doctorCode,
					"doctorName"		    :			doctorName,
					"doctorPassword"		:			doctorPassword,
					"doctorSex" 			:			doctorSex,
					"doctorAddress"			:			doctorAddress,
					"doctor_powerId"		:			doctor_powerId,
					"doctor_occupationId"	:			doctor_occupationId,
					"doctor_departmentId"	:			doctor_departmentId
					
				},
				dataType				:		"json",
				success					:		function(data) {
						var result = data[0].result;
						if (result == "1") {
							alert("修改信息成功!");
							document.location= "hrefdoctor?doctor_powerId=${doctor_powerIdTow}"
						}else{
							alert("修改信息失败!");
						}
				},
				error					:		function(){
					alert("修改信息发生错误!");
				}	
			});
		}
	}
</script>
