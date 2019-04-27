package me.codegc.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.codegc.manage.dao.DormDao;
import me.codegc.manage.model.Dormitory;
import me.codegc.manage.utils.JDBCUtil;

public class DormDaoimplement implements DormDao {
	// 获取conn
	private Connection conn = JDBCUtil.init(JDBCUtil.CONFIG).getConnection();
	@Override
	public List<Dormitory> findAllDormitory() {

		String sql = "SELECT * FROM t_user WHERE  typeID = 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Dormitory> lists = new ArrayList<Dormitory>();
		try {
			ps = conn.prepareStatement(sql);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				lists.add(new Dormitory(
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
	public Dormitory findByAccount(String account) {
		String sql = "SELECT * FROM t_user WHERE account = ? AND typeID = 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dormitory dormitory = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				// 保存数据
				dormitory = new Dormitory(
						rs.getString("account"), 
						rs.getString("password"),
						rs.getString("userName"),
						rs.getString("phoneNumber"),
						rs.getString("picURL"),
						rs.getByte("typeID")
						);
				return dormitory;
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
		return dormitory;
	}

	@Override
	public Dormitory findByAccountAndPassword(String account, String password) {
		String sql = "SELECT * FROM t_user WHERE account = ? AND password = ? AND typeID = 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dormitory dormitory = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			// 执行
			rs = ps.executeQuery();
			if (rs.next()) {
				// 保存数据
				dormitory = new Dormitory(
						rs.getString("account"), 
						rs.getString("password"),
						rs.getString("userName"),
						rs.getString("phoneNumber"),
						rs.getString("picURL"),
						rs.getByte("typeID")
						);
				return dormitory;
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
		return dormitory;
	}

	
}
