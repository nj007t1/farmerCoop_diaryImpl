package diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class TestDAO {
	public void save(DiaryBean bean) {
		String sql = "INSERT INTO sdiary (" + " diary_oid, product_oid, diary_title, zip_code, diary_create_time, "
				+ " diary_str_time, diary_end_time" + " ) " + " VALUES(" + "null, ?, ?, ?, ?, ?, ?)";
		try(Connection con = DriverManager.getConnection(SystemUtils.URL);
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, bean.getProductOid());
			ps.setString(2, bean.getDiaryTitle());
			ps.setString(3, bean.getZipCode());
			ps.setTimestamp(4, new Timestamp(bean.getDiaryCreateTime().getTime()));
			ps.setTimestamp(5, new Timestamp(bean.getDiaryStrTime().getTime()));
			ps.setTimestamp(6, new Timestamp(bean.getDiaryEndTime().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
