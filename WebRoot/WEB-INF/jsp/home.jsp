<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>医院信息管理</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet" href="static/layui/css/layui.css">
		<link rel="stylesheet" href="static/css/font.css">
        <link rel="stylesheet" href="static/css/xadmin.css">
        <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
        <script src="static/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="static/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
             //是否开启刷新记忆tab功能
             var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="index">医院信息管理</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item" style="margin-right: 30px;">
                 	<span>欢迎您</span>	<span style="color:red">${doctor.doctorName }</span>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="index">退出</a>
                </li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
		<div class="left-nav">
            <div id="side-nav">
				<ul id="nav">
					<li>
						<a href="javascript:;"> 
							<i class="iconfont left-nav-li" lay-tips="医生管理">&#xe6b8;</i> 
								<cite>医生管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a onclick="xadmin.add_tab('增加医生','insertdoctor')"> 
									<i class="iconfont">&#xe6a7;</i> 
										<cite>增加医生</cite>
								</a>
							</li>
							<li>
								<a onclick="xadmin.add_tab('医生信息','hrefdoctor?doctor_powerId=${doctor_powerIdTow}')">
									<i class="iconfont">&#xe6a7;</i> 
									<cite>管理医生</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;"> 
							<i class="iconfont left-nav-li" lay-tips="护士管理">&#xe723;</i> 
								<cite>护士管理</cite> 
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a onclick="xadmin.add_tab('增加护士','insertnurse')"> 
									<i class="iconfont">&#xe6a7;</i> 
										<cite>增加护士</cite>
								</a>
							</li>
							<li>
								<a onclick="xadmin.add_tab('护士信息','hrefnurse?doctor_powerId=${doctor_powerIdFour}')">
									<i class="iconfont">&#xe6a7;</i> 
										<cite>管理护士</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;"> 
							<i class="iconfont left-nav-li" lay-tips="病人管理">&#xe723;</i> 
								<cite>病人管理</cite> 
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a onclick="xadmin.add_tab('增加病人','insertpatient?doctor_powerId=${doctor_powerId}')"> 
									<i class="iconfont">&#xe6a7;</i> 
										<cite>增加病人</cite>
								</a>
							</li>
							<li>
								<a onclick="xadmin.add_tab('病人信息','hrefpatient?doctor_powerId=${doctor_powerId}')">
									<i class="iconfont">&#xe6a7;</i> 
										<cite>管理病人</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;"> 
							<i class="iconfont left-nav-li" lay-tips="药品管理">&#xe723;</i> 
								<cite>药品管理</cite> 
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a onclick="xadmin.add_tab('增加药品','insertdrugdetails')"> 
									<i class="iconfont">&#xe6a7;</i> 
										<cite>增加药品</cite>
								</a>
							</li>
							<li>
								<a onclick="xadmin.add_tab('药品信息','hrefdrugs')">
									<i class="iconfont">&#xe6a7;</i> 
										<cite>管理药品</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="index"> 
							<i class="iconfont left-nav-li" lay-tips="退出系统">&#xe723;</i> 
								<cite>退出系统</cite> 
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
					</li>
				</ul>
			</div>
        </div>
	<div class="x-slide_left"></div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home">
					<i class="layui-icon">&#xe68e;</i>我的桌面
				</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<!-- 路径跳转,显示首页信息 -->
					<iframe src='welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
	<script type="text/javascript">
		$(function() {
			if (window.history && window.history.pushState) {
				$(window).on('popstate', function() {
					window.history.pushState('forward', null, 'dologin');
					window.history.forward(1);
				});
			}
			window.history.pushState('forward', null, 'dologin'); //在IE中必须得有这两行
			window.history.forward(1);
		})
	</script>
    </body>
</html>