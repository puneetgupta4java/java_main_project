/**
 * 
 */
package com.shoppingWeb.POJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shoppingWeb.connectDB.ConnectDb;

/**
 * @author puneet gupta
 *
 */
public class SearchProduct {

	public static ArrayList<ProductDTO> search_pro(String[] words){
		ArrayList<ProductDTO> a = new ArrayList<ProductDTO>();
		
		// now search according to product name , price
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			
			con = ConnectDb.getconnection();
			for(String text  : words){
			psmt = con.prepareStatement("Select * from product where product_name = ?");
			psmt.setString(1, text);
			rs = psmt.executeQuery();
			}
			while(rs.next()){
				ProductDTO pd = new ProductDTO();
				pd.setId(rs.getInt("product_id"));
				pd.setName(rs.getString("product_name"));
				pd.setPrice(rs.getDouble("product_price"));
				pd.setWeight(rs.getString("product_weight"));
				pd.setDimensions(rs.getString("product_dimensions"));
				pd.setDescr(rs.getString("product_desc"));
				pd.setQuantity(rs.getInt("product_quantity"));
				pd.setSeller(rs.getInt("seller_id"));
				pd.setCategory(rs.getInt("category_id"));
				pd.setImg_path(rs.getString("img1"));
				a.add(pd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return a;
	}
	
	
	
}
