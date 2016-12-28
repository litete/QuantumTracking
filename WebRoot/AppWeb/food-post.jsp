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

<script type="text/javascript" src="AppWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.mmenu.min.all.js"></script>
<script type="text/javascript" src="AppWeb/js/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="AppWeb/js/o-script.js"></script>
<!-- 城市css -->
<link href="AppWeb/css/city/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="AppWeb/css/city/city-picker.css" rel="stylesheet"
	type="text/css">
<!--城市js  -->
<script src="AppWeb/js/city/jquery-1.12.1.min.js"></script>
<script src="AppWeb/js/city/bootstrap.min.js"></script>
<script src="AppWeb/js/city/city-picker.data.js"></script>
<script src="AppWeb/js/city/city-picker.js"></script>
<script src="AppWeb/js/city/main.js"></script>
</head>
<body class="o-page p-product-single">
	<div id="page">
		<div id="header">
			<div class="header-content">
				<a href="AppWeb/index.jsp" class="p-link-home"><i
					class="fa fa-home"></i></a> <a href="javascript:history.back();"
					class="p-link-back"><i class="fa fa-arrow-left"></i></a>
			</div>
		</div>
		<div id="content">

			<article>
			<!--  localhost-->
				<img src="http://120.27.7.106:80/FiveA/images/${info.img}" width="360px" />
				<div class="prod-single-content-h">
					<div class="prod-pricePane">
						<span class="current-price">${info.price}</span> <span
							class="currency"><b>￥</b></span>
					</div>

					<div class="products-ratings">
						<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star-half-empty"></i>
					</div>
				</div>
				<div class="prod-single-content">
					<h2>
						<a href="#">${info.name}</a>
					</h2>
					<br />
					<p>${info.info}</p>
				</div>
				<div class="article-comments">
					<form id="contact" class="contactForm form-inline" method="post"
						action="<%=request.getContextPath()%>/vegorder/addinfo.do"
						name="form1">
						<input type="hidden" name="ordernum" id="orderId"> <input
							type="hidden" name="ordertime" id="dateId"> <input
							type="hidden" name="vegprice" id="" value="${info.price}">
						<input type="hidden" name="vegname" value="${info.name}">
						<input type="hidden" name="buy_zhuangtai" value="未确认"> <label>
							数量 <span class="required">*</span>
						</label> <input type="number" name="vegnum" id="ContactName"
							placeholder="数量 "> <label> 姓名 <span
							class="required">*</span></label> <input type="text" name="shouname"
							id="ContactName" placeholder="姓名 "> <label>电话 <span
							class="required">*</span></label> <input type="tel" name="shounumber"
							id="ContactPhone" placeholder="电话"> <label>地址 <span
							class="required">*</span></label> <input type="text" name="street"
							id="Street" placeholder="详细地址">
						<div style="position: relative;">
							<input id="city-picker3" class="form-control city-picker-input"
								readonly="dizhi" type="text" value="" data-toggle="city-picker"
								name="city">
						</div>
						<input type="button" onclick="check()" style="margin-top: 20px"
							class="btn-normal" id="SubmitContact" value="提交订单">
						<div id="msg" class="notifications" style="display:none"></div>
					</form>
				</div>
			</article>
		</div>
	</div>
</body>
<script>
	var date = new Date();
	var mon = date.getMonth() + 1;
	var day = date.getDate();
	var nowDay = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-"
			+ (day < 10 ? "0" + day : day);
	document.getElementById("dateId").value = nowDay;
	document.getElementById("orderId").value = date.getTime();
</script>
<script type="text/javascript">
	function check() {
		var vegnum = form1.vegnum.value;
		var shouname = form1.shouname.value;
		var shounumber = form1.shounumber.value;
		var street = form1.street.value;
		var city = form1.city.value;
		if (vegnum == "") {
			alert("亲，您还没有选好数量呦！");
		} else if (shouname == "") {
			alert("输一下您的姓名吧！");
		} else if (shounumber == "") {
			alert("是不是忘了写电话号码了？");
		} else if (street == "") {
			alert("不输地址我就找不到您家啦~\(≧▽≦)/~");
		} else if (city == "") {
			alert("要输入全部的地址才可以下单的呦！！");
		} else {
			form1.submit();
		}
	}
</script>
</html>