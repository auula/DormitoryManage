package me.codegc.manage.dao;

import java.sql.SQLException;
import java.util.List;

import me.codegc.manage.model.Dormitory;

/**
 * 
 * @author Ding 宿舍管理员数据层
 *
 */
public interface DormDao {

	/**
	 * 查询所有的Dormitory用户
	 * 
	 * @return List<Dormitory>
	 */
	List<Dormitory> findAllDormitory();

	/**
	 * 通过账号查询Dormitory
	 * 
	 * @param account
	 * @return Dormitory
	 */
	Dormitory findByAccount(String account);

	/**
	 * 通过账号和密码查询Dormitory
	 * 
	 * @param account
	 * @param password
	 * @return Dormitory
	 * @throws SQLException
	 */
	Dormitory findByAccountAndPassword(String account, String password);

}
