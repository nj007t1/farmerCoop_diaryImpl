package diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DiaryDAO {
	// DataSource ds = null;
	// 日誌主檔-相關功能
	public int createDiary(DiaryBean bean) {
		int updateCount = 0;
		StringBuffer sb = new StringBuffer("");
		sb.append("INSERT INTO sdiary (product_oid, diary_title, zip_code, diary_create_time,diary_str_time, diary_end_time) ");
		sb.append("VALUES ( ?, ?, ?, ?, ?, ?)");
		try (Connection con = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement pst = con.prepareStatement(sb.toString());) {
			pst.setInt(1, bean.getProductOid());
			pst.setString(2, bean.getDiaryTitle());
			pst.setString(3, bean.getZipCode());
			pst.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pst.setTimestamp(5, new Timestamp(bean.getDiaryStrTime().getTime()));
			pst.setTimestamp(6, new Timestamp(bean.getDiaryEndTime().getTime()));
			updateCount = pst.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public void updateDiary(DiaryBean bean) {
		StringBuffer sb = new StringBuffer("");
		sb.append("UPDATE sdiary SET");
		sb.append(" product_oid = ?, diary_title = ?,zip_code = ?, diary_str_time = ?, diary_end_time = ? where diary_oid = ? ");
		try (Connection con = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement pst = con.prepareStatement(sb.toString());) {
			pst.setInt(1, bean.getProductOid());
			pst.setString(2, bean.getDiaryTitle());
			pst.setString(3, bean.getZipCode());
			pst.setTimestamp(4, new Timestamp(bean.getDiaryStrTime().getTime()));
			pst.setTimestamp(5, new Timestamp(bean.getDiaryEndTime().getTime()));
			pst.setInt(6, bean.getDiaryOid());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteDiaryById(int id) {
		String sql = "DELETE FROM sdiary WHERE diary_oid = ?";
		try (Connection con = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<DiaryBean> showAllDiary(int userId) {
		List<DiaryBean> list = new ArrayList<>();
		String sql = "SELECT * FROM sdiary WHERE PRODUCT_OID IN" + " (SELECT PRODUCT_OID FROM sproduct WHERE"
				+ " USER_OID = ?)";
		DiaryBean db = null;
		try (Connection con = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					db = new DiaryBean();
					db.setDiaryOid(rs.getInt(1));
					db.setProductOid(rs.getInt(2));
					db.setDiaryTitle(rs.getString(3));
					db.setZipCode(rs.getString(4));
					db.setDiaryCreateTime(rs.getTimestamp(5));
					db.setDiaryStrTime(rs.getTimestamp(6));
					db.setDiaryEndTime(rs.getTimestamp(7));
					list.add(db);
					System.out.println(list.size());
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		System.out.println(list);
		return list;

	}

	// 日誌內文-相關功能
	public void createDiaryDtl(DiaryDtlBean bean) {
		String sql = "INSERT INTO sdiary_dtl ("
				+ " diary_dtl_oid, diary_oid, diary_dtl_img_url, diary_dtl_text_content, "
				+ " diary_dtl_img_date, diary_create_time, diary_update_time" + " ) " + " VALUES("
				+ "null, ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, bean.getDiary_oid());
			pst.setString(2, bean.getDiary_dtl_img_url());
			pst.setString(3, bean.getDiary_dtl_text_content());
			pst.setDate(4, bean.getDiary_dtl_img_date());
			pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pst.setTimestamp(6, new Timestamp(bean.diary_dtl_update_time.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
