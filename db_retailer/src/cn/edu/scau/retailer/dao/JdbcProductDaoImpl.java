package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Product;

public class JdbcProductDaoImpl implements ProductDao {
	@Override
	public void addProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println(product);
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO product(p_ID,name,brand_ID,t_ID,manufacturer,made_in,manager,unit,discount,ori_price) VALUES(?,?,?,?,?,?,?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getP_ID()); // 设置参数
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getBrand_ID());
			pstmt.setString(4, product.getT_ID());
			pstmt.setString(5, product.getManufacturer());
			pstmt.setString(6, product.getMade_in());
			pstmt.setString(7, product.getManager());
			pstmt.setString(8, product.getUnit());
			pstmt.setDouble(9, product.getDiscount());
			pstmt.setDouble(10, product.getOri_price());
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
	public Product searchProduct(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM product WHERE p_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Product product = new Product();
				product.setP_ID(rs.getString("p_ID"));
				product.setT_ID(rs.getString("t_ID"));
				product.setBrand_ID(rs.getString("brand_ID"));
				product.setName(rs.getString("name"));
				product.setManufacturer(rs.getString("manufacturer"));
				product.setDate(rs.getDate("date"));
				product.setMade_in(rs.getString("made_in"));
				product.setManager(rs.getString("manager"));
				product.setUnit(rs.getString("unit"));
				product.setDiscount(rs.getDouble("discount"));
				product.setOri_price(rs.getDouble("ori_price"));
				return product;
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
	public int countProduct() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT COUNT(*) FROM product"; // 预处理
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
	public void updateProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE product SET name=?,brand_ID=?,t_ID=?,manufacturer=?,made_in=?,manager=?,unit=?,discount=?,ori_price=? WHERE p_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, product.getName()); //设置参数
			pstmt.setString(2, product.getBrand_ID());
			pstmt.setString(3, product.getT_ID());
			pstmt.setString(4, product.getManufacturer());
			pstmt.setString(5, product.getMade_in());
			pstmt.setString(6, product.getManager());
			pstmt.setString(7, product.getUnit());
			pstmt.setDouble(8, product.getDiscount());
			pstmt.setDouble(9, product.getOri_price());
			pstmt.setString(10, product.getP_ID());

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
	public void deleteProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println(product);
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM product WHERE p_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, product.getP_ID()); // 设置参数
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
