package me.codegc.manage.service;

import me.codegc.manage.dao.AdminDao;
import me.codegc.manage.dao.StudentDao;
import me.codegc.manage.dao.impl.AdminDaoimplement;
import me.codegc.manage.dao.impl.StudentDaoimplement;
import me.codegc.manage.model.Admin;
import me.codegc.manage.model.Student;

/**
 * 处理用户相关的服务
 * @author ding
 *
 */
public class UserService {
	
	
	/**
	 * 通过账号返回用户的所以数据
	 * @param account
	 * @return
	 */
	public Student getStudentAccountData(String account) {
		StudentDao sd = new StudentDaoimplement();
		return sd.findByAccount(account);
	}
	
	/**
	 * 通过账号返回用户的所以数据
	 * @param account
	 * @return
	 */
	public Admin getAdminAccountData(String account) {
		AdminDao ad = new AdminDaoimplement();
		return ad.findByAccount(account);
	}
}
