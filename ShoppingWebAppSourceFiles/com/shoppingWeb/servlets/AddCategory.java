package com.shoppingWeb.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.POJO.CategoryDTO;
import com.shoppingWeb.connectDB.ConnectDb;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	static int id;
	@Override
	public void init() throws ServletException {
		id =0 ;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Category_name");
		try {
			id = id+1;
			Connection con = ConnectDb.getconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into category values(?,?);");
			//System.out.println(id);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			int result =0; 
			result = pstmt.executeUpdate();
			if(result > 0){
				response.sendRedirect("index.jsp");
			}
			else{
				response.sendRedirect("error.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
