package diary;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDiaryList
 */
@WebServlet("/diaryList.do")
public class DiaryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;
  //Setting JSP page
 //   String page="/diaryPage.jsp";

  public void init(ServletConfig config)
    throws ServletException{
     this.config=config;
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF8");
//		DiaryDAO dao = new DiaryDAO();
//		List<DiaryBean> bean = dao.showAllDiary(1);
//		request.setAttribute("diary", bean);
//		RequestDispatcher rd = request.getRequestDispatcher("/diaryPage.jsp");
//		rd.forward(request, response);
//		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
