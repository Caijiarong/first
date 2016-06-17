package cn.edu.scau.retailer.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JdbcExtractDaoImpl implements ExtractDao {

	@Override
	public void ExtractAll(String table) {
		Connection connection = null;
		PreparedStatement preStatement = null;
		ResultSet rs = null;
		ResultSetMetaData meta = null;
		WritableWorkbook wb = null;
		WritableSheet sheet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/db_retailer?characterEncoding=utf-8",
							"root", "");
			String sql = "SELECT * FROM " + table;
			preStatement = connection.prepareStatement(sql);
			rs = preStatement.executeQuery();
			// 获得元数据
			meta = rs.getMetaData();
			// 获得列数
			int num = meta.getColumnCount();
			String[] columns = new String[num + 10];
			// 输出的文件
			wb = Workbook.createWorkbook(new File("F:\\tmp\\test.xls"));
			// 第一个sheet
			sheet = wb.createSheet(table, 0);
			Label label = null;
			// 添加列名
			for (int i = 1; i <= num; i++) {
				columns[i] = meta.getColumnName(i);
				label = new Label(i - 1, 0, columns[i]);
				sheet.addCell(label);
			}
			int rownums = 1;
			// 添加数据部分
			while (rs.next()) {
				for (int i = 1; i <= num; i++) {
					label = new Label(i - 1, rownums, rs.getString(columns[i]));
					sheet.addCell(label);
				}
				rownums++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preStatement != null) {
				try {
					preStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				wb.write();
				wb.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Extract(String sql) {
		Connection connection = null;
		PreparedStatement preStatement = null;
		ResultSet rs = null;
		ResultSetMetaData meta = null;
		WritableWorkbook wb = null;
		WritableSheet sheet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/db_retailer?characterEncoding=utf-8",
							"root", "");
			preStatement = connection.prepareStatement(sql);
			rs = preStatement.executeQuery();
			// 获得元数据
			meta = rs.getMetaData();
			// 获得列数
			int num = meta.getColumnCount();
			String[] columns = new String[num + 10];
			// 输出的文件
			wb = Workbook.createWorkbook(new File("F:\\tmp\\test.xls"));
			// 第一个sheet
			sheet = wb.createSheet("default", 0);
			Label label = null;
			// 添加列名
			for (int i = 1; i <= num; i++) {
				columns[i] = meta.getColumnName(i);
				label = new Label(i - 1, 0, columns[i]);
				sheet.addCell(label);
			}
			int rownums = 1;
			// 添加数据部分
			while (rs.next()) {
				for (int i = 1; i <= num; i++) {
					label = new Label(i - 1, rownums, rs.getString(columns[i]));
					sheet.addCell(label);
				}
				rownums++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preStatement != null) {
				try {
					preStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				wb.write();
				wb.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
