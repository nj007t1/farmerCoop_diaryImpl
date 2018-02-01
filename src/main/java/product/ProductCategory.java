package product;

import java.io.Serializable;

public class ProductCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	String productCatId;
	String productCatMname;
	String productCatSname;
	String productCatDesc;
	
	public ProductCategory(String productCatId, String productCatMname, String productCatSname, String productCatDesc) {
		this.productCatId = productCatId;
		this.productCatMname = productCatMname;
		this.productCatSname = productCatSname;
		this.productCatDesc = productCatDesc;
	}

	public String getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(String productCatId) {
		this.productCatId = productCatId;
	}

	public String getProductCatMname() {
		return productCatMname;
	}

	public void setProductCatMname(String productCatMname) {
		this.productCatMname = productCatMname;
	}

	public String getProductCatSname() {
		return productCatSname;
	}

	public void setProductCatSname(String productCatSname) {
		this.productCatSname = productCatSname;
	}

	public String getProductCatDesc() {
		return productCatDesc;
	}

	public void setProductCatDesc(String productCatDesc) {
		this.productCatDesc = productCatDesc;
	}
	
	
	
}
