<%@page import="me.codegc.manage.model.ModelObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<%
	ModelObject md = (ModelObject) request.getSession().getAttribute("LOGIN_ACCOUNT");

	String type_id = "学 生";
	if (md.getTypeID() == 1) {
		type_id = "宿管员";
	}
	if (md.getTypeID() == 2) {
		type_id = "系统管理员";
	}
%>
<head>
<meta charset="UTF-8">
<title>管理中心</title>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/mdui.min.css" />
<style type="text/css">
.mdui-menu-cascade {
	width: 180px;
}
</style>
</head>
<body
	class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-theme-primary-indigo"
	style="background-image: url(../img/gradient2.png);">
	<!-- 头部 -->
	<header class="mdui-appbar mdui-appbar-fixed" id="content-header">
		<div class="mdui-toolbar mdui-color-theme">
			<span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white"
				mdui-drawer="{target: '#content-drawer', swipe: true}"><i
				class="mdui-icon material-icons">menu</i></span> <a href=""
				class="mdui-typo-headline mdui-hidden-xs">自助管理中心</a>
			<div class="mdui-toolbar-spacer"></div>
			<li class="mdui-list-item mdui-ripple"
				mdui-menu="{target: '#example-attr'}">
				<div class="mdui-list-item-avatar">
					<img
						src="<%=md.getPicURL() %>" />
				</div>

				<div class="mdui-list-item-content"><%=md.getAccount()%></div>

			</li>
			<ul class="mdui-menu mdui-menu-cascade" id="example-attr">
				<li class="mdui-menu-item" disabled><a href="javascript:;"
					class="mdui-ripple">身 份: <%=type_id%>
				</a></li>
				<li class="mdui-menu-item" disabled><a href="javascript:;">电
						话: <%=md.getPhoneNumber() %></a></li>

				<li class="mdui-divider"></li>
				<li class="mdui-menu-item"><a href="javascript:;"
					class="mdui-ripple">Sign out</a></li>
			</ul>
			<a href="javascript:Exit();" class="mdui-btn mdui-btn-icon"><i
				class="mdui-icon material-icons">highlight_off</i></a>
		</div>
	</header>