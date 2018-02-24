package edu.ntut.java007.farmerCoop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edu.ntut.java007.farmerCoop.controller/pcategory.do")
public class SproductCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
			try {
				Connection con = DriverManager.getConnection( 
						 "jdbc:mysql://localhost:3306/fcdb?useSSL=true&useUnicode=yes&characterEncoding=utf8", 
					      "root","1234");
				PreparedStatement ps = con.prepareStatement("SELECT * FROM sproduct_category WHERE product_cat_id");
				String productCatId = request.getParameter("product_cat_id");	 
				ps.setInt(1, Integer.parseInt(productCatId));
				ResultSet rs = ps.executeQuery();
				
				HashMap<String, String> map = new HashMap<String, String>();
					while (rs.next()) {
						map.put(
						rs.getString("product_cat_id"),
						rs.getString("product_cat_mname")
						//rs.getString("ZipTownName")
						);
					}
				
			} catch (Exception e) {
				
			}
		}
	
	

}
