package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSetMetaData;

import dto.StudentAttendenceDto;
import dto.StudentDto;
import dto.StudentMarkDto;
import dto.StudentMsgDto;
import dto.StudentTransportDto;
import ui.StudentMainPage;



public class StudentDao {
	
	private static StudentDao u=new StudentDao();
	static Connection  con;
	public static int flag=0;
		 public StudentDao() {
			con=Dao.getCon();
		}
		public static  StudentDao getStudentDao(){
			return u;
		}
		
		
		public int insert(StudentDto u){
			int i=0;
			try{
			if(u.getMob().length()>10)
			{
				JOptionPane.showMessageDialog(null,"enter correct mobile no.");
			}
				
				
			PreparedStatement ps=con.prepareStatement("insert into studentinfo (Name,Roll,Fname,gender,State,City,Address,Contact,Dept,Password)" + "values(?,?,?,?,?,?,?,?,?,?)");	
			ps.setString(1, u.getName());
			ps.setString(2, u.getRoll());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getGender());
			ps.setString(6, u.getCity());
			ps.setString(5, u.getState());
		    ps.setString(7, u.getAdd());
			ps.setString(9, u.getDept());
			//ps.setInt(8, u.getMob());
			ps.setString(8,u.getMob());
			
		    ps.setString(10,u.getPassword());
			i=ps.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(""+e);
			}
			return i;

		}
		
		public int loginStudent(String roll,String pass){
			StudentDto so=null;
			
		
			int i=0;
			
			
			
			try {
				PreparedStatement ps=con.prepareStatement("select * from studentinfo where Roll=? and Password=?");
		
				
			ps.setString(1,roll);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery(); 
			   
			
			if(rs.next())
			{
		       
				 i=1;
				
			 
			 
						so=new StudentDto();
				so.setName( rs.getString(1));
				so.setRoll( rs.getString(2));
				so.setFname( rs.getString(3));
				so.setGender( rs.getString(4));
				so.setCity( rs.getString(6));
				so.setState( rs.getString(5));
			    so.setAdd( rs.getString(7));
				so.setDept( rs.getString(9));
				so.setMob(rs.getString(8));
			    so.setPassword(rs.getString(10)); 
		       new StudentMainPage(so).setVisible(true); 
			   System.out.println("datails available");
	     		
			}
			else
			{
				System.out.println("not available");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return i;
		}

		
		public int updateStudent(StudentDto u) 
		{
			int flag=0;
			try {
				PreparedStatement ps=con.prepareStatement("update studentinfo SET Address=?,State=?,City=? where Roll=?");
		
			     ps.setString(1,u.getAdd());
			     ps.setString(2,u.getState());
			     ps.setString(3, u.getCity());
			     ps.setString(4,u.getRoll());
			     ps.executeUpdate(); 
			     flag=1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=0;
			}
			return flag;
		}
   		
		public static StudentMarkDto studentMarks(String roll)
		{
			StudentMarkDto mt=null;
			ResultSet rs;
			int count=0;
			
			String[] Name=new String[10];
			String[] Mark=new String[10];
			try{
				PreparedStatement ps=con.prepareStatement("select * from marks where roll=?");
				ps.setString(1,roll);
				 rs=ps.executeQuery();
				if(rs.next()){
				mt=new StudentMarkDto();
			
				ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
				 count=rsmd.getColumnCount();
				System.out.println(count);
				for(int i=1;i<=count;i++)
				{
					 Name[i-1]=rsmd.getColumnName(i);
					 Mark[i-1]=String.valueOf(rs.getInt(Name[i-1]));
			        
					
					 
				     System.out.println(Name[i-1]);
				     System.out.println(Mark[i-1]);
				}
			}
			}
			catch (Exception e){
				System.out.println(e);
			}
			
			 mt.setSet(count);
			 mt.setSub(Name);
			 mt.setMark((Mark));
		return mt;
	}		
	public void downloadImage(String name) throws IOException
	{
		try {
			PreparedStatement ps=con.prepareStatement("select image from image where id=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
            
            
            if(rs.next())
            {
            	InputStream fi= rs.getBinaryStream(1);
                OutputStream fo=new FileOutputStream(new File("C:\\Users\\Saurabh\\Desktop","timetable1.jpeg"));  
               
				int c = 0;
				while ((c = fi.read()) !=-1) 
				{
					fo.write(c);
					
				}
            fi.close();
            fo.close();
            }
            
         	} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
			
		public StudentMsgDto studentMsg(String roll)
		{
			StudentMsgDto smt=null;
			String roll1="all";
			String roll2="everyone";
		   try {
			   smt=new  StudentMsgDto();
			PreparedStatement ps=con.prepareStatement("select * from msg where roll=?");
		    ps.setString(1,roll1); 
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				smt.setAmsg(rs.getString(2));
			}
			PreparedStatement ps1=con.prepareStatement("select * from  msg where roll=?");
			ps1.setString(1, roll);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				smt.setMsg( rs1.getString(2).replace("_"," "));
			}
			PreparedStatement ps2=con.prepareStatement("select * from msg where roll=?");
		    ps2.setString(1,roll2); 
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()){
				smt.setAAmsg(rs2.getString(2));
			}
		   } catch (SQLException e) {
			e.printStackTrace();
		}
			
			return smt;
		}
     public int studentTransport(StudentTransportDto stt){
    	 int i=0;
     
     try {
		PreparedStatement ps=con.prepareStatement("insert into transport (name,roll,branch,pickup) values(?,?,?,?)");
		ps.setString(1, stt.getName());
		ps.setString(2, stt.getRoll());
		ps.setString(3, stt.getBranch());
		ps.setString(4, stt.getPickup());
		 i=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return i;
     }
public int studentHostel(String roll,String msg){
int i=0;
try {
	PreparedStatement ps=con.prepareStatement("insert into hostelcomplaint(roll,msg) values(?,?)");
	ps.setString(1,roll);
	ps.setString(2, msg);
     i=ps.executeUpdate();
} catch (SQLException e) {
	i=0;
}
return i;
}

public StudentAttendenceDto studentAttendence(String roll){
	
	StudentAttendenceDto sa=null;
	try {
		    sa=new StudentAttendenceDto();
		PreparedStatement ps=con.prepareStatement("select * from attendence where roll=?");
	        ps.setString(1, roll);
	        ResultSet rs=ps.executeQuery();
	         if(rs.next()){
	        	 sa.setDm(rs.getInt(2));
	        	 sa.setCd( rs.getInt(3));
	        	 sa.setSe(rs.getInt(4));
	        	 sa.setCn( rs.getInt(5));
	        	 sa.setIm( rs.getInt(6));
	        	 sa.setPa( rs.getInt(7));
	        	 sa.setTdm(rs.getInt(8));
		         sa.setTcd( rs.getInt(9));
		      	 sa.setTse(rs.getInt(10));
		      	 sa.setTcn( rs.getInt(11));
		      	 sa.setTim( rs.getInt(12));
		      	 sa.setTpa( rs.getInt(13));
	        	
	        	
	         }
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return sa;
	
}
}
