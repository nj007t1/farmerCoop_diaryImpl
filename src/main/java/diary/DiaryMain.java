package diary;

import java.sql.Timestamp;

public class DiaryMain {
	public static void main(String[] args){
		DiaryBean bean = new DiaryBean();
		DiaryDAO dao = new DiaryDAO();


		try{
			dao.showAllDiary(20);

		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}