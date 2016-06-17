package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Manager;

public class JdbcManagerDaoImpl implements ManagerDao {

	@Override
	public Manager findNum(String number) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM manager where user_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, number); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Manager manager = new Manager();
				manager.setUser_ID(rs.getString("user_ID"));
				manager.setGrade(rs.getInt("grade"));
				manager.setPasswd(rs.getString("passwd"));
				manager.setDate(rs.getDate("date"));
				manager.setManager(rs.getString("manager"));
				return manager;
			} else { // 如果找不到则返回null
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		} finally { // 关闭连接
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}
	
	public void addManager(Manager manager){
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO manager(user_ID,passwd,grade,manager) VALUES(?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getUser_ID()); // 设置参数
			pstmt.setString(2, manager.getPasswd());
			pstmt.setInt(3, manager.getGrade());
			pstmt.setString(4, manager.getManager());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally { // 关闭连接
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	
	}

	@Override
	public void updateManager(Manager manager) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE manager SET passwd=?,grade=?,manager=? WHERE user_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, manager.getPasswd()); //设置参数
			pstmt.setInt(2, manager.getGrade());
			pstmt.setString(3, manager.getManager());
			pstmt.setString(4, manager.getUser_ID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally { // 关闭连接
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	@Override
	public void deleteManager(Manager manager) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;


			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM manager WHERE user_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, manager.getUser_ID()); // 设置参数
			pstmt.executeUpdate();

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
	}

}
