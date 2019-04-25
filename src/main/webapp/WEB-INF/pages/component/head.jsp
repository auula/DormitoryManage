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

<head>
<meta charset="UTF-8">
<title>管理中心</title>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/mdui.min.css" />
</head>
<body class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-theme-primary-indigo"
      style="background-image: url(../img/gradient2.png);">
<!-- 头部 -->
<header class="mdui-appbar mdui-appbar-fixed" id="content-header">
    <div class="mdui-toolbar mdui-color-theme">
        <span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white"
              mdui-drawer="{target: '#content-drawer', swipe: true}"><i class="mdui-icon material-icons">menu</i></span>
        <a href="" class="mdui-typo-headline mdui-hidden-xs">自助管理中心</a>
        <div class="mdui-toolbar-spacer"></div>        
        <a href="javascript:Exit();" class="mdui-btn mdui-btn-icon"><i
                class="mdui-icon material-icons">highlight_off</i></a>
    </div>

</header>