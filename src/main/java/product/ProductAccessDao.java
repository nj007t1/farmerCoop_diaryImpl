package product;

import java.sql.SQLException;
import java.util.List;

public interface ProductAccessDao {//DAO上面指派下來的介面
		public void getConnection() throws SQLException;
		public int getTotalPages() throws SQLException;
		public List<ProductBean> getAll() throws SQLException;
		public int getPageNo();
		public void setPageNo(int pageNo);
		public int getRecordsPerPage();
		public void setRecordsperPage(int recordsPerPage);
		public long getRecordCounts() throws SQLException;
		public int insert(ProductBean product) throws SQLException;
		public int update(ProductBean product) throws SQLException;
		public int delete(int productOid) throws SQLException;
		public ProductBean findByPrimaryKey(int productOid) throws SQLException;
		int save(ProductBean product);
}// end of class IProductDAO


