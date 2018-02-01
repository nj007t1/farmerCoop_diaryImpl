package product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
//本類別負責讀取資料庫內eBook表格內某一頁的紀錄，並能新增紀錄、修改紀錄、刪除記錄等

public class ProductDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageNo = 0; // 存放目前顯示之頁面的編號
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 每頁三筆
	private int totalPages = -1;
	// DataSource ds = null;

	public void getConnection() throws SQLException {

	}

	public int getTotalPages() throws SQLException {
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsperPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public long getRecordCounts() {
		long count = 0;
		String sql = "SELECT count(*) FROM Product";
		try (Connection connection =DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return count;
	}

	public List<ProductBean> getAll() throws SQLException {
		List<ProductBean> products = new ArrayList<ProductBean>();
		String sql = "SELECT  " + "";
		// 由頁碼推算出該頁是由哪一筆紀錄開始(0 based)
		int startRecordNo = (pageNo - 1) * recordsPerPage;
		try (Connection connection = DriverManager.getConnection(SystemUtils.URL); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, startRecordNo);
			ps.setInt(2, recordsPerPage);
			try (ResultSet rs = ps.executeQuery();) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				while (rs.next()) {
					ProductBean bean = new ProductBean();
					bean.setProductOid(rs.getInt(1));
					bean.setProductName(rs.getString(2));
					bean.setProductImgUrl(rs.getString(3));
					bean.setProductInfo(rs.getClob(4));
					bean.setUserOid(rs.getInt(5));
					bean.setProductCatId(rs.getString(6));
					// 最後將BookBean物件放入大的容器內
					products.add(bean);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
		return products;
	}

	public int insert(ProductBean product) throws SQLException {
		return 0;
	}

	public int update(ProductBean product){
		int n = 0;
		String sql = "UPDATE sproduct SET"
				+ " product_name= ?, product_img_url = ?, product_info= ?, user_oid=?, product_cat_id=?"
				+ " WHERE product_oid = ?";
		try (Connection connection = DriverManager.getConnection(SystemUtils.URL); PreparedStatement ps = connection.prepareStatement(sql);){
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

	public int delete(int product_OID) throws SQLException {
		int n = 0;
		String sql = "DELETE FROM Book WHERE bookId = ?";

		try (Connection connection = DriverManager.getConnection(GlobalService.DB_MYSQL, GlobalService.USERID_MySQL,
				GlobalService.PSWD_MySQL); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, product_OID);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	// 查詢單筆紀錄
	public ProductBean findByPrimaryKey(int productOid) throws SQLException {
		ProductBean bean = null;
		String sql = "SELECT * FROM Product WHERE productOid = ?";

		try (Connection connection = DriverManager.getConnection(SystemUtils.URL); PreparedStatement ps = connection.prepareStatement(sql);){
			ps.setInt(1, productOid);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new ProductBean();
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

	public void save(ProductBean bean) {
//		String sql = "INSERT INTO sproduct "
//				+ "(product_name, product_img_url, product_info, user_oid, product_cat_id)"
//				+ " VALUES (?, ?, ?, ?, ?)";
		StringBuffer sb = new StringBuffer("");
		sb.append("INSERT INTO sproduct (product_name, product_img_url, product_info, user_oid, product_cat_id) ");
		sb.append("VALUES (?, ?, ?, ?, ?)");
		try (Connection connection = DriverManager.getConnection(SystemUtils.URL);
				PreparedStatement ps = connection.prepareStatement(sb.toString());) {
			ps.setString(1, bean.getProductName());
			ps.setString(2, bean.getProductImgUrl());
			ps.setClob(3, bean.getProductInfo());
			ps.setInt(4, bean.getUserOid());
			ps.setString(5, bean.getProductCatId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}