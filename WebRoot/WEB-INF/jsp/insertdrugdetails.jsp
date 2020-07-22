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
	<title>增加药品信息</title>
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
	    <label class="layui-form-label">药品名称</label>
	    <div class="layui-input-block">
	      <input type="text" id="drugDetailsName" name="drugDetailsName" required  lay-verify="required" value="" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
		</div>
	 </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">药品描述</label>
	    <div class="layui-input-block">
	      <input type="text" id="drugDetailsDescribe" name="drugDetailsDescribe" required lay-verify="required" value="" placeholder="请输入药品描述" autocomplete="off" class="layui-input">
	   	</div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">购买时间</label>
	    <div class="layui-input-block">
	      <input type="text" id="drugDetailsTime" name="drugDetailsTime" required  lay-verify="required" value="" placeholder="请输入购买时间" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">药品分类</label>
	    <div class="layui-input-block">
	      	<select id="drugDetails_DrugsId" name="drugDetails_DrugsId" >
	      		<option value= 0>--请选择存放分类--</option>
	      		<c:forEach var="durgs" items="${durgslist }">
	      			<option value="${durgs.drugsId }">${durgs.drugsName }</option>
	      		</c:forEach>
	      	</select>
	    </div>
	  </div>
	 <div class="layui-form-item">
	    <div class="layui-input-block">
	      <input type="button" class="layui-btn" lay-submit lay-filter="formDemo" onclick="check();" value="立即提交">
	      <span class="blank"></span>
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
	function check() {
		//名称
		var drugDetailsName = $("#drugDetailsName").val();
		//描述
		var drugDetailsDescribe = $("#drugDetailsDescribe").val();
		//购买时间
		var drugDetailsTime = $("#drugDetailsTime").val();
		//分类
		var drugDetails_DrugsId = $("#drugDetails_DrugsId").val();
		if (drugDetailsName == null || drugDetailsName == "") {
			alert("药品名称不能为空");
			return false;
		} else if (drugDetailsDescribe == null || drugDetailsDescribe == "") {
			alert("药品描述不能为空");
			return false;
		} else if (drugDetailsTime == null || drugDetailsTime == "") {
			alert("购买药品时间不能为空");
			return false;
		} else if (drugDetails_DrugsId == "0") {
			alert("请将药品存放在适当的分类下,以便下次查找");
			return false;
		} else {
			//ajax验证
			$.ajax({
				url : "insertDrugDeails",
				type : "post",
				data : {
					"drugDetailsName" : drugDetailsName,
					"drugDetailsTime" : drugDetailsTime,
					"drugDetailsDescribe" : drugDetailsDescribe,
					"drugDetails_DrugsId" : drugDetails_DrugsId
				},
				dataType : "json",
				success : function callBack(data) {
					var result = data[0].result;
					if (result == "1") {
						alert("添加成功!");
						location.href = "hrefdrugs";
					} else {
						alert("添加失败!");
					}
				},
				error : function err() {
					alert("添加信息请求失败");
				}
			});
		}
	}
</script>
</body>