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
		System.out.println(s);
	}
	int i = 1;
	ArrayList<ProductDTO> a = SearchCategory.search_cat(words);
	for(ProductDTO pd : a){
		System.out.println(pd.getId() + pd.getName());
	}
	
	ArrayList<ProductDTO> a2 = SearchProduct.search_pro(words);
	for(ProductDTO pd : a2){
		System.out.println(pd.getId() + pd.getName() + pd.getImg_path() + pd.getPrice());
	}
	
	}
	

}
