package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Brand;

public class JdbcBrandDaoImpl implements BrandDao {

	@Override
	public void addBrand(Brand brand) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO brand(brand_ID,name,manager) VALUES(?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, brand.getBrand_ID()); // 设置参数
			pstmt.setString(2, brand.getName());
			pstmt.setString(3, brand.getManager());
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
	public Brand searchBrand(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM brand WHERE brand_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Brand brand = new Brand();
				brand.setBrand_ID(rs.getString("brand_ID"));
				brand.setName(rs.getString("name"));
				brand.setDate(rs.getDate("date"));
				brand.setManager(rs.getString("manager"));
				return brand;
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
	public int countBrand() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT COUNT(*) FROM brand"; // 预处理
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
	public void updateBrand(Brand brand) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE brand SET name=?,manager=? WHERE brand_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, brand.getName());
			pstmt.setString(2, brand.getManager());
			pstmt.setString(3, brand.getBrand_ID());
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
	public void deleteBrand(Brand brand) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;


			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM brand WHERE brand_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, brand.getBrand_ID()); // 设置参数
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
