package diary;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateDiaryServlet
 */
@WebServlet("/createDiary.do")
public class CreateDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");

		String title = request.getParameter("title");

		Timestamp createTime = new Timestamp(System.currentTimeMillis());

		
		//讀入所屬productId(String) Convert to int 
		String productOidString = request.getParameter("productOid");
		int productOid = Integer.parseInt(productOidString);
		//讀入所屬zipCode(String) Convert to int 
		String zipCode = request.getParameter("zipCode");

		DiaryBean dbean = new DiaryBean(productOid, title, zipCode, createTime);
		DiaryDAO dao = new DiaryDAO();
		dao.createDiary(dbean);

		RequestDispatcher rd = request.getRequestDispatcher("/diaryPage.jsp");
		rd.forward(request, response);
		return;
	}

}
