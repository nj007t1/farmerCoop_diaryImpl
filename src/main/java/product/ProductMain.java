package product;

public class ProductMain {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		ProductBean pb = new ProductBean();
		pb.setProductOid(20);
		pb.setProductName("CC");
		pb.setProductImgUrl("BBD");
		pb.setProductInfo(null);
		pb.setUserOid(20);

		try {
			dao.update(pb);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
