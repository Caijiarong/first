package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Vendor;

public class JdbcVendorDaoImpl implements VendorDao {
	@Override
	public void addVendor(Vendor vendor) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO vendor(v_ID,name,address,manager) VALUES(?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vendor.getV_ID()); // 设置参数
			pstmt.setString(2, vendor.getName());
			pstmt.setString(3, vendor.getAddress());
			pstmt.setString(4, vendor.getManager());
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
	public Vendor searchVendor(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM vendor WHERE v_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Vendor vendor = new Vendor();
				vendor.setV_ID(rs.getString("v_ID"));
				vendor.setName(rs.getString("name"));
				vendor.setAddress(rs.getString("address"));
				vendor.setDate(rs.getDate("date"));
				vendor.setManager(rs.getString("manager"));
				return vendor;
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
	public int countVendor() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT COUNT(*) FROM vendor"; // 预处理
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
	public void updateVendor(Vendor vendor) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE vendor SET name=?,address=?,manager=? WHERE v_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vendor.getName()); //设置参数
			pstmt.setString(2, vendor.getAddress());
			pstmt.setString(3, vendor.getManager());
			pstmt.setString(4, vendor.getV_ID());
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
	public void deleteVendor(Vendor vendor) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM vendor WHERE v_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vendor.getV_ID()); // 设置参数
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
