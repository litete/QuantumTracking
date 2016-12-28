<%@ page language="java" import="java.util.*, app.home.model.*"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("UserInfo");
	if (user == null) {
%>
	<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>