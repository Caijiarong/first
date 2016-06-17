package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Customer;

public class JdbcCustomerDaoImpl implements CustomerDao {
	public void addCustomer(Customer customer){
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO customer(c_ID,gender,name,phone,address,manager) VALUES(?,?,?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getC_ID()); // 设置参数
			pstmt.setBoolean(2, customer.isGender());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getPhone());
			pstmt.setString(5, customer.getAddress());
			pstmt.setString(6, customer.getManager());
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
	public Customer findCustomer(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM customer WHERE c_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Customer customer = new Customer();
				customer.setC_ID(rs.getString("c_ID"));
				customer.setGender(rs.getBoolean("gender"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customer.setManager(rs.getString("manager"));
				customer.setAdddate(rs.getDate("adddate"));
				customer.setDeldate(rs.getDate("deldate"));
				return customer;
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
	public void updateCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE customer SET gender=?,name=?,phone=?,address=?,manager=? WHERE c_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setBoolean(1, customer.isGender()); //设置参数
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getAddress());
			pstmt.setString(5, customer.getManager());
			pstmt.setString(6, customer.getC_ID());
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
	public void deleteCustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;


			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM customer WHERE c_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, customer.getC_ID()); // 设置参数
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
