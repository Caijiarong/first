package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Ven_brand;

public class JdbcVen_brandDaoImpl implements Ven_brandDao {
	@Override
	public void addVen_brand(Ven_brand ven_brand) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO ven_brand(v_ID,brand_ID,manager) VALUES(?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ven_brand.getV_ID()); // 设置参数
			pstmt.setString(2, ven_brand.getBrand_ID());
			pstmt.setString(3, ven_brand.getManager());
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
	public Ven_brand searchVen_brand(String v_id, String brand_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM ven_brand WHERE v_ID=? AND brand_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v_id); // 设置参数
			pstmt.setString(2, brand_id);
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Ven_brand ven_brand = new Ven_brand();
				ven_brand.setV_ID(rs.getString("v_ID"));
				ven_brand.setBrand_ID(rs.getString("brand_ID"));
				ven_brand.setDate(rs.getDate("date"));
				ven_brand.setManager(rs.getString("manager"));
				return ven_brand;
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
	public void deleteVen_brand(Ven_brand ven_brand) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM ven_brand WHERE v_ID=? AND brand_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, ven_brand.getV_ID()); // 设置参数
			pstmt.setString(2, ven_brand.getBrand_ID()); // 设置参数
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
