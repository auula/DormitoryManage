<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 尾部 -->
<div class="mdui-color-theme" id="content-footer">Copyright</div>   
<script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>static/js/mdui.min.js"></script>
</body>