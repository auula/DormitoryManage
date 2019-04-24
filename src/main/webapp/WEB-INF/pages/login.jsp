<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用宿舍自助管理系统</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/planeui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/login.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/message.css" />

</head>


<body>
	<!--[if lte IE 9]>
        <div class="pui-layout pui-browsehappy">
            <a href="javascript:;" class="pui-close" onclick="document.body.removeChild(this.parentNode);"></a>
            <p>您正在使用 <strong class="pui-text-yellow pui-text-xl">过时</strong> 的非现代浏览器，<strong class="pui-text-success pui-text-xl">91.23%</strong> 的人选择 <a href="http://browsehappy.com/" target="_blank" class="pui-text-green-400 pui-text-xl"><strong>升级浏览器</strong></a>，获得了更好、更安全的浏览体验！</p>
        </div>
        <![endif]-->
	<a name="top"></a>
	<div class="pui-layout pui-flexbox pui-flex-column login-layout">
		<div class="pui-layout pui-flex login-main">
			<div
				class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-main-con">
				<div class="login-panel">
					<form class="pui-form login-form" action="dashboard.html"
						method="post">
						<div class="pui-form-group">
							<h1 class="pui-text-white pui-text-normal">
								<i class="planeui-logo-2x pui-text-xxxxxl"></i> 登录 Login
							</h1>
							<div role="username">
								<input type="text" name="username" maxlength="16"
									class="pui-unbordered" placeholder="用户名" /> <i
									class="fa fa-user pui-text-blue"></i>
							</div>
						</div>
						<div class="pui-form-group">
							<div role="password">
								<input type="password" name="password" maxlength="16"
									class="pui-unbordered" placeholder="密码" /> <i
									class="fa fa-lock pui-text-blue"></i>
							</div>
						</div>
						<div class="pui-form-group">
							<div role="vcode">
								<input type="text" name="vcode" maxlength="4"
									class="pui-unbordered" placeholder="验证码" /> <i
									class="fa fa-shield pui-text-blue"></i> <img
									src="static/images/captcha.png" id="vcode-img" />
							</div>
						</div>
						<div class="pui-form-group">
							<label style="font-size: 15px" class="type_form">身 份 :</label>
							<pui-radio name="type_id" value="学生" class="checked">学生<input
								class="type_form" type="radio" name="type_id" value="学生"
								checked="checked"></pui-radio>
							<pui-radio name="type_id" value="宿管">宿管<input
								type="radio" name="type_id" value="宿管"></pui-radio>
							<pui-radio name="type_id" value="保密">系统管理员<input
								type="radio" name="type_id" value="admin"></pui-radio>
						</div>
						<div class="pui-form-group">
							<input type="submit" name="submit"
								class="pui-btn pui-btn-default pui-bg-blue-800 pui-unbordered"
								value="登录" /> <span><a href="#"
								class="pui-text-white pui-text-xs">忘记密码？</a></span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<footer
			class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-footer">
			<div class="copyright">
				<p>
					Copyright &copy; 2019 <a href="https://github.com/pandao/planeui"
						class="pui-link" title="Plane UI" target="_blank">DingShuo</a> All
					Rights Reserved.
				</p>
				<p>
					<small class="pui-right">代码如诗。</small>
				</p>
			</div>
		</footer>
	</div>



	


	<script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
	
	<script src="<%=basePath%>static/js/message.min.js"></script>
	
	<script src="<%=basePath%>static/js/planeui.js"></script>



	<script type="text/javascript">
		$(function() {
			setInterval(() => {
				$.message({
			        message:'账号或者密码不能为空！',
			        type:'warning',
			        time:'3000', 
			    });
			}, 5000);
		})
	</script>
</body>

</html>