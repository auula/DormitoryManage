package me.codegc.manage.service;

import me.codegc.manage.dao.AdminDao;
import me.codegc.manage.dao.StudentDao;
import me.codegc.manage.dao.impl.AdminDaoimplement;
import me.codegc.manage.dao.impl.StudentDaoimplement;
import me.codegc.manage.model.Admin;
import me.codegc.manage.model.Student;

/**
 * 登录访问层
 * 
 * @author Ding
 *
 */
public class LoginService {
	/**
	 *  
	 * 	管理员登录服务
	 */
	public boolean adminLogin(Admin admin) {
		AdminDao ad = new AdminDaoimplement();
		return ad.findByAccountAndPassword(admin.getAccount(), admin.getPassword()) == null ? false : true;
	}
	/**
	 *	学生代理服务
	 */
	public boolean studentLogin(Student student) {
		StudentDao sd = new StudentDaoimplement();
		return sd.findByAccountAndPassword(student.getAccount(), student.getPassword()) == null ? false : true;
	}

}
