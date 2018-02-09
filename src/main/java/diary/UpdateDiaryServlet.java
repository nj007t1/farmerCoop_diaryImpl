package diary;



import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDiaryServlet
 */
@WebServlet({"/UpdateDiaryServlet","/editDiary.do"})
public class UpdateDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF8");
	        int id = Integer.parseInt(request.getParameter("diaryOid"));
	        DiaryDAO dao = new DiaryDAO();
	        DiaryBean db = dao.showDiaryById(id);
	        request.setAttribute("edit", db);
	        RequestDispatcher rd = request.getRequestDispatcher("/editDiary.jsp");
	        rd.forward(request, response);
//	        UserDao userDao = new UserDao();
//	        UserVo user = userDao.selectOneUserInfo(userId);
	        
//	        request.setAttribute("user", user);
//	        request.getRequestDispatcher("/userupdate.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		
		String title = request.getParameter("title");
		String zipCode = request.getParameter("zipCode");
		Integer productOid = Integer.parseInt(request.getParameter("productOid"));
		Date strTime = Date.valueOf(request.getParameter("strTime"));
		Date endTime = Date.valueOf(request.getParameter("endTime"));
		Integer diaryOid = Integer.parseInt(request.getParameter("diaryOid"));
		DiaryDAO dao = new DiaryDAO();
		DiaryBean db = new DiaryBean();
		db.setProductOid(productOid);
		db.setDiaryTitle(title);
		db.setZipCode(zipCode);
		db.setDiaryStrTime(strTime);
		db.setDiaryEndTime(endTime);
		db.setDiaryOid(diaryOid);
		dao.updateDiary(db);
		 RequestDispatcher rd = request.getRequestDispatcher("/diaryPage.jsp");
	        rd.forward(request, response);
	}

}
