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
import javax.servlet.http.HttpSession;

@WebServlet("/searchController")
public class searchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
                int i = 0;
                HttpSession session = request.getSession(true);
	String TextSearch = request.getParameter("textSearch");
	String[] words = TextSearch.split(" ");
	Connection con =  null;
	ResultSet rs = null;
	for(String s : words){
		if(s.equalsIgnoreCase("under")){
			ArrayList<ProductDTO> a_under = SearchCategoryUnder.search_acc_price_under(words);
			for(ProductDTO pd : a_under){
				System.out.println(pd.getId() + pd.getName());
			}
                       if(a_under != null){
                           System.out.println("hii , i'm under set"); 
                           session.setAttribute("list", a_under);
                            
                       }
                        i++;
                }
		else if(s.equalsIgnoreCase("above")){
			ArrayList<ProductDTO> a_above = SearchCategoryAbove.search_acc_price_above(words);
			for(ProductDTO pd : a_above){
				System.out.println(pd.getId() + pd.getName());
			}
                      if(a_above != null){
                          
                          System.out.println("hii , i'm above set");
                            session.setAttribute("list", a_above);
                }
                        i++;
			//response.sendRedirect("trail.html");
		}
	}
        int flag = 0;
        if(i == 0){
	ArrayList<ProductDTO>  a = null;
        a = SearchCategory.search_cat(words);
	for(ProductDTO pd : a){
		System.out.println(pd.getId() + pd.getName());
	}
	if(a!= null){
            flag++;
            System.out.println("hii , i'm category set");
            session.setAttribute("list", a);
        }
        if(flag == 0){
        ArrayList<ProductDTO> a2 = null;
	a2 = SearchProduct.search_pro(words);
	for(ProductDTO pd : a2){
		System.out.println(pd.getId() + pd.getName() + pd.getImg_path() + pd.getPrice());
	}
      if(a2 != null){
                System.out.println("hii , i'm product set");
            session.setAttribute("list", a2);
      }
        }
        }
	response.sendRedirect("product.jsp");	
	}
	

}
