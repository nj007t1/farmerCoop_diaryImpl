package edu.ntut.java007.farmerCoop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SproductCategoryDAO {
	DataSource ds = null;
	
	public SproductCategoryDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/FarmerCoopDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<SproductCategory> categorylist() {
		List<SproductCategory> list = new ArrayList<>();
		String sql = "SELECT * FROM sproductcategory";
		SproductCategory sp = null;
		try (Connection con = ds.getConnection();
			PreparedStatement ps	= con.prepareStatement(sql);) {
			try(ResultSet rs = ps.executeQuery();){
				while (rs.next()) {
					
				}
			}
		} catch (Exception e) {
			
		}
		return list;
	}

}
