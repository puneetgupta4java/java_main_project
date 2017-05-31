package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.connectDB.ConnectDb;

/**
 * Servlet implementation class AddSeller
 */
@WebServlet("/AddSeller")
public class AddSeller extends HttpServlet {
	static int id;
	@Override
	public void init() throws ServletException {
		id=0;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("seller_name");
		try {
			id = id+1;
			Connection con = ConnectDb.getconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into seller values(?,?);");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			int count =0 ;
			count = pstmt.executeUpdate();
			if(count>0){
				response.sendRedirect("index.jsp");
			}
			else{
				response.sendRedirect("error.html");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}


}
