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
<link type="text/css" rel="stylesheet" href="AppWeb/css/style_copy.css" />

<link rel="apple-touch-icon" href="AppWeb/img/apple-touch-icon.png">
<link rel="apple-touch-startup-image"
	href="AppWeb/img/apple-touch-startup-image.png">
<!--日期css  -->
<link rel="stylesheet" type="text/css"
	href="AppWeb/css/datetime/jquery.datetimepicker.css" />
<!-- 城市css -->
<link href="AppWeb/css/city/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="AppWeb/css/city/city-picker.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="AppWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.mmenu.min.all.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="AppWeb/js/o-script.js"></script>
<!--  日期js-->
<script src="AppWeb/js/jquery.js"></script>
<script src="AppWeb/js/jquery.datetimepicker.js"></script>
<!--城市js  -->
<script src="AppWeb/js/city/jquery-1.12.1.min.js"></script>
<script src="AppWeb/js/city/bootstrap.min.js"></script>
<script src="AppWeb/js/city/city-picker.data.js"></script>
<script src="AppWeb/js/city/city-picker.js"></script>
<script src="AppWeb/js/city/main.js"></script>
</head>
<body class="o-page">
	<div id="page">
		<div id="header">
			<div class="header-content">
				<a href="AppWeb/index.jsp" class="p-link-home"><i class="fa fa-home"></i></a>
				<a class="menu-btn" href="#menu"></a> 
				<a href="javascript:history.back();" class="p-link-back"><i class="fa fa-arrow-left"></i></a>
			</div>
		</div>
		<div id="content">

			<article>
			<!-- localhost -->
				<img src="http://120.27.7.106:80/FiveA/images/${info.img}" />
				<h2>
					<a href="">${info.cook_name}</a>
				</h2>
				<p>
					<span class="c-red">提供酒店：</span>${info.from_gs}<br>
					${info.info}
				</p>
				<div class="a-meta a-meta-left">￥${info.price}</div>
				<div class="article-comments">
					<form id="contact" class="contactForm form-inline" method="post"
						action="<%=request.getContextPath()%>/findcook/addinfo.do" name="form1">
						<input type="hidden" name="ordernum" value="" id="orderId">
						<input type="hidden" name="taocan" value="${info.cook_name}">
						<input type="hidden" name="ordertime" id="dateId" value="">
						<input type="hidden" name="buy_zhuangtai"  value="未确认">
						<label> 姓名 <span class="required">*</span></label> 
						<input type="text" name="name" id="ContactName" placeholder="姓名 ">
						<label>电话 <span class="required">*</span></label> 
						<input type="tel" name="phonenum" id="ContactEmail" placeholder="电话">
						<label>地址 <span class="required">*</span></label> 
						<input type="text" name="street" id="" placeholder="详细地址">
						<div style="position: relative;">
							<input id="city-picker3" class="form-control city-picker-input"
								readonly="" type="text" value="" data-toggle="city-picker" name="city">
						</div>
						<label>用餐时间 <span class="required">*</span></label> <input
							type="text" value="" id="datetimepicker4" name="eattime"/> <label>备注<span
							class="required">*</span></label>
						<textarea id="ContactMessage" name="beizhu"
							placeholder="您还有什么要嘱咐厨师的？"></textarea>
						<input type="button" onclick="check()" style="margin-top: 20px" class="btn-normal"
							id="SubmitContact" value="提交订单">
						<div id="msg" class="notifications" style="display:none"></div>
					</form>
				</div>
			</article>
		</div>
		<div class="subFooter">Copyright 2016. All rights reserved.</div>

		<!-- Menu navigation -->
		<nav id="menu">
			<ul>
				<li><a href="AppWeb/index.jsp"> <i class="fa fa-home"></i>首页
				</a></li>
				<li class="Selected"><a href="AppWeb/findcook.jsp"> <i
						class="fa fa-pencil-square-o"></i>找厨师
				</a></li>
				<li><a href="AppWeb/food.jsp"> <i class="fa fa-th-list"></i>美食街
				</a></li>
			</ul>
		</nav>
	</div>
</body>
<!--  日期js-->
<script src="AppWeb/js/jquery-datetime.js"></script>
<script src="AppWeb/js/jquery.datetimepicker.js"></script>
<script>
	$('#datetimepicker4').datetimepicker();
</script>
<script>
	var date = new Date();
	var mon = date.getMonth() + 1;
	var day = date.getDate();
	var nowDay = date.getFullYear() + "-" + (mon<10?"0"+mon:mon) + "-" +(day<10?"0"+day:day);
	document.getElementById("dateId").value=nowDay;
	document.getElementById("orderId").value=date.getTime();
</script>
<script type="text/javascript">
	function check() {
		var name = form1.name.value;
		var phonenum = form1.phonenum.value;
		var street = form1.street.value;
		var city = form1.city.value;
		var eattime = form1.eattime.value;
		if (name == "") {
			alert("输一下您的姓名吧！");
		} else if (phonenum == "") {
			alert("是不是忘了写电话号码了？");
		} else if (street == "") {
			alert("不输地址我就找不到您家啦~\(≧▽≦)/~");
		} else if (city == "") {
			alert("要输入全部的地址才可以下单的呦！！");
		} else if (eattime == "") {
			alert("时间也要输一下的呦~~~");
		} else {
			form1.submit();
		}
	}
</script>
</html>