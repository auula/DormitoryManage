package com.codegc.manage.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.codegc.manage.model.ModelObject;

/**
 * 检查以后是否登录
 * 
 * @author ding
 *
 */
public class LoginFilter implements Filter {

	private FilterConfig config;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
//		Enumeration initParams = this.getConfig().getInitParameterNames();
		//这里做登陆验证
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//如果用户登陆了，session里面就存放者用户
		ModelObject LOGIN_ACCOUNT = (ModelObject)request.getSession().getAttribute("LOGIN_ACCOUNT");
		String path = request.getServletPath();
		//对一些静态资源不拦截
		if (LOGIN_ACCOUNT == null && path.indexOf("/static/") < 0 && path.indexOf("/login/") < 0 && path.indexOf("/get/") < 0 && path.indexOf("index.html") < 0) {
			response.sendRedirect(request.getContextPath());
		}else{
			chain.doFilter(request, response);
		}
		//chain.doFilter(servletRequest, servletResponse);
		

//		while (initParams.hasMoreElements()) {
//			String  params = (String ) initParams.nextElement();
//			if(path.indexOf(config.getInitParameter(params)) != -1) {
//				response.sendRedirect("/");
//				return;
//			}
//		}

	}

	// 初始化
	public void init(FilterConfig fConfig) throws ServletException {
		this.setConfig(fConfig);
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

}
