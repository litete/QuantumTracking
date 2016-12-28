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
<meta name="author" content="www.lanrenmb.com" />
<meta name="viewport"
	content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />

<title>5A厨房</title>
<link href="AppWeb/img/favicon.ico" rel="shortcut icon"
	type="image/x-icon">

<link type="text/css" rel="stylesheet"
	href="AppWeb/css/jquery.mmenu.all.css" />
<link type="text/css" rel="stylesheet" href="AppWeb/css/style.css" />
<link rel='stylesheet' id='camera-css' href='AppWeb/css/camera.css'
	type='text/css' media='all'>

<link rel="apple-touch-icon" href="AppWeb/img/apple-touch-icon.png">
<link rel="apple-touch-startup-image"
	href="AppWeb/img/apple-touch-startup-image.png">

<script type="text/javascript" src="AppWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.mmenu.min.all.js"></script>
<script type="text/javascript" src="AppWeb/js/o-script.js"></script>

<script type='text/javascript'
	src='AppWeb/js/slider/jquery.mobile.customized.min.js'></script>
<script type='text/javascript'
	src='AppWeb/js/slider/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='AppWeb/js/slider/camera.min.js'></script>

<script>
	jQuery(function() {

		jQuery('#camera_wrap_4').camera({
			height : 'auto',
			loader : 'bar',
			pagination : false,
			thumbnails : false,
			hover : false,
			opacityOnGrid : false
		});

	});
</script>
</head>
<body class="o-page p-home">
	<div id="page">
		<!-- Header -->
		<div id="header">
			<div class="header-content">
				<a class="menu-btn" href="#menu"></a> 
				<a
					href="javascript:history.back();" class="p-link-back"><i
					class="fa fa-arrow-left"></i></a>
			</div>
		</div>
		<!-- Content -->
		<div id="content">
			<div class="home-content">
				<span id="Logo" class="svg"> <img src="AppWeb/img/logo.svg" />
				</span>
			</div>
			<div class="fluid_container">
				<div class="camera_wrap camera_black_skin camera_emboss pattern_1"
					id="camera_wrap_4">
					<div data-thumb="img/gallery/1-th.jpg"
						data-src="AppWeb/img/gallery/1.jpg">
						<div class="bannerContent fadeFromBottom">
							<div class="b-c-textpane">
								<h1>9.95$</h1>
								<p>Lorem ipsum sit dolor</p>
							</div>
						</div>
					</div>
					<div data-thumb="img/gallery/2-th.jpg"
						data-src="AppWeb/img/gallery/2.jpg">
						<div class="bannerContent fadeFromBottom">
							<div class="b-c-textpane">
								<h1>3.95$</h1>
								<p>Lorem ipsum sit dolor</p>
							</div>
						</div>
					</div>
					<div data-thumb="img/gallery/3-th.jpg"
						data-src="AppWeb/img/gallery/3.jpg">
						<div class="bannerContent fadeFromBottom">
							<div class="b-c-textpane">
								<h1>19.95$</h1>
								<p>Lorem ipsum sit dolor</p>
							</div>
						</div>
					</div>
				</div>
				<!-- #camera_wrap_3 -->

			</div>
			<!-- .fluid_container -->

			<!-- <a href="#" class="home-footer">
					About us
				</a> -->
		</div>

		<!-- Menu navigation -->
		<nav id="menu">
			<ul>
				<li class="Selected"><a href="AppWeb/index.jsp"> <i
						class="fa fa-home"></i>首页
				</a></li>
				<li><a href="<%=basePath%>cook/allAppWeb.do"> <i class="fa fa-credit-card"></i>找厨师
				</a>
				<li><a href="<%=basePath%>veg/allAppWeb.do"> <i class="fa fa-th-list"></i>美食街
				</a></li>
			</ul>
		</nav>

	</div>
</body>
</html>