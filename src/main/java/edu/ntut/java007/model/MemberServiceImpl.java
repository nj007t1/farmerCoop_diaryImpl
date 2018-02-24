package edu.ntut.java007.farmerCoop.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


// 本類別負責讀取資料庫內eBookCompany表格內的紀錄
// 
public class MemberServiceImpl implements Serializable, MemberService {
	private static final long serialVersionUID = 1L;
	private String taguserName = "";
	private int selected = -1;
	private int userOid = 0;
	DataSource ds = null;

	public MemberServiceImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/sUserDataBase");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public MemberBean getMemberById(int userOid) {
		MemberBean mb = null;
		String sql = "SELECT * FROM suser WHERE UserOid= ?";
		try (Connection conn = ds.getConnection(); 
			 PreparedStatement stmt = conn.prepareStatement(sql);) {
			 stmt.setInt(1, userOid);
			 try (ResultSet rs = stmt.executeQuery();){
				 if (rs.next()) {
					 mb = new MemberBean();
					mb.setUserOid(rs.getInt(1));
					mb.setUserName(rs.getString(2));
					mb.setUserEmail(rs.getString(3));
					mb.setUserPasswd(rs.getString(4));
					mb.setUserStatus(rs.getString(5));
					mb.setUserZipCode(rs.getString(6));
					mb.setUserAddress(rs.getString(7));
					mb.setUserMobile(rs.getString(8));
					mb.setUserTel(rs.getString(9));
					mb.setUserTelExt(rs.getString(10));
					mb.setFarmerZipCode(rs.getString(11));
					mb.setFarmerAddress(rs.getString(12));
					mb.setFarmerMobile(rs.getString(13));
					mb.setFarmerTel(rs.getString(14));
					mb.setFarmerTelExt(rs.getString(15));
					mb.setFarmerProfile(rs.getString(16));
					mb.setUserLastLoginTime(rs.getTimestamp(17));
					mb.setUserApplyDate(rs.getTimestamp(18));
					mb.setUserEmailValCode(rs.getString(19));
				 }
			 }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mb;
	}



	public List<MemberBean> getMember() {
		List<MemberBean> list = new ArrayList<>();
		String sql = "SELECT * FROM suser";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				MemberBean cb = new MemberBean(rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(cb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getTaguserName() {
		return taguserName;
	}

	public void setTaguserName(String taguserName) {
		this.taguserName = taguserName;
	}

	public int getUserOid() {
		return userOid;
	}

	public void setUserOid(int userOid) {
		this.userOid = userOid;
	}

	public String getSelectTag() {
		String ans = "";
		List<MemberBean> cb = getMember();
		ans += "<SELECT name='" + getTaguserName() + "'>";
		for (MemberBean bean : cb) {
			int id = bean.getUserOid();
			String name = bean.getUserName().substring(0, 4);
			if (id == selected) {
				ans += "<option value='" + id + "' selected>" + name + "</option>";
			} else {
				ans += "<option value='" + id + "'>" + name + "</option>";
			}
		}
		ans += "</SELECT>";
		return ans;
	}



	@Override
	public MemberBean getMemberById() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setuserOid(int userOid) {
		// TODO Auto-generated method stub
		
	}

}