package com.shoppingWeb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingWeb.POJO.ProductDTO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
	   ArrayList<ProductDTO> productList=(ArrayList<ProductDTO>)session.getAttribute("List");
	   
	   int id=Integer.parseInt(request.getParameter("productID"));
	   System.out.println("ID is..."+id);
	  
	  /* for(ProductDTO proId: productList){
		   int productId=proId.getId();
		   if(productId==tempProductId){
			  productList.remove(count);
			  session.setAttribute("List", productList);
			  response.sendRedirect("cart.jsp");
		   }
		   count++;
	   }*/
	   
	   for(Iterator<ProductDTO> it=productList.iterator();it.hasNext();){
		   ProductDTO temp=it.next();
		   if(temp.getId()==id){
			   it.remove();
				  session.setAttribute("List", productList);
				  response.sendRedirect("cart.jsp");
		   }
	   }
	}

}
