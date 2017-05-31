package dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class Dao {

	private static Connection con;
	public static Connection getCon(){
	//public static void main(String a[])
	
		
	try{
			 // Class.forName("oracle.jdbc.driver.OracleDriver");
			  Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
	
		//	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saurabh123");
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	}

