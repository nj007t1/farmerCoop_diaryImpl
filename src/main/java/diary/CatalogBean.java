package diary;

public class CatalogBean {
	Integer productCatId;
	String productCatMName;
	String productCatSName;
	String productCatDesc;
	
	public CatalogBean() {
		super();
	}

	public CatalogBean(Integer productCatId, String productCatMName, String productCatSName, String productCatDesc) {
		super();
		this.productCatId = productCatId;
		this.productCatMName = productCatMName;
		this.productCatSName = productCatSName;
		this.productCatDesc = productCatDesc;
	}

	public Integer getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(Integer productCatId) {
		this.productCatId = productCatId;
	}

	public String getProductCatMName() {
		return productCatMName;
	}

	public void setProductCatMName(String productCatMName) {
		this.productCatMName = productCatMName;
	}

	public String getProductCatSName() {
		return productCatSName;
	}

	public void setProductCatSName(String productCatSName) {
		this.productCatSName = productCatSName;
	}

	public String getProductCatDesc() {
		return productCatDesc;
	}

	public void setProductCatDesc(String productCatDesc) {
		this.productCatDesc = productCatDesc;
	}

	@Override
	public String toString() {
		return "CatalogBean [productCatId=" + productCatId + ", productCatMName=" + productCatMName
				+ ", productCatSName=" + productCatSName + ", productCatDesc=" + productCatDesc + "]";
	}
	

}
