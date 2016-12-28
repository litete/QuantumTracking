<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="content-type" content="text/html;charset=gbk" />
<meta name="author" content="www.frebsite.nl" />
<meta name="viewport"
	content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />

<title>5A厨房</title>
<link href="AppWeb/img/favicon.ico" rel="shortcut icon"
	type="image/x-icon">

<link type="text/css" rel="stylesheet"
	href="AppWeb/css/jquery.mmenu.all.css" />
<link type="text/css" rel="stylesheet" href="AppWeb/css/style.css" />

<link rel="apple-touch-icon" href="AppWeb/img/apple-touch-icon.png">
<link rel="apple-touch-startup-image"
	href="AppWeb/img/apple-touch-startup-image.png">

<script type="text/javascript" src="AppWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.mmenu.min.all.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="AppWeb/js/o-script.js"></script>
</head>
<body class="o-page p-blog">
	<div id="page">
		<div id="header">
			<div class="header-content">
				<a href="AppWeb/index.jsp" class="p-link-home"><i
					class="fa fa-home"></i></a> 
				<a class="menu-btn" href="#menu"></a>
				<a href="javascript:history.back();" class="p-link-back"><i
					class="fa fa-arrow-left"></i></a>
			</div>
		</div>
		<div class="bannerPane">
			<div class="overlay"></div>
			<div class="s-banner-content">
				<div>
					<img width="100" src="AppWeb/img/logo-pages.svg" />
				</div>
				找厨师
			</div>
		</div>
		<div id="content">
			<c:forEach var="list" items="${list}">
				<article>
					<a href="<%=basePath%>cook/info.do?id=${list.id}">
						<div class="article-img-pane">
						<!-- localhost -->
							<img src="http://120.27.7.106:80/FiveA/images/${list.img}" />
						</div>
						<h2>${list.cook_name}</h2>
						<p class="posts-summary">
							${list.info}<br>提供酒店：${list.from_gs}
						</p>
					</a>
					<div class="a-meta">
						<span><i class="fa "></i> ￥${list.price}元</span> <i class="fa"></i>
					</div>
				</article>
			</c:forEach>

		</div>
		<div class="subFooter">Copyright 2016. All rights reserved.</div>

		<!-- Menu navigation -->
		<nav id="menu">
			<ul>
				<li><a href="AppWeb/index.jsp"> <i class="fa fa-home"></i>首页
				</a></li>

				<li class="Selected"><a href="<%=basePath%>cook/allAppWeb.do">
						<i class="fa fa-pencil-square-o"></i>找厨师
				</a></li>
				<li><a href="<%=basePath%>veg/allAppWeb.do"> <i class="fa fa-th-list"></i>美食街
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>