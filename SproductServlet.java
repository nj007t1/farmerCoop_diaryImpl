package edu.ntut.java007.farmerCoop.controller;

import java.io.IOException;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ntut.java007.farmerCoop.model.MemberDAO;
import edu.ntut.java007.farmerCoop.model.MemberServiceImpl;
import edu.ntut.java007.farmerCoop.model.Sproduct;
import edu.ntut.java007.farmerCoop.model.SproductCategoryDAO;
import edu.ntut.java007.farmerCoop.model.SproductDao;

@WebServlet("/edu.ntut.java007.farmerCoop.controller/sproduct.do")
//@RequestMapping(name = "/Sproduct")
public class SproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final char[] Clob = null;
//	@RequestMapping(name = "/Test")
//	public void test() {	
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF8");
	        int id = Integer.parseInt(request.getParameter("productOid"));
	        SproductDao dao = new SproductDao();
	        Sproduct spb = dao.showSproductById(id);
	        request.setAttribute("edit", spb);
	        RequestDispatcher rd = request.getRequestDispatcher("/product.jsp");
	        rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException{
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("ErrorMsgKey", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		
		try {
		String productOid = request.getParameter("productOid");
		String productName = request.getParameter("productName");
		String productImgUrl = request.getParameter("productImgUrl");
		String productInfo = request.getParameter("productInfo");
		String userOid = request.getParameter("userOid");
		String productCatId = request.getParameter("productCatId");
		
		int uOid = Integer.parseInt(userOid);
		int pCid = Integer.parseInt(productCatId);
		int pOid = Integer.parseInt(productOid);
		MemberServiceImpl mbdao = new MemberServiceImpl();
		SproductCategoryDAO scdao = new SproductCategoryDAO();
		SproductDao spdao = new SproductDao();
		Sproduct bean = new Sproduct();
		mbdao.setUserOid(uOid);
		  if (productOid != null && productName != null && userOid != null && productCatId != null) {	
			  successMsgs.put("新增成功", productCatId);
		  } else {
			  errorMsgs.put("新增失敗", productCatId);
		  }
		 spdao.insert(bean);
		 return;
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
			rd.forward(request, response);
		}
		}
	  public static Clob stringToClob(String str) {
			if (null == str)
				return null;
			else {
				try {
					java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(str.toCharArray());
					return c;
				} catch (Exception e) {
					return null;
				}
			}
	
	}
}
