<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="../../../../maps.google.com/maps/api/js@sensor=false"></script>
<script type="text/javascript" src="AppWeb/js/gmap3.min.js"></script>
<script type="text/javascript" src="AppWeb/js/o-script.js"></script>

</head>
<body class="o-page p-contact">
	<div id="page">
		<div id="header">
			<div class="header-content">
				<a href="AppWeb/index.jsp" class="p-link-home"><i
					class="fa fa-home"></i></a> <a class="menu-btn" href="#menu"></a> <a
					href="javascript:history.back();" class="p-link-back"><i
					class="fa fa-arrow-left"></i></a>
			</div>
		</div>
		<div class="bannerPane" style="height:300px">
			<div id="map" style="width:100%; height:300px;"></div>
			<div class="s-banner-content">
				<div>
					<img width="100" src="AppWeb/img/logo-pages.svg" />
				</div>
			</div>
		</div>
		<!-- MAP -->

		<div id="content">
			<h3 class="title">
				<i class="fa fa-exclamation-circle"></i>&nbsp下单成功
			</h3>
			<div class="contactForm">
				<a href="AppWeb/index.jsp"><Button id=""
						style="background: red; font-size: 20px;">回到首页</Button></a>
			</div>
		</div>
		<nav id="menu">
			<ul>
				<li><a href="AppWeb/index.jsp"> <i class="fa fa-home"></i>首页
				</a></li>
				<li><a href="<%=basePath%>cook/allAppWeb.do"> <i
						class="fa fa-picture-o"></i>找厨师
				</a></li>
				<li><a href="<%=basePath%>veg/allAppWeb.do"> <i class="fa fa-th-list"></i>美食街
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>
