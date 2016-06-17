package cn.edu.scau.retailer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Pro_sto;

public class JdbcPro_stoDaoImpl implements Pro_stoDao {
	@Override
	public void addPro_sto(Pro_sto pro_sto) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "INSERT INTO pro_sto(ps_ID,store_ID,p_ID,v_ID,price,amount,upc_code,product_date,manager) VALUES(?,?,?,?,?,?,?,?,?)"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro_sto.getPs_ID()); // 设置参数
			pstmt.setString(2, pro_sto.getStore_ID());
			pstmt.setString(3, pro_sto.getP_ID());
			pstmt.setString(4, pro_sto.getV_ID());
			pstmt.setDouble(5, pro_sto.getPrice());
			pstmt.setDouble(6, pro_sto.getAmount());
			pstmt.setString(7, pro_sto.getUpc_code());
			pstmt.setDate(8, new java.sql.Date(pro_sto.getProduct_date().getTime()));
			pstmt.setString(9, pro_sto.getManager());
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
	public Pro_sto searchPro_sto(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT * FROM pro_sto WHERE ps_ID=?"; // 预处理
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 设置参数
			rs = pstmt.executeQuery(); // 获得结果

			if (rs.next()) { // 封装获得的数据
				Pro_sto pro_sto = new Pro_sto();
				pro_sto.setPs_ID(rs.getString("ps_ID"));
				pro_sto.setP_ID(rs.getString("p_ID"));
				pro_sto.setV_ID(rs.getString("v_ID"));
				pro_sto.setStore_ID(rs.getString("store_ID"));
				pro_sto.setPrice(rs.getDouble("price"));
				pro_sto.setAmount(rs.getDouble("amount"));
				pro_sto.setDate(rs.getDate("date"));
				pro_sto.setProduct_date(rs.getDate("product_date"));
				pro_sto.setManager(rs.getString("manager"));
				pro_sto.setUpc_code(rs.getString("upc_code"));
				return pro_sto;
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
	public int countPro_sto() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "SELECT COUNT(*) FROM pro_sto"; // 预处理
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
	public void updatePro_sto(Pro_sto pro_sto) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "UPDATE pro_sto SET store_ID=?,p_ID=?,v_ID=?,price=?,amount=?,upc_code=?,product_date=? WHERE ps_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, pro_sto.getStore_ID()); //设置参数
			pstmt.setString(2, pro_sto.getP_ID());
			pstmt.setString(3, pro_sto.getV_ID());
			pstmt.setDouble(4, pro_sto.getPrice());
			pstmt.setDouble(5, pro_sto.getAmount());
			pstmt.setString(6, pro_sto.getUpc_code());
			pstmt.setDate(7, new java.sql.Date(pro_sto.getProduct_date().getTime()));
			pstmt.setString(8, pro_sto.getPs_ID());
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
	public void deletePro_sto(Pro_sto pro_sto) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection(); // 获取数据库的连接
			String sql = "DELETE FROM pro_sto WHERE ps_ID=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, pro_sto.getP_ID()); // 设置参数
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
	
	public static void extractFromDatabase(String table) {

	}
}
