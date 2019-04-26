package com.codegc.manage.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.codegc.manage.enumeration.ActionStatus;
import me.codegc.manage.model.Admin;
import me.codegc.manage.model.JsonResult;
import me.codegc.manage.service.LoginService;
import me.codegc.manage.utils.JsonUtil;


public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String pwd = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		int type_id = Integer.valueOf(request.getParameter("t_id"));
		 Admin  admin  = new Admin(account,pwd,(byte)1);
		if(new LoginService().Adminlogin(admin)) {
			HttpSession session  = request.getSession();
			session.setAttribute("TYPE_ID", "0");
			JsonUtil.outJson(response, new JsonResult(ActionStatus.LOGIN_SUCCESSFUL.getCode(), ActionStatus.LOGIN_SUCCESSFUL.getMessage()));
		}else {
			JsonUtil.outJson(response, new JsonResult(ActionStatus.LOGIN_ERROR.getCode(), ActionStatus.LOGIN_ERROR.getMessage()));			
		}
	}

}
