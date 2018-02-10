package edu.ntut.java007.farmerCoop.model;

public class ProductMain {
	public static void main(String[] args) {
		SproductDao dao = new SproductDao();
		Sproduct pb = new Sproduct();
		pb.setProductOid(20);
		pb.setProductName("CC");
		pb.setProductImgUrl("BBD");
		pb.setProductInfo(null);
		pb.setUserOid(20);
		try {
			dao.insert(pb);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
