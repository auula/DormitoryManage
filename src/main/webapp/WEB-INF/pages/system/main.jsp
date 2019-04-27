<%@page import="me.codegc.manage.enumeration.UserTypeID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<jsp:include page="${'../component/head.jsp'}"></jsp:include>
<!-- 通过登录的用户id来区分用户的功能 -->
<%
	Integer id = (Integer)request.getSession().getAttribute("TYPE_ID");
/* 	if(id == null){
		response.sendRedirect(request.getContextPath());
	} */
	switch (id){
		case 0:
			
		%>
			<jsp:include page="${'./student-drawer.jsp' }"></jsp:include>
		<%
			break;
		case 1:
		%>
			<jsp:include page="${'./dorm-drawer.jsp' }"></jsp:include>
		<%
			break;
		case 2:
		%>	
			<jsp:include page="${'./admin-drawer.jsp' }"></jsp:include>
		<% 	
			break;
		default:
	}
%>	


<!-- 内容 -->
<div class="mdui-container" id="content-main">
    
</div>

<jsp:include page="${'../component/footer.jsp' }"></jsp:include>

</html>