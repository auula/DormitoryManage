package me.codegc.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.codegc.manage.dao.StudentDao;
import me.codegc.manage.model.Student;
import me.codegc.manage.utils.JDBCUtil;

public class StudentDaoimplement implements StudentDao {

	// 获取conn
	private Connection conn = JDBCUtil.init(JDBCUtil.CONFIG).getConnection();

	@Override
	public List<Student> findAllStudent() {
		//typeid = 0 是学生
		String sql = "SELECT * FROM t_user WHERE  typeID = 0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> lists = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement(sql);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				lists.add(new Student(
						rs.getString("account"), 
						rs.getString("password"),
						rs.getString("userName"),
						rs.getString("phoneNumber"),
						rs.getString("picURL"),
						rs.getByte("typeID")
						));
			}
			// 保存数据
			return lists;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection(conn);
		}
		return null;
		
	}

	@Override
	public Student findByAccount(String account) {
		String sql = "SELECT * FROM t_user WHERE account = ? AND typeID = 0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				// 保存数据
				student = new Student(
						rs.getString("account"), 
						rs.getString("password"),
						rs.getString("userName"),
						rs.getString("phoneNumber"),
						rs.getString("picURL"),
						rs.getByte("typeID")
						);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection(conn);
		}
		return student;
	}

	@Override
	public Student findByAccountAndPassword(String account, String password) {
		String sql = "SELECT * FROM t_user WHERE account = ? AND password = ? AND typeID = 0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				// 保存数据
				student = new Student(
						rs.getString("account"), 
						rs.getString("password"),
						rs.getString("userName"),
						rs.getString("phoneNumber"),
						rs.getString("picURL"),
						rs.getByte("typeID")
						);
				return student;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection(conn);
		}
		return student;
	}

}
