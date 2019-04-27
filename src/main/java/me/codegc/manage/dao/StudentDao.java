package me.codegc.manage.dao;

import java.sql.SQLException;
import java.util.List;

import me.codegc.manage.model.Student;

/**
 * 学生数据接口
 * @author DING
 *
 */
public interface StudentDao {
	/**
	 * 查询所有的学生用户
	 * @return List<Student>
	 */
	List<Student> findAllStudent();
	/**
	 * 通过账号查询学生
	 * @param account
	 * @return Student
	 */
	Student findByAccount(String account);
	/**
	 * 通过账号和密码查询学生
	 * @param account
	 * @param password
	 * @return Student
	 * @throws SQLException 
	 */
	Student findByAccountAndPassword(String account,String password);
}
