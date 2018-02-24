package edu.ntut.java007.farmerCoop.model;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class SproductDao {
	 DataSource ds = null;
	 Connection con ; 
	 public SproductDao() {
			 try {
				con = DriverManager.getConnection( 
						 "jdbc:mysql://localhost:3306/fcdb?useSSL=true&useUnicode=yes&characterEncoding=utf8", 
					      "root","1234");
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	 
		public Sproduct showSproductById(int id)  {
			Sproduct bean = null;
			String sql = "SELECT * FROM sproduct WHERE product_oid = ?";
			try (
//					Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				try (ResultSet rs = ps.executeQuery();) {
				  while (rs.next()) {
						int productOid = rs.getInt(1);
						String productName = rs.getString(2);
						String productImgUrl = rs.getString(3);
						Clob productInfo = rs.getClob(4);
						int userOid = rs.getInt(5);
						String productCatId = rs.getString(6);
						bean = new Sproduct(productOid, productName, productImgUrl, productInfo, userOid, productCatId);
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return bean;
		}
	 
		public void query() throws SQLException{
			Sproduct bean = null;
			String sql = "SELECT * FROM sproduct WHERE product_oid = ?";
		    try(	PreparedStatement ps = con.prepareStatement(sql);
		    		ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						bean = new Sproduct();
						bean.setProductOid(rs.getInt(1));
						bean.setProductName(rs.getString(2));
						bean.setProductImgUrl(rs.getString(3));
						bean.setProductInfo(rs.getClob(4));
						bean.setUserOid(rs.getInt(5));
						bean.setProductCatId(rs.getString(6));
				}
		    }catch (SQLException ex){
		    	  throw new RuntimeException(ex);
		    }
		  }
	 
//	public void query(int productOid) throws SQLException{
//		Sproduct bean = null;
//		String sql = "SELECT * FROM sproduct WHERE product_oid = ?";
//	    try(
//	    	PreparedStatement ps = con.prepareStatement(sql);
//	    	){
//	    	ps.setInt(1, productOid);
//			try (ResultSet rs = ps.executeQuery();) {
//				if (rs.next()) {
//					bean = new Sproduct();
//					bean.setProductOid(rs.getInt(1));
//					bean.setProductName(rs.getString(2));
//					bean.setProductImgUrl(rs.getString(3));
//					bean.setProductInfo(rs.getClob(4));
//					bean.setUserOid(rs.getInt(5));
//					bean.setProductCatId(rs.getString(6));
//				}
//			}
//	    }catch (SQLException ex){
//	    	  throw new RuntimeException(ex);
//	    }
//	  }
	
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


}
