package product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

public class GlobalService {

	public static final String DB_MYSQL = "MYSQL";
	
	public static final String DB_TYPE = DB_MYSQL;

	public static final int RECORDS_PER_PAGE = 2;
	public static final String host = "127.0.0.1";
	public static final String SYSTEM_NAME = "小農合作社";
	public static final int IMAGE_FILENAME_LENGTH = 20;

	
	public static final String JNDI_DB_NAME = "java:comp/env/jdbc/BookDataSQLver";
	public static final String DBURL_MySQL 	= "jdbc:mysql://" + host + "/farmercoop?useUnicode=yes&characterEncoding=utf8&useSSL=true";
	public static final String USERID_MySQL 	= "root";
	public static final String PSWD_MySQL   = "1234";
	
	private static final String drop = "DROP Table IF EXISTS SProduct " ;
	
	private static final String CREATE_SProduct_MySQL = 
			"CREATE TABLE SProduct "
					  + "(product_oID     int(11) NOT NULL AUTO_INCREMENT Primary Key ,"
					  + "product_name     varchar(60) NOT NULL, "
					  + "product_img_url  varchar(2000) DEFAULT NULL, "
					  + "product_info     text, "
					  + "user_oid         int(11) NOT NULL, "
					  + "product_cat_id   varchar(3) NOT NULL, "
					  + "CONSTRAINT user_oid FOREIGN KEY (user_oid) REFERENCES suser(user_oid) ON DELETE NO ACTION"
					  + "CONSTRAINT product_cat_id FOREIGN KEY (product_cat_id) REFERENCES sproduct_category(product_cat_id) ON DELETE NO ACTION ON UPDATE CASCADE"
					  + ") ENGINE=InnoDB DEFAULT CHARSET=utf8"; 
	
	private static final String DROP_SProductCategory_MySQL = "DROP Table IF EXISTS SProductCategory " ;
	
	private static final String CREATE_SProductCategory_MySQL = 
			" CREATE TABLE SProductCategory " +
            "(product_cat_ID varchar(3) NOT NULL Auto_Increment, " +
            " product_cat_mname			varchar(20), " +
            " product_cat_sname   		varchar(20), " +
            " prooduct_cat_desc			varchar(300), " +            
            " PRIMARY KEY 		(product_cat_ID) " +
            " ) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci" ; 
	
}