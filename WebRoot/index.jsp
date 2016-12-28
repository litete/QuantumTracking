<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>5A厨房管理系统</title>
<meta name="Keywords" content="5A厨房后台系统" />
<%@ include file="App/Common/Common/intoHead.jsp"%>
<script src="Public/Js/uploadPreview.js"></script>
</head>
<jsp:include page="App/Admin/User/islogin.jsp"></jsp:include>
<body>
	<%@ include file="App/Common/Common/header.jsp"%>

	<div id="bjui-container" class="clearfix">
		<%@ include file="App/Common/Common/leftMenu.jsp"%>

		<div id="bjui-navtab" class="tabsPage">
			<div class="tabsPageHeader">
				<div class="tabsPageHeaderContent">
					<ul class="navtab-tab nav nav-tabs">
						<li data-url=""><a href="javascript:;"><span><i
									class="fa fa-home"></i> #maintab#</span></a></li>
					</ul>
				</div>
				<div class="tabsLeft">
					<i class="fa fa-angle-double-left"></i>
				</div>
				<div class="tabsRight">
					<i class="fa fa-angle-double-right"></i>
				</div>
				<div class="tabsMore">
					<i class="fa fa-angle-double-down"></i>
				</div>
			</div>
			<ul class="tabsMoreList">
				<li><a href="javascript:;">#maintab#</a></li>
			</ul>

			<div class="navtab-panel tabsPageContent">
				<div class="navtabPage unitBox">
					<div class="bjui-pageHeader" style="background:#FFF;">
						<div style="padding: 0 15px;">
							<div class="row">
								<div class="col-md-4">
									<h5>
									<!--
										项目GIT：<a href="http://git.oschina.net/xvpindex/ewsdOA"
											target="_blank">http://git.oschina.net/xvpindex/ewsdOA</a>
									-->
									</h5>
								</div>
								<div class="col-md-4">
									<h5>
										<!--技术博客：<a href="http://www.topstack.cn" target="_blank">http://www.topstack.cn</a>-->
										欢迎使用5A厨房后台管理系统
									</h5>
								</div>
								<div class="col-md-4">
									<!--<h5>联系方式：xvpindex@qq.com</h5>-->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="App/Common/Common/footer.jsp"%>
</body>
</html>