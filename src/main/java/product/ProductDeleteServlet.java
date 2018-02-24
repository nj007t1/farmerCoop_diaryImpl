package edu.ntut.java007.farmerCoop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ntut.java007.farmerCoop.model.Sproduct;
import edu.ntut.java007.farmerCoop.model.SproductDao;

@WebServlet("/edu.ntut.java007.farmerCoop.controller/ProductDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
         	HttpSession session = request.getSession();
        	String poid = request.getParameter("productOid");
        	String pimg = request.getParameter("productImgUrl");
        	String pname = request.getParameter("productName");
        	String pinfo = request.getParameter("productInfo");
        	String uoid = request.getParameter("userOid");
    		String pcid = request.getParameter("productCatId");
    		
    		int productOid = Integer.parseInt(poid);
    		SproductDao bab = new SproductDao();
			if (poid != null && pimg != null && pname != null && pinfo != null && uoid != null && pcid != null) {
				bab.delete(productOid);
				session.setAttribute("DeleteMsg","刪除成功");
			} else { 
				session.setAttribute("DeleteMsg","刪除失敗");
			}
			response.sendRedirect("DisplayPageProducts");
			return;
		}  catch (SQLException e) {
			throw new ServletException(e);
		}
       
        
	}

}
