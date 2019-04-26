package com.codegc.manage.api;

import java.io.IOException;
import java.security.CryptoPrimitive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.codegc.manage.enumeration.ActionStatus;
import me.codegc.manage.enumeration.UserTypeID;
import me.codegc.manage.model.Admin;
import me.codegc.manage.model.JsonResult;
import me.codegc.manage.service.LoginService;
import me.codegc.manage.utils.JsonUtil;
/**
 * 处理ajax发过了到请求
 * @author ding
 *
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//登陆业务 服务层
	private LoginService ls = new LoginService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		int type_id = Integer.valueOf(request.getParameter("t_id"));
		
		
		switch (type_id) {
		// 0代表系统学生
		case 0:
			if (ls.Adminlogin(new Admin(account, pwd, (byte) 1))) {
				
				session.setAttribute("TYPE_ID", UserTypeID.STUDENT.getTypeid());
				session.setAttribute("LOGIN_USER", true);
				JsonUtil.outJson(response, new JsonResult(ActionStatus.LOGIN_SUCCESSFUL.getCode(),
						ActionStatus.LOGIN_SUCCESSFUL.getMessage()));
			} else {
				JsonUtil.outJson(response,
						new JsonResult(ActionStatus.LOGIN_ERROR.getCode(), ActionStatus.LOGIN_ERROR.getMessage()));
			}
			break;
		// 1代表 平台管理员管员
		case 1:
			if (ls.Adminlogin(null)) {
				session.setAttribute("TYPE_ID", UserTypeID.DORM_MANNAGE.getTypeid());
				session.setAttribute("IS_LOGIN", true);
				JsonUtil.outJson(response, new JsonResult(ActionStatus.LOGIN_SUCCESSFUL.getCode(),
						ActionStatus.LOGIN_SUCCESSFUL.getMessage()));
			} else {
				JsonUtil.outJson(response,
						new JsonResult(ActionStatus.LOGIN_ERROR.getCode(), ActionStatus.LOGIN_ERROR.getMessage()));
			}
			break;
		// 2代表系统管理员  管理员控制器  
		case 2:
			//CryptoPrimitive让进行私钥解密
			if (ls.Adminlogin(new Admin(account, password, (byte)1))) {
				//session会话里存入用户身份ID 为后续权限管理做准备
				session.setAttribute("TYPE_ID", UserTypeID.ADMIN.getTypeid());
				session.setAttribute("IS_LOGIN", true);
				//设置超时为30分钟 1800000ms
				session.setMaxInactiveInterval(1000*60*30);
				JsonUtil.outJson(response, new JsonResult(ActionStatus.LOGIN_SUCCESSFUL.getCode(),
						ActionStatus.LOGIN_SUCCESSFUL.getMessage()));
			} else {
				//service层如果返回false 说明用户账号或者密码错误
				JsonUtil.outJson(response,
						new JsonResult(ActionStatus.LOGIN_ERROR.getCode(), ActionStatus.LOGIN_ERROR.getMessage()));
			}
			break;
		default:
			//能来到这里说明这个用户不存在
			JsonUtil.outJson(response,
					new JsonResult(ActionStatus.IDENTITY_TYPE_ID_ERROR.getCode(), ActionStatus.IDENTITY_TYPE_ID_ERROR.getMessage()));
			break;
		}

	}

}
