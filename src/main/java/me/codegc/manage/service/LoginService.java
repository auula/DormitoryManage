package me.codegc.manage.service;

import me.codegc.manage.dao.AdminDao;
import me.codegc.manage.dao.impl.AdminDaoimplement;
import me.codegc.manage.model.Admin;

/**
 * 登录访问层
 * 
 * @author Ding
 *
 */
public class LoginService {
	/**
	 *  
	 * 管理员登录服务
	 */
	public boolean Adminlogin(Admin admin) {
		AdminDao ad = new AdminDaoimplement();
		return ad.findByAccountAndPassword(admin.getAccount(), admin.getPassword()) == null ? false : true;
	}

}
