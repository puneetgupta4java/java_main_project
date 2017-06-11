/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingWeb.POJO;

import com.shoppingWeb.connectDB.ConnectDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puneet gupta
 */
@WebServlet(name = "SearchCategoryAbove", urlPatterns = {"/SearchCategoryAbove"})
public class SearchCategoryAbove extends HttpServlet {

    public static ArrayList<ProductDTO> search_acc_price_above(String[] words){
	ArrayList<ProductDTO> a = new ArrayList<ProductDTO>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			
                    con = ConnectDb.getconnection();
			
			//search it in category table
			for(String s: words){
                            System.out.println(s);
			psmt = con.prepareStatement("select category_id from Category where category_name=? or  category_brand=?;");
			psmt.setString(1, s);
			psmt.setString(2,s);
			rs = psmt.executeQuery();
                        
                        if(rs != null){
                            break;
                        }
                        
			}
			
                         
                           String s1 = null;
                           int f = 0;
                           
                           for(String ab : words){
                              if(f == 0){
                                  s1 = ab;
                                  f++;
                              } 
                              else
                                  s1 = s1 + ab;
                           }
                  
                           s1 = s1.trim();
                           
                         String myNumbers = new String();
                                for (int i = 0; i < s1.length(); i++) 
                                    if (Character.isDigit(s1.charAt(i))) 
                                        myNumbers += s1.charAt(i);    
                                
                                System.out.print(myNumbers);
			//now search it in product table
			while(rs.next()){
                            System.out.print("hii");
                            
			psmt = con.prepareStatement("select * from product where category_id=? and product_price >= ?;");
			psmt.setInt(1, rs.getInt("category_id"));
                        psmt.setDouble(2,Double.parseDouble(myNumbers));
			rs1 = psmt.executeQuery();
                            
			if(rs1 != null){
			while(rs1.next()){
				ProductDTO pd = new ProductDTO();
				pd.setId(rs1.getInt("product_id"));
				pd.setName(rs1.getString("product_name"));
				pd.setPrice(rs1.getDouble("product_price"));
				pd.setWeight(rs1.getString("product_weight"));
				pd.setDimensions(rs1.getString("product_dimensions"));
				pd.setDescr(rs1.getString("product_desc"));
				pd.setQuantity(rs1.getInt("product_quantity"));
				pd.setSeller(rs1.getInt("seller_id"));
				pd.setCategory(rs1.getInt("category_id"));
				pd.setImg_path(rs1.getString("img1"));
				a.add(pd);
			}
                        }
                        }
			return a;
			
                    
		}catch(Exception e){
			e.printStackTrace();
		}
		return a;
		
		
	}
    
}
