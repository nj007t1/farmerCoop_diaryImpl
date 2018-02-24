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

import edu.ntut.java007.farmerCoop.model.Szip;
import edu.ntut.java007.farmerCoop.model.ZipCodeDAO;

@WebServlet("/edu.ntut.java007.farmerCoop.controller/szip.do")
public class SzipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("zipCode"));
		ZipCodeDAO dao = new ZipCodeDAO();
		Szip zip = dao.showSzipById(id);
	    
		HttpSession session = request.getSession();
			try {
				HashMap<String, String> map = new HashMap<String, String>();
				
					
				PrintWriter out = response.getWriter();
				
			} catch (Exception e) {
				
			}
		}
	
	

}
