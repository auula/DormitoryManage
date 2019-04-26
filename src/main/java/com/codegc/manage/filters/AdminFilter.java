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

import me.codegc.manage.enumeration.ActionStatus;
import me.codegc.manage.model.JsonResult;
import me.codegc.manage.utils.JsonUtil;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String TYPE_ID =(String)request.getSession().getAttribute("TYPE_ID");
		
		if(TYPE_ID != null) {
			System.out.println(TYPE_ID);
			if(TYPE_ID.equals("2")) {
				System.out.println("通过是管理员！");
				chain.doFilter(request, response);
			}else{
				response.setStatus(403);
				//身份id不是2说明权限不足
				JsonUtil.outJson(response, JsonResult.init(ActionStatus.LIMITED_AUTHORITY.getCode(), ActionStatus.LIMITED_AUTHORITY.getMessage()));
				return;
			}
		}else {
			System.out.println(TYPE_ID);
			response.setStatus(403);
			//身份id没有或者null
			JsonUtil.outJson(response, JsonResult.init(ActionStatus.IDENTITY_TYPE_ID_ERROR.getCode(), ActionStatus.IDENTITY_TYPE_ID_ERROR.getMessage()));
			return;
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
