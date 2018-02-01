package product;

import java.io.Serializable;

import com.mysql.jdbc.Clob;

public class ProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	Integer productOid;
	String  productName;
	String  productImgUrl;
	Clob    productInfo;
	Integer userOid;
	String  productCatId;
	
	public ProductBean(Integer productOid, String productName, String productImgUrl, Clob productInfo, Integer userOid,
			String productCatId) {
		
		this.productOid = productOid;
		this.productName = productName;
		this.productImgUrl = productImgUrl;
		this.productInfo = productInfo;
		this.userOid = userOid;
		this.productCatId = productCatId;
	}
	public ProductBean() {
	}
	

	public Integer getProductOid() {
		return productOid;
	}

	public void setProductOid(Integer productOid) {
		this.productOid = productOid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public Clob getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(java.sql.Clob clob) {
		this.productInfo = (Clob) clob;
	}

	public Integer getUserOid() {
		return userOid;
	}

	public void setUserOid(Integer userOid) {
		this.userOid = userOid;
	}

	public String getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(String productCatId) {
		this.productCatId = productCatId;
	}
	
	

}
