package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {

	private static AdminDao u=new AdminDao();
	static Connection  con;
//	public static int flag=0;
		 public AdminDao() {
			con=Dao.getCon();
		}
		public static  AdminDao getAdminDao(){
			return u;
		}

		public int studentUpdate(String dept,String roll){
			int flag=0;
			try {
				PreparedStatement ps=con.prepareStatement("update studentinfo SET dept=? where Roll=?");
		
			     ps.setString(1,dept);
			     ps.setString(2,roll);
			     ps.executeUpdate(); 
			     flag=1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=0;
			}
			return flag;
		}
		
}
