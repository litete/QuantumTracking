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
<style type="text/css">
.login {
	position: absolute;
	left: 50%;
	top: 50%;
	width: 450px;
	height: 330px;
	margin-left: -200px;
	margin-top: -150px;
	border: solid 1px #639663;
	padding: 25px 50px;
	border-radius:10px;
}
</style>
<script src="Public/Js/uploadPreview.js"></script>
</head>
<body>
	<div class="login">	
		<form action="<%=request.getContextPath()%>/user/login.do" data-toggle="validate" name="form1" method="post">
			<h3 style="text-align: center; border-bottom: solid 1px; padding-bottom: 10px; color: #639663">5A厨房后台管理系统</h3>
			<br>
			<p>
				<label class="x85">用户身份：</label><select name="role"
					data-rule="required" data-toggle="selectpicker">
					<option value="">请选择</option>
					<option value="a">管理员</option>
					<option value="b">项目负责人</option>
					<option value="c">执行人</option>
				</select>
			</p>
			<p>
				<label class="x85">登录名：</label><input type="text" name="username"
					data-rule="required" data-tip="你好啊，请填写用户名" data-ok="用户名可用"
					placeholder="登录名">
			</p>
			<p>
				<label class="x85">密码：</label><input type="password" name="pwd"
					data-rule="required;" placeholder="登录密码">
			</p>
			<p>
				<label class="x85">记住：</label><input type="checkbox" name="remember"
					value="true" id="doc-validate-remember" data-toggle="icheck"
					data-rule="checked" data-label="记住登陆信息">
			</p>
			<p>
			<hr>
			<p>
				<label class="x85"></label>
				<button type="submit" class="btn-default" onclick="check()">登&nbsp录</button>
			</p>
		</form>
	</div>
</body>
<script type="text/javascript">
	function check() {
		form1.submit();
	}
</script>
</html>
