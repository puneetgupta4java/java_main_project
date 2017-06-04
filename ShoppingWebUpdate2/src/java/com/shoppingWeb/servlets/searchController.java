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
import com.shoppingWeb.POJO.SearchCategoryAbove;
import com.shoppingWeb.POJO.SearchCategoryUnder;
import com.shoppingWeb.POJO.SearchProduct;
import com.shoppingWeb.connectDB.ConnectDb;

@WebServlet("/searchController")
public class searchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
                int i = 0;
	String TextSearch = request.getParameter("textSearch");
	String[] words = TextSearch.split(" ");
	Connection con =  null;
	ResultSet rs = null;
	for(String s : words){
		if(s.equalsIgnoreCase("under")){
			System.out.println("i'm under");
			ArrayList<ProductDTO> a_under = SearchCategoryUnder.search_acc_price_under(words);
			for(ProductDTO pd : a_under){
				System.out.println(pd.getId() + pd.getName());
			}
                        i++;
                        System.out.println("before going anywhere");
			//response.sendRedirect("trail.html");
		}
		else if(s.equalsIgnoreCase("above")){
			System.out.println("i'm above");
			ArrayList<ProductDTO> a_above = SearchCategoryAbove.search_acc_price_above(words);
			for(ProductDTO pd : a_above){
				System.out.println(pd.getId() + pd.getName());
			}
                        i++;
			//response.sendRedirect("trail.html");
		}
	}
        if(i == 0){
	System.out.println("now i'm free");
	ArrayList<ProductDTO> a = SearchCategory.search_cat(words);
	for(ProductDTO pd : a){
		System.out.println(pd.getId() + pd.getName());
	}
	
	ArrayList<ProductDTO> a2 = SearchProduct.search_pro(words);
	for(ProductDTO pd : a2){
		System.out.println(pd.getId() + pd.getName() + pd.getImg_path() + pd.getPrice());
	}
        }
	response.sendRedirect("trail.html");	
	}
	

}
