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
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		String path = request.getServletPath();
//		if (path.indexOf("/static/") < 0 && path.indexOf("/login/") < 0 && path.indexOf("/get/") < 0 && path.indexOf("index.html") < 0) {
//			response.sendRedirect(request.getContextPath());
//		}else{
//			chain.doFilter(request, response);
//		}
		chain.doFilter(servletRequest, servletResponse);
		

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
