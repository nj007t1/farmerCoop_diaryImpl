package edu.ntut.java007.farmerCoop.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ZipCodeDAO {
	DataSource ds = null;
	ResultSet rs = null;
	Connection con ;  
	public ZipCodeDAO() {
		try {
			con = DriverManager.getConnection( 
					 "jdbc:mysql://localhost:3306/fcdb?useSSL=true&useUnicode=yes&characterEncoding=utf8", 
				      "root","1234");
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	public Szip showSzipById(int id)  {
		Szip bean = null;
		String sql = "SELECT * FROM szip WHERE zip_code = ?";
		try (
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();) 
		{
			  while (rs.next()) {
				  String zipCode = rs.getString("zipCode");
				  String zipCountyName = rs.getString("zipCountyName");
				  String zipTownName = rs.getString("zipTownName");
				  bean = new Szip(zipCode, zipCountyName, zipTownName);
				}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bean;
	}
}
