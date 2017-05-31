package com.shoppingWeb.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDb {

	public static Connection getconnection() throws ClassNotFoundException, SQLException{
		Connection con = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/shopping" ;
		String userid = "root";
		String password = "root";
		Class.forName(driverName);
		con = DriverManager.getConnection(url,userid,password);
		return con;
	}
	
}
