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

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
		static int id;
		
		@Override
		public void init() throws ServletException {
			id =0 ;
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("Product_name");
			double price = Double.parseDouble(request.getParameter("Product_price"));
			String weight = request.getParameter("Product_weight");
			String dimensions = request.getParameter("Product_dimensions");
			String desc = request.getParameter("Product_desc");
			int quantity = Integer.parseInt(request.getParameter("Product_quantity"));
			int seller_id = Integer.parseInt(request.getParameter("Product_seller"));
			int category_id = Integer.parseInt(request.getParameter("Product_category"));
			String image_path = request.getParameter("Product_img"); 
			int count =0 ;
			try {
				id = id+1;
				Connection con = ConnectDb.getconnection();
				PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?,?);");
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setDouble(3, price);
				pstmt.setString(4, weight);
				pstmt.setString(5, dimensions);
				pstmt.setString(6, desc);
				pstmt.setInt(7, quantity);
				pstmt.setInt(8, category_id);
				pstmt.setInt(9, seller_id);
				pstmt.setString(10, image_path);
				System.out.println(pstmt);
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
