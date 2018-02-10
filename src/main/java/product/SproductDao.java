package edu.ntut.java007.farmerCoop.model;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class SproductDao {
	 DataSource ds = null;
	 Connection con ;
	 public SproductDao()  {
		 //try {
	
			 try {
				con = DriverManager.getConnection( 
						 "jdbc:mysql://localhost:3306/fcdb?useSSL=true&useUnicode=yes&characterEncoding=utf8", 
					      "root","1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
//			 Context context = new InitialContext();   
//				ds = (DataSource) context.lookup("java:comp/env/jdbc/FarmerCoopDB");
//    	 connection = ds.getConnection();
//			} catch (NamingException e) {
//				e.printStackTrace();
			//}
		}
	 
	public void query(int productOid) throws SQLException{
		Sproduct bean = null;
		String sql = "SELECT * FROM sproduct WHERE product_oid = ?";
	    try(
 
	    	PreparedStatement ps = con.prepareStatement(sql);
	    	){
	    	ps.setInt(1, productOid);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new Sproduct();
					bean.setProductOid(rs.getInt(1));
					bean.setProductName(rs.getString(2));
					bean.setProductImgUrl(rs.getString(3));
					bean.setProductInfo(rs.getClob(4));
					bean.setUserOid(rs.getInt(5));
					bean.setProductCatId(rs.getString(6));
				}
			}
	    }catch (SQLException ex){
	    	  throw new RuntimeException(ex);
	    }
	  }
	
	public int insert(Sproduct product) throws SQLException {
		StringBuffer sb = new StringBuffer("");
		sb.append("INSERT INTO sproduct (product_name, product_img_url, product_info, user_oid, product_cat_id) ");
		sb.append("VALUES (?, ?, ?, ?, ?)");
		try (
//				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sb.toString());) {
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductImgUrl());
			ps.setClob(3, product.getProductInfo());
			ps.setInt(4, product.getUserOid());
			ps.setString(5, product.getProductCatId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Sproduct product){
		int n = 0;
		String sql = "UPDATE sproduct SET"
				+ " product_name= ?, product_img_url = ?, product_info= ?, user_oid=?, product_cat_id=?"
				+ " WHERE product_oid = ?";
		try (
//				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.clearParameters();
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductImgUrl());
			ps.setClob(3, product.getProductInfo());
			ps.setInt(4, product.getUserOid());
			ps.setString(5, product.getProductCatId());
			ps.setInt(6, product.getProductOid());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	public int delete(int productOid) throws SQLException {
		int n = 0;
		String sql = "DELETE FROM sproduct WHERE product_oid = ?";
		try (
//				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, productOid);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	public Sproduct findByPrimaryKey(int productOid) throws SQLException {
		Sproduct bean = null;
		String sql = "SELECT * FROM sproduct WHERE product_oid = ?";

		try (
//				Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, productOid);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new Sproduct();
					bean.setProductOid(rs.getInt(1));
					bean.setProductName(rs.getString(2));
					bean.setProductImgUrl(rs.getString(3));
					bean.setProductInfo(rs.getClob(4));
					bean.setUserOid(rs.getInt(5));
					bean.setProductCatId(rs.getString(6));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bean;
	}


}
