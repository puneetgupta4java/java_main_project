package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.POJO.SearchCategory;
import com.shoppingWeb.POJO.SearchProduct;
import com.shoppingWeb.connectDB.ConnectDb;

@WebServlet("/searchController")
public class searchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
	String TextSearch = request.getParameter("textSearch");
	String[] words = TextSearch.split(" ");
	Connection con =  null;
	ResultSet rs = null;
	for(String s : words){
		if(s.equalsIgnoreCase("under")){
			System.out.println("i'm under");
			ArrayList<ProductDTO> a_under = SearchCategory.search_acc_price_under(words);
			for(ProductDTO pd : a_under){
				System.out.println(pd.getId() + pd.getName());
			}
			response.sendRedirect("trail.html");
		}
		else if(s.equalsIgnoreCase("above")){
			System.out.println("i'm above");
			ArrayList<ProductDTO> a_above = SearchCategory.search_acc_price_above(words);
			for(ProductDTO pd : a_above){
				System.out.println(pd.getId() + pd.getName());
			}
			response.sendRedirect("trail.html");
		}
	}
	System.out.println("now i'm free");
	ArrayList<ProductDTO> a = SearchCategory.search_cat(words);
	for(ProductDTO pd : a){
		System.out.println(pd.getId() + pd.getName());
	}
	
	ArrayList<ProductDTO> a2 = SearchProduct.search_pro(words);
	for(ProductDTO pd : a2){
		System.out.println(pd.getId() + pd.getName() + pd.getImg_path() + pd.getPrice());
	}
	response.sendRedirect("trail.html");	
	}
	

}
