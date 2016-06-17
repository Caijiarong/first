package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.scau.retailer.domain.Bill;

public class JdbcBillDaoImpl implements BillDao {
	public void addBill(Bill bill) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO bill(bill_ID,store_ID,c_ID,trade_style,manager) VALUES(?,?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bill.getBill_ID()); // 设置参数
			pstmt.setString(2, bill.getStore_ID());
			pstmt.setString(3, bill.getC_ID());
			pstmt.setString(4, bill.getTrade_style());
			pstmt.setString(5, bill.getManager());
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
	public Bill searchBill(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM bill WHERE bill_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Bill bill = new Bill();
				bill.setBill_ID(rs.getString("bill_ID"));
				bill.setStore_ID(rs.getString("store_ID"));
				bill.setC_ID(rs.getString("c_ID"));
				bill.setFinish_date(rs.getDate("finish_date"));
				bill.setDelete_date(rs.getDate("delete_date"));
				bill.setTrade_style(rs.getString("trade_style"));
				bill.setManager(rs.getString("manager"));
				return bill;
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

	@Override
	public int countBill() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT COUNT(*) FROM bill"; // 预处理
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				int count;
				count = rs.getInt(1);
				return count;
			} else { // 如果找不到则返回null
				return -1;
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

	@Override
	public void updateBill(Bill bill) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE bill SET store_ID=?,c_ID=?,trade_style=? WHERE bill_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bill.getStore_ID());
			pstmt.setString(2, bill.getC_ID());
			pstmt.setString(3, bill.getTrade_style());
			pstmt.setString(4, bill.getBill_ID());
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

	public void deleteBill(Bill bill) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM bill WHERE bill_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bill.getBill_ID()); // 设置参数
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
	
	public void cancelBill(Bill bill){

		Connection con = null;
		PreparedStatement pstmt = null;
		bill.setDelete_date(new Date());
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE bill SET delete_date=? WHERE bill_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(bill.getDelete_date().getTime()));
			pstmt.setString(2, bill.getBill_ID());
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
	
	public void finishBill(Bill bill){

		Connection con = null;
		PreparedStatement pstmt = null;
		bill.setFinish_date(new Date());
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE bill SET finish_date=? WHERE bill_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(bill.getFinish_date().getTime()));
			pstmt.setString(2, bill.getBill_ID());
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


}
