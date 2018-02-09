package diary;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class DiaryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer diaryOid;
	Integer productOid;
	String diaryTitle;
	String zipCode;
	Timestamp diaryCreateTime;
	Date diaryStrTime;
	Date diaryEndTime;
	
	public DiaryBean() {
		super();
	}







	public DiaryBean(Integer productOid, String diaryTitle, String zipCode, Timestamp diaryCreateTime) {
		super();
		this.productOid = productOid;
		this.diaryTitle = diaryTitle;
		this.zipCode = zipCode;
		this.diaryCreateTime = diaryCreateTime;
	}


	public DiaryBean(Integer diaryOid, Integer productOid, String diaryTitle, String zipCode, Date diaryStrTime,
			Date diaryEndTime) {
		super();
		this.diaryOid = diaryOid;
		this.productOid = productOid;
		this.diaryTitle = diaryTitle;
		this.zipCode = zipCode;
		this.diaryStrTime = diaryStrTime;
		this.diaryEndTime = diaryEndTime;
	}







	public DiaryBean(Integer diaryOid, Integer productOid, String diaryTitle, String zipCode, Timestamp diaryCreateTime,
			Date diaryStrTime, Date diaryEndTime) {
		super();
		this.diaryOid = diaryOid;
		this.productOid = productOid;
		this.diaryTitle = diaryTitle;
		this.zipCode = zipCode;
		this.diaryCreateTime = diaryCreateTime;
		this.diaryStrTime = diaryStrTime;
		this.diaryEndTime = diaryEndTime;
	}






	public Integer getDiaryOid() {
		return diaryOid;
	}




	public void setDiaryOid(Integer diaryOid) {
		this.diaryOid = diaryOid;
	}




	public Integer getProductOid() {
		return productOid;
	}




	public void setProductOid(Integer productOid) {
		this.productOid = productOid;
	}




	public String getDiaryTitle() {
		return diaryTitle;
	}




	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}




	public String getZipCode() {
		return zipCode;
	}




	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}




	public Timestamp getDiaryCreateTime() {
		return diaryCreateTime;
	}




	public void setDiaryCreateTime(Timestamp diaryCreateTime) {
		this.diaryCreateTime = diaryCreateTime;
	}




	public Date getDiaryStrTime() {
		return diaryStrTime;
	}




	public void setDiaryStrTime(Date diaryStrTime) {
		this.diaryStrTime = diaryStrTime;
	}




	public Date getDiaryEndTime() {
		return diaryEndTime;
	}




	public void setDiaryEndTime(Date diaryEndTime) {
		this.diaryEndTime = diaryEndTime;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "DiaryBean [diaryOid=" + diaryOid + ", productOid=" + productOid + ", diaryTitle=" + diaryTitle
				+ ", zipCode=" + zipCode + ", diaryCreateTime=" + diaryCreateTime + ", diaryStrTime=" + diaryStrTime
				+ ", diaryEndTime=" + diaryEndTime + "]";
	}




	
}