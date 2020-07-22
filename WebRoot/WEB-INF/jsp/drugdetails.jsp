<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>药品明细查看管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="static/layui/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
<style type="text/css">
.layui-table {
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
</head>
<body>
	<br>
	<br/>
	<br/>
	<table class="table table-bordered">
		<tr>
			<td style="width: 230px;">名称</td>
			<td>${drugdetails.drugDetailsName }</td>
		</tr>
		<tr>
			<td style="width: 230px;">主治功能</td>
			<td>${drugdetails.drugDetailsDescribe}</td>
		</tr>
		<tr>
			<td style="width: 230px;">购买时间</td>
			<td><fmt:formatDate value="${drugdetails.drugDetailsTime }" pattern="yyyy年MM月dd日"/></td>
		</tr>
	</table>
	<div style="text-align: center;">
		<input type="button" onclick="update(${drugdetails.drugDetailsId});" value="修改"class="layui-btn" >
		<input type="button" onclick="dele(${drugdetails.drugDetailsId})" value="删除" class="layui-btn" >
		<input type="button" onclick="javascript:history.go(-1);" value="回退" class="layui-btn" >
	</div>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function update(drugDetailsId){
		location.href= "updatedrugdetails?drugDetailsId=" + drugDetailsId;
	}


	function dele(drugDetailsId) {
		var $dele = confirm("确定要删除吗?");
		if ($dele == true) {
			$.ajax({
				url : "deleteDrugDetails",
				type : "post",
				data : {
					"drugDetailsId" : drugDetailsId
				},
				dataType : "json",
				success : function callBack(data) {
					var result = data[0].result;
					if (result == "1") {
						alert("删除成功!");
						location.href = "hrefdrugs";
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
</script>
</body>
</html>
