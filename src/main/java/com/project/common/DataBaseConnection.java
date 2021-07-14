package com.project.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseConnection {
	
	private HikariDataSource ds;
	private Connection conn;
	
	public HikariDataSource openDataSource() throws SQLException {
		HikariConfig config=new HikariConfig();
		config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=carnewsDB");
		config.setUsername("SA");
		config.setPassword("123(!)Password");
		config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		config.setMaximumPoolSize(10);
		
		ds=new HikariDataSource(config);
			return ds;
		
	}
	
	public Connection getConn() throws Exception {
		conn = ds.getConnection();
		System.out.println("connected!");
		return conn;
	}
	
	public void closeDataSource() {
		if(ds!=null) {
			ds.close();
			System.out.println("data source closed!");
		}
	}
	
	public void closeConn() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	


}
