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
	<title>增加一名病人</title>
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
	    <label class="layui-form-label">姓名</label>
	    <div class="layui-input-block">
	      <input type="text" id="patientName" name="patientName" required  lay-verify="required" value="${patient.patientName }" placeholder="请输入姓名" autocomplete="off" class="layui-input">
		</div>
	 </div>
	 <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	     	 男<input type="radio" id="patientSex" name="sex" value="1" class="layui-input" <c:if test="${patient.patientSex == 1 }">checked="checked"</c:if>>
	    	 女<input type="radio" id="patientSex" name="sex" value="2" class="layui-input" <c:if test="${patient.patientSex == 2 }">checked="checked"</c:if>>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">年龄</label>
	    <div class="layui-input-block">
	      <input type="text" id="patientAge" name="patientAge" value="${patient.patientAge }" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">病情描述</label>
	    <div class="layui-input-block">
	      	<input type="text" id="patientDescribe" name="patientDescribe" value="${patient.patientDescribe }" required  lay-verify="required" placeholder="请输入病情问题" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">主治医生</label>
	    <div class="layui-input-block">
	      	<select id="patient_doctorId" name="patient_doctorId" >
	      		<option value= 0 >--请选择医生--</option>
	      		<c:forEach var="doctor" items="${doctorlist }">
	      			<option value="${doctor.doctorId }" ${doctor.doctorId == patient.patient_doctorId ? 'selected' : ''}>${doctor.doctorName }</option>
	      		</c:forEach>
	      	</select>
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <input type="button" class="layui-btn" lay-submit lay-filter="formDemo" onclick="check();" value="立即提交">
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
	function check(){
		//姓名
		var patientName = $("#patientName").val();
		//性别
		var patientSex = $('input[type="radio"]:checked').val();
		//年龄
		var patientAge = $("#patientAge").val();
		//病情描述
		var patientDescribe = $("#patientDescribe").val();
		//医生
		var patient_doctorId = $("#patient_doctorId").val();
		if(patientName == null || patientName == ""){
			alert("姓名不能为空");
			return false;
		}else if(patientSex == null){
			alert("选择性别");
			return false;
		}else if(patientAge == null || patientAge == ""){
			alert("请填写年龄");
			return false;
		}else if(patientDescribe == null || patientDescribe == ""){
			alert("请填写病人病情描述");
			return false;
		}else if(patient_doctorId == "0"){
			alert("请为病人选择主治医生");
			return false;
		}else {
			//ajax验证
			$.ajax({
				url			:			"updatePatient",
				type		:			"post",
				data		:			{
					"patientId"			:		${patient.patientId},
					"patientName"		:		patientName,
					"patientSex"		:   	patientSex,
					"patientAge"		:		patientAge,
					"patientDescribe"	:		patientDescribe,
					"patient_doctorId"	:		patient_doctorId
				},
				dataType	:			"json",
				success		:			function callBack(data){
					var result = data[0].result;
						if (result == "1") {
							alert("调整信息成功!");
							document.location= "hrefpatient"
						}else{
							alert("调整信息失败!");
						}
				},
				error		:			function(){
					alert("修改信息发生错误!");
				}			 
			});
		}
	}
</script>
