package me.codegc.manage.dao;

import java.sql.SQLException;
import java.util.List;

import me.codegc.manage.model.Admin;

public interface AdminDao {
	/**
	 * 查询所有的admin用户
	 * @return List<Admin>
	 */
	List<Admin> findAllAdmin();
	/**
	 * 通过账号查询管理员
	 * @param account
	 * @return Admin
	 */
	Admin findByAccount(String account);
	/**
	 * 通过账号和密码查询管理员
	 * @param account
	 * @param password
	 * @return Admin
	 * @throws SQLException 
	 */
	Admin findByAccountAndPassword(String account,String password);
}
