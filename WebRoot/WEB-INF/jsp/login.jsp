<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- <title>love</title> -->
<title>love</title>
<link href="favicon.ico" rel="shortcut icon" />
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<!-- <body style=" background: url(static/img/3DB3B3E17F23702750E1894B8AFC3478.jpg) no-repeat center center fixed; background-size: 100%;"> -->
<body style=" background: url(static/img/7CA0C065BFFF3CF1A717FB7F222CE5D1.jpg) no-repeat center center fixed; background-size: 100%;">
	<!-- http://global.bing.com/az/hprichbg/rb/RavenWolf_EN-US4433795745_1920x1080.jpg -->
	<div class="modal-dialog" style="margin-top: 10%;">
	<!-- 登录action -->
	<form action="dologin" method="get">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title text-center" id="myModalLabel">医院管理简易登录</h4>
			</div>
			<div class="modal-body" id="model-body">
				<div class="form-group">

					<input type="text" class="form-control" placeholder="用户名" autocomplete="off" name="doctorCode">
				</div>
				<div class="form-group">

					<input type="password" class="form-control" placeholder="密码" autocomplete="off" name="doctorPassword">
				</div>
			</div>
			<div class="modal-footer">
				<div class="form-group">
					<button type="submit" class="btn btn-primary form-control">登录</button>
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-default form-control">注册</button>
				</div>

			</div>
		</div>
		<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal -->
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		if (window.history && window.history.pushState) {
			$(window).on('popstate', function() {
				window.history.pushState('forward', null, 'index');
				window.history.forward(1);
			});
		}
		window.history.pushState('forward', null, 'index'); //在IE中必须得有这两行
		window.history.forward(1);
	})
</script>
</body>
</html>
