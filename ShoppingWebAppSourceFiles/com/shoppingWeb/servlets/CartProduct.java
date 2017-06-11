package com.shoppingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.shoppingWeb.POJO.ProductDTO;
import com.shoppingWeb.connectDB.ConnectDb;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;



@WebServlet("/CartProduct")
public class CartProduct extends HttpServlet {
	 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	PrintWriter out=response.getWriter();
	 	HttpSession session=request.getSession(false);
	 	if(session== null){
	 		response.sendRedirect("error.html");
	 	}
	 	else{
  HashSet productNo=(HashSet)session.getAttribute("ProductNo");
  ArrayList<ProductDTO> cartProduct=new ArrayList<ProductDTO>();
  Iterator it=productNo.iterator();
	 	Connection connection=null;
	 	ConnectDb con=new ConnectDb();
	 	PreparedStatement  pstmt=null;
	 	ResultSet rs=null;

	 	
	 	try {
			connection =(Connection) con.getconnection();
			if(productNo!=null && productNo.size()>0){
				String li = "";
				
				        while(it.hasNext())  {
					int id=(int) it.next();
				  pstmt=(PreparedStatement) connection.prepareStatement("select product_id, product_name,product_price,product_weight,product_dimensions,"
				  		+ " product_desc,product_quantity, img1 from product where product_id=?");		
				  pstmt.setInt(1,id );
				  rs = pstmt.executeQuery();
				  while(rs.next()){
					  ProductDTO pdto = new ProductDTO();
					  pdto.setName(rs.getString("product_name"));
					  pdto.setPrice(rs.getDouble("product_price"));
					  pdto.setWeight(rs.getString("product_weight"));
					  pdto.setDimensions("product_dimensions");
					  pdto.setDescr(rs.getString("product_desc"));
					  pdto.setQuantity(rs.getInt("product_quantity"));
					  pdto.setImg_path(rs.getString("img1"));
					  pdto.setId(rs.getInt("product_id"));
					  cartProduct.add(pdto);
					  System.out.println("COMPLETE");
				  }}
				/*  String productHTML = "";

				  if(cartProduct!=null && cartProduct.size()>0){
						String li1 = "";
						
						for(ProductDTO productList : cartProduct){
							String liHTML = "<li>"+productList.getId()
							+" "+productList.getName()+" "+productList.getDescr()+
							"<BR> <img src='"+productList.getImg_path()+"' >"
							+"<BR> "+productList.getPrice()+" </li>";
							li1 = li1 + liHTML;
						}
						System.out.println("**********");
						productHTML = "<ul>"+li1+"</ul>";
					}
					String logout = "<html><body>"
							+ "<br>"
							+ "<form action='logout'>"
							+ "<button type='submit'>Logout</button>"
							+ productHTML
							
							+ "</form></body></html>";
					
				//	session.setMaxInactiveInterval(10*60);
					
				out.println(logout);
*/				  session.setAttribute("List", cartProduct);
				  response.sendRedirect("cart.jsp");
				/*  RequestDispatcher dd = request.getRequestDispatcher("cart.jsp");

				  dd.forward(request, response);*/
				
				}
			
			  }		
		catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		} 
	
	 	}
	 	
	 	}

}
