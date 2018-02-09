package diary;

import java.sql.Timestamp;

public class DiaryMain {
	public static void main(String[] args){

		DiaryDAO dao = new DiaryDAO();


		try{
			dao.showDiaryById(1);
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}