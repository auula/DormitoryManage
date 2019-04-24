package me.codegc.manage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ErrorController
 */
public class ErrorController extends HttpServlet {
	
	private static Logger log = Logger.getLogger(ErrorController.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//捕获异常详细信息
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
	
		log.error("请求异常捕获："+statusCode+" => "+throwable+" => "+servletName+" => "+requestUri);

		String path = request.getContextPath();

		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";

		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		/**
		 * 构建错误页面
		 */
		String body = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
				+ "<title>服务器睡着了~请稍后重试！</title>\n" + "<script src=\"" + basePath
				+ "/static/js/jquery-2.1.1.min.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\"\n"
				+ "	href=\" " + basePath + "static/css/404.css\" />\n" + "<script type=\"text/javascript\">\n"
				+ "	$(function() {\n" + "		var h = $(window).height();\n" + "		$('body').height(h);\n"
				+ "		$('.mianBox').height(h);\n" + "		centerWindow(\".tipInfo\");\n" + "	});\n" + "\n"
				+ "	//2.将盒子方法放入这个方，方便法统一调用\n" + "	function centerWindow(a) {\n" + "		center(a);\n"
				+ "		//自适应窗口\n" + "		$(window).bind('scroll resize', function() {\n" + "			center(a);\n"
				+ "		});\n" + "	}\n" + "\n" + "	//1.居中方法，传入需要剧中的标签\n" + "	function center(a) {\n"
				+ "		var wWidth = $(window).width();\n" + "		var wHeight = $(window).height();\n"
				+ "		var boxWidth = $(a).width();\n" + "		var boxHeight = $(a).height();\n"
				+ "		var scrollTop = $(window).scrollTop();\n" + "		var scrollLeft = $(window).scrollLeft();\n"
				+ "		var top = scrollTop + (wHeight - boxHeight) / 2;\n"
				+ "		var left = scrollLeft + (wWidth - boxWidth) / 2;\n" + "		$(a).css({\n"
				+ "			\"top\" : top,\n" + "			\"left\" : left\n" + "		});\n" + "	}\n" + "</script>\n"
				+ "</head>\n" + "<body>\n" + "	<div class=\"mianBox\">\n" + "		<img src=\"" + basePath
				+ "static/images/yun0.png\" alt=\"\" class=\"yun yun0\" /> <img\n" + "			src=\"" + basePath
				+ "static/images/yun1.png\" alt=\"\" class=\"yun yun1\" /> <img\n" + "			src=\"" + basePath
				+ "static/images/yun2.png\" alt=\"\" class=\"yun yun2\" /> <img\n" + "			src=\"" + basePath
				+ "static/images/bird.png\" alt=\"\" class=\"bird\" /> <img\n" + "			src=\"" + basePath
				+ "static/images/san.png\" alt=\"\" class=\"san\" />\n" + "		<div class=\"tipInfo\">\n"
				+ "			<div class=\"in\">\n" + "				<div class=\"textThis\">\n"
				+ "					<h2>服务器睡着了~请稍后重试！</h2>\n" + "					<p>\n"
				+ "						<span>页面自动<a id=\"href\" href=\"\">跳转</a></span><span>等待<b\n"
				+ "							id=\"wait\">6</b>秒\n" + "						</span>\n"
				+ "					</p>\n" + "					<script type=\"text/javascript\">\n"
				+ "						(function() {\n"
				+ "							var wait = document.getElementById('wait'), href = document\n"
				+ "									.getElementById('href').href;\n"
				+ "							var interval = setInterval(function() {\n"
				+ "								var time = --wait.innerHTML;\n"
				+ "								if (time <= 0) {\n" + "\n"
				+ "									clearInterval(interval);\n"
				+ "									location.href = '" + basePath + "';\n"
				+ "									\n" + "								}\n"
				+ "								;\n" + "							}, 1000);\n"
				+ "						})();\n" + "					</script>\n" + "				</div>\n"
				+ "			</div>\n" + "		</div>\n" + "	</div>\n" + "</body>\n" + "</html>";
		out.write(body);
	}

}
