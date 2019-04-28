<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
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
					<form class="pui-form login-form" method="post">
						<div class="pui-form-group">
							<h1 class="pui-text-white pui-text-normal">
								<i class="tb-icon icon-lock icon-2x"></i> 重置密码
							</h1>
							<div role="username">
								<input type="text" id="account" maxlength="16"
									class="pui-unbordered" placeholder="用户名" /> <i
									class="fa fa-user pui-text-blue"></i>
							</div>
						</div>
						<div class="pui-form-group">
							<div role="vcode">
								<input type="text" id="vcode" maxlength="4"
									class="pui-unbordered" placeholder="验证码" /> <i
									class="fa fa-shield pui-text-blue"></i> <img
									src="<%=basePath%>get/captcha?<%=System.currentTimeMillis()%>"
									id="vcode-img" />
							</div>
						</div>
						<div class="pui-form-group">
							<input type="button" name="submit" onclick="validation();"
								class="pui-btn pui-btn-default pui-bg-blue-800 pui-unbordered"
								value="登录" /> <span><a href="<%=basePath%>login"
								class="pui-text-white pui-text-xs">去登录.</a></span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<footer
			class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-footer">
			<div class="copyright">
				<p>
					Copyright &copy; <%=(new Date().getYear()+1900)%>
					<a href="https://github.com/pandao/planeui" class="pui-link"
						title="Plane UI" target="_blank">DingShuo</a> All Rights Reserved.
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

	<script src="<%=basePath%>static/js/jquery.base64.js"></script>

	<script type="text/javascript">
		
		/* 点击切换验证码 */
		$("#vcode-img").click(function () {
			console.log();
			$("#vcode-img").attr("src",'<%=basePath%>get/captcha?'+new Date().getTime());
		});
		
		/* 登录验证 */
		function validation() {
			if($($('#account').val() == "")){
				$.message({
			        message:'账号不能为空！',
			        type:'warning',
			        time:'3000', 
			    });
				return;
			}
			if($('#vcode').val() == ""){
				$.message({
			        message:'验证码不能为空！',
			        type:'warning',
			        time:'3000', 
			    });
				return;
			}
			login();
		}
		function login() {
			const data = {
					account : $('#account').val(),
					vcode : $('#vcode').val(),
			}
			console.log(data)
			$.post("<%=basePath%>login/reset", data, function(result) {
				if(result.status == 1001){
					console.log(result.message);
					window.location.href='<%=basePath%>system'; 
				}else{
					$.message({
				        message:result.message,
				        type:'warning',
				        time:'3000', 
				    });
				}
			});
		}
	</script>
</body>

</html>