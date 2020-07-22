<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
table td:nth-child(1)>p {
	width: 20px;
	display: inline-block;
	writing-mode: vertical-rl;
	-webkit-writing-mode: vertical-rl;
	-ms-writing-mode: vertical-rl;
}
</style>
</head>
<body>
<br>
<div class="layui-btn-group demoTable">
  <span style="margin-left:10px;"></span>
  <button class="layui-btn" data-type="checkname">模糊查询</button>
</div>  
<br/>
<br/>
<table class="table table-bordered" style="text-align: center;">
	<tr style="text-align: center;">
		<td style="width: 200px">药品分类名称</td>
		<td style="width: 200px">药品分类描述</td>
		<td colspan="3" style="text-align: center; width:50px;">操作</td>
	</tr>
	<c:forEach var="drugs" items="#{drugslist }">
		<tr>
			<td style="vertical-align: middle; width: 200px">${drugs.drugsName }</td>
			<td style="vertical-align: middle; width: 200px">
				<c:forEach var="drugDetails" items="${drugs.drugDetailsList }">
					<p><a href="hrefdrugdetails?drugDetailsId=${drugDetails.drugDetailsId}">${drugDetails.drugDetailsName }</a></p>
				</c:forEach>
			</td>
			<td style="vertical-align: middle; width: 50px;"><input type="button" onclick="error();" value="调整药品分类" class="layui-btn"/></td>
			<td style="vertical-align: middle; width: 50px;"><input type="button" onclick="error();" value="删除药品分类" class="layui-btn"/></td>
		</tr>
	</c:forEach>
	
</table>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function error(){
		alert("(っ´Ι`)っ求求你别点了,按照医院规定,不得调整或删除药品分类");
		return false;
	}
	
</script>


 
<!--<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  <a class="layui-btn layui-btn-warm  layui-btn-xs" lay-event="edit">修改</a>
</script>-->
               
          
<!-- <script src="static/layui/layui.js" charset="utf-8"></script>
注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的
<script>
layui.use(['table','layer'], function(){
  var table = layui.table
  ,layer = layui.layer
  ,$ = layui.$;
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
    	window.location.href="deltea?id="+data.id+"";
    } else if(obj.event === 'edit'){
    	window.location.href="hrefxiutea?id="+data.id+"";
    }
  });
  var $ = layui.$, active = {
    checkname: function(){ //弹出对话框
    	layer.prompt({title:'请输入名字的一部分'},function(value){
    		window.location.href="hrefmohunametea?teaname="+value+""; 
    	});
    }
  };	
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});
</script> -->

</body>
</html>
