package diary;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class DiaryDtlBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer diary_dtl_oid;
	Integer diary_oid;
	String diary_dtl_img_url;
	String diary_dtl_text_content;
	Date diary_dtl_img_date;
	Timestamp diary_dtl_create_time;
	Timestamp diary_dtl_update_time;
	public DiaryDtlBean() {
		super();
	}
	public DiaryDtlBean(Integer diary_dtl_oid, Integer diary_oid, String diary_dtl_img_url,
			String diary_dtl_text_content, Date diary_dtl_img_date, Timestamp diary_dtl_create_time,
			Timestamp diary_dtl_update_time) {
		super();
		this.diary_dtl_oid = diary_dtl_oid;
		this.diary_oid = diary_oid;
		this.diary_dtl_img_url = diary_dtl_img_url;
		this.diary_dtl_text_content = diary_dtl_text_content;
		this.diary_dtl_img_date = diary_dtl_img_date;
		this.diary_dtl_create_time = diary_dtl_create_time;
		this.diary_dtl_update_time = diary_dtl_update_time;
	}
	public Integer getDiary_dtl_oid() {
		return diary_dtl_oid;
	}
	public void setDiary_dtl_oid(Integer diary_dtl_oid) {
		this.diary_dtl_oid = diary_dtl_oid;
	}
	public Integer getDiary_oid() {
		return diary_oid;
	}
	public void setDiary_oid(Integer diary_oid) {
		this.diary_oid = diary_oid;
	}
	public String getDiary_dtl_img_url() {
		return diary_dtl_img_url;
	}
	public void setDiary_dtl_img_url(String diary_dtl_img_url) {
		this.diary_dtl_img_url = diary_dtl_img_url;
	}
	public String getDiary_dtl_text_content() {
		return diary_dtl_text_content;
	}
	public void setDiary_dtl_text_content(String diary_dtl_text_content) {
		this.diary_dtl_text_content = diary_dtl_text_content;
	}
	public Date getDiary_dtl_img_date() {
		return diary_dtl_img_date;
	}
	public void setDiary_dtl_img_date(Date diary_dtl_img_date) {
		this.diary_dtl_img_date = diary_dtl_img_date;
	}
	public Timestamp getDiary_dtl_create_time() {
		return diary_dtl_create_time;
	}
	public void setDiary_dtl_create_time(Timestamp diary_dtl_create_time) {
		this.diary_dtl_create_time = diary_dtl_create_time;
	}
	public Timestamp getDiary_dtl_update_time() {
		return diary_dtl_update_time;
	}
	public void setDiary_dtl_update_time(Timestamp diary_dtl_update_time) {
		this.diary_dtl_update_time = diary_dtl_update_time;
	}

	
}
