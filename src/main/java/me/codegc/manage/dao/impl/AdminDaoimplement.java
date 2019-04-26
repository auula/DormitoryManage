package me.codegc.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import me.codegc.manage.dao.AdminDao;
import me.codegc.manage.model.Admin;
import me.codegc.manage.utils.JDBCUtil;

public class AdminDaoimplement implements AdminDao {

	// 获取conn
	private Connection conn = JDBCUtil.init(JDBCUtil.CONFIG).getConnection();

	@Override
	public List<Admin> findAllAdmin() {

		return null;
	}

	@Override
	public Admin findByAccount(String account) {

		return null;
	}

	@Override
	public Admin findByAccountAndPassword(String account, String password) {
		// SELECT * FROM t_users WHERE account = "admin" AND password = "admin";
		String sql = "SELECT * FROM t_users WHERE account = ? AND password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		// 创建预编译
		//System.out.println(conn);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				// 保存数据
				admin = new Admin(rs.getString("account"), rs.getString("password"), (byte) 1);
				return admin;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(conn);
		}
		return admin;
	}

}
