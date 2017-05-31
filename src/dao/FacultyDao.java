package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import dto.AttendenceDto;
import dto.FacultyDto;
import dto.MarkDto;
import dto.StudentDto;
import dto.updateAttendenceDto;
import ui.FacultyAttendence1;
import ui.FacultyMainPage;

public class FacultyDao {
	
	private static FacultyDao u=new FacultyDao();
    static Connection  con;
	public static int flag=0;
	public static int flag2=0;
	
		 public FacultyDao() {
			con=(Connection) Dao.getCon();
		}
		public static  FacultyDao getFacultyDao(){
			return u;
		}
		
		
		public int insert(FacultyDto u){
			int i=0;
			
				try{
				
			PreparedStatement ps=con.prepareStatement("insert into facultyinfo (Name,Id,Fname,gender,State,City,Address,Contact,Dept,Password,subject)" + "values(?,?,?,?,?,?,?,?,?,?,?)");	
			ps.setString(1, u.getName());
			ps.setString(2, u.getId());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getGender());
			ps.setString(6, u.getCity());
			ps.setString(5, u.getState());
		    ps.setString(7, u.getAdd());
			ps.setString(9, u.getDept());
			//ps.setInt(8, u.getMob());
			ps.setLong(8,u.getMob());
			
		    ps.setString(10,u.getPassword());
		    ps.setString(11,u.getSub());
			i=ps.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(""+e);
			}
			return i;

		}

		
		// login
		public int loginFaculty(String id,String pass){
			FacultyDto ft=null; 
		
			
		try {
				PreparedStatement ps=con.prepareStatement("select * from facultyinfo where ID=? and Password=?");
		
				
			ps.setString(1,id);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery(); 
			   
			
			if(rs.next())
			{
		       
				
				
			 flag=1;
			 
						ft=new FacultyDto();
				ft.setName( rs.getString(1));
				ft.setId( rs.getString(2));
				ft.setFname( rs.getString(3));
				ft.setGender( rs.getString(4));
				ft.setCity( rs.getString(6));
				ft.setState( rs.getString(5));
			    ft.setAdd( rs.getString(7));
				ft.setDept( rs.getString(9));
				ft.setMob(rs.getLong(8));
				ft.setPassword(rs.getString(10)); 
			    ft.setSub(rs.getString(11));
			   
			  // FacultyLogin(ft);
		       new FacultyMainPage(ft).setVisible(true); 
			//   System.out.println("datails available");
	     		
			}
			else
			{
				System.out.println("not available");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return flag;
		}
		
		
		//update
		public int updateFaculty(FacultyDto u) 
		{
			int i=0;
			try {
				PreparedStatement ps=con.prepareStatement("update facultyinfo SET Fname=?,Address=?,State=?,City=?,Contact=?,Password=? where ID=?");
		
			     ps.setString(1,u.getFname());
			     ps.setString(2,u.getAdd());
			     ps.setString(3,u.getState());
			     ps.setString(4,u.getCity());
			     ps.setLong(5,u.getMob());
			     ps.setString(6, u.getPassword());
			     ps.setString(7, u.getId());
			     ps.executeUpdate(); 
			     System.out.println("update");
			     i=1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			i=0;
			}
			return i;
		}

		
		//search
		public static  StudentDto studentSearch(String roll) 
   {        StudentDto st=null;
    try {
		PreparedStatement ps=con.prepareStatement("select * from studentinfo where roll=?");
		ps.setString(1,roll);
	    ResultSet rs=ps.executeQuery();
	    if(rs.next())
	    {
	    	flag=1;
	    	st=new StudentDto();
			st.setName( rs.getString(1));
			st.setRoll( rs.getString(2));
			st.setFname( rs.getString(3));
			st.setGender( rs.getString(4));
			st.setCity( rs.getString(6));
			st.setState( rs.getString(5));
		    st.setAdd( rs.getString(7));
			st.setDept( rs.getString(9));
			st.setMob(rs.getString(8));
		    //st.setPassword(rs.getString(10)); 
	    //    new FacultyStudentDetails(st).setVisible(true);
			
	         System.out.println("details Available");
	    }
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null,"Enter Correct Roll no.");
		}
	
	
return st;
}
		
		
		
public int marks(MarkDto mt)
{
	int count=0;
	int flag=0;
	String[] Name=new String[10];
	String sub=mt.getSub();
	String roll=mt.getRoll();
  	System.out.println("return");
		
		try {
			    PreparedStatement ps1=con.prepareStatement("select * from marks where roll=?");
			    ps1.setString(1,mt.getRoll());
			    ResultSet rs=ps1.executeQuery();
			    if(rs.next())
			    {
			    	System.out.println("1");
			    	flag=1;
			    	PreparedStatement ps2=con.prepareStatement("select * from marks");
			    	ResultSet rs1=ps2.executeQuery();
			    	ResultSetMetaData rsmd=(ResultSetMetaData) rs1.getMetaData();
					 count=rsmd.getColumnCount();
					 System.out.println(count);
					 for(int i=1;i<=count;i++)
						{
							 Name[i-1]=rsmd.getColumnName(i);
						}
					 if(Arrays.asList(Name).contains(sub)) //check
					    {
						 System.out.println("2");
						 flag=1;
					    	PreparedStatement ps3=con.prepareStatement("update marks set "+ sub +"=? where roll=?");
					    	ps3.setString(2,mt.getRoll());
				         	ps3.setInt(1,mt.getMark());
				         	ps3.executeUpdate();
					    }
							
					 else
					 {
						 System.out.println("3");
						 flag=1;
			    	Statement s=(Statement) con.createStatement();
		         	s.executeUpdate("alter table marks ADD "+sub+" Int "); 
		         	 PreparedStatement ps3=con.prepareStatement("update marks set " + sub +" =? where roll=?");
		         	 ps3.setString(2, roll);
		         	 ps3.setInt(1,mt.getMark());
		         	 ps3.executeUpdate();
			    }
			    }
			    else{
			    	System.out.println("4");
			    	flag=1;
			    	PreparedStatement ps2=con.prepareStatement("select * from marks");
			    	ResultSet rs1=ps2.executeQuery();
			    	ResultSetMetaData rsmd=(ResultSetMetaData) rs1.getMetaData();
					 count=rsmd.getColumnCount();
					 System.out.println(count);
					 for(int i=1;i<=count;i++)
						{
							 Name[i-1]=rsmd.getColumnName(i);
						}
					        
					    if(Arrays.asList(Name).contains(sub)) //check
					    {
					    	System.out.println("5");
					    	flag=1;
					    	System.out.println("here");
					    	PreparedStatement ps3=con.prepareStatement("insert into marks ( roll,"+sub+")"+"values(?,?)");
					    	ps3.setString(1,mt.getRoll());
				         	ps3.setInt(2,mt.getMark());
				         	ps3.executeUpdate();
					    }
							
					    else
					    {				 
					    	System.out.println("6");
					    	flag=1;
				Statement s1=(Statement) con.createStatement();
	         	s1.executeUpdate("alter table marks ADD "+sub+" Int ");
	              
	         	PreparedStatement ps=con.prepareStatement("insert into marks ( roll,"+sub+")"+"values(?,?)");
	         	ps.setString(1,mt.getRoll());
	         	ps.setInt(2,mt.getMark());
	         	int i=ps.executeUpdate();
	         	System.out.print("done");
				}
			    }
		}
			catch (SQLException e) {
				
				e.printStackTrace();
				flag=0;
				}
		
		
		return flag;
}

public void uploadImage(String name) throws  SQLException, FileNotFoundException
{
	
File file=new File("C:\\Users\\Saurabh\\Desktop","timetable.jpeg");	
FileInputStream fi=new FileInputStream(file);

PreparedStatement pre =
con.prepareStatement("insert into Image values(?,?,?)");

pre.setString(1,name);
pre.setInt(2,3);
pre.setBinaryStream(3,fi,(int)file.length());
pre.executeUpdate();
System.out.println("Successfully inserted the file into the database!");
}

public AttendenceDto attendence()
{  
	AttendenceDto at=new AttendenceDto();
	String[] roll=new String[10];
	int i=0;

try {
	PreparedStatement ps=con.prepareStatement("select roll from studentinfo");
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    { 
    	roll[i]=String.valueOf(rs.getInt(1));
    	
     i++;
     }
    at.setCount(i);
    at.setRoll(roll);
   System.out.println(i);
} catch (SQLException e) {
	System.out.println(e);
}
return at;
}

public int updateAttendence( updateAttendenceDto ua)
{
    String sub=ua.getSub();
    String totallecture=sub+"_lecture";
    String[] present=ua.getPresent();
    int presentcount=ua.getPresentcount();
    int last=0;
    String roll[]=new String[presentcount];
    int x=1;
    int flag=0;
   // int totalLecture=FacultyAttendence1.update;
    int update=1;
   
    
    for(int i=0;i<roll.length;i++)
    
   try {
	   flag=1;
	  PreparedStatement ps=con.prepareStatement("select * from attendence where roll=?");
	  ps.setString(1, present[i]);
	  ResultSet rs=ps.executeQuery();
	  if(rs.next())
	  {
		   update=rs.getInt(sub);
		   last=rs.getInt(totallecture);
		   update++;
		  
		  PreparedStatement ps1=con.prepareStatement("update attendence set "+ sub +"=? where roll=?");
		  ps1.setInt(1, update);
		  ps1.setString(2, present[i]);
		  ps1.executeUpdate();
		
		   }
	  
	  
	  else
	  {
	     
		PreparedStatement ps2=con.prepareStatement("insert into attendence(roll,"+ sub +") values(?,?)");
	    ps2.setString(1, present[i]);
	    ps2.setInt(2, x);
	    ps2.executeUpdate();
	  } 
	 
	   } catch (SQLException e) {
		   flag=0;
	
		   e.printStackTrace();
   }
    

	try {
		last++;
	    PreparedStatement ps2 = con.prepareStatement("update attendence set "+ totallecture +"=?");
		ps2.setInt(1,last);
	    ps2.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return flag;     
}
    

public int facultyMsg(String msg,String roll){
	
int i=0;
if(roll.equals("all")){
try {
	PreparedStatement ps=con.prepareStatement("select roll from msg where roll=?");
	ps.setString(1, roll);
       ResultSet rs=ps.executeQuery();
       if(rs.next())
       {
    	   PreparedStatement ps1=con.prepareStatement("update msg set msg=? where roll=? ");
    	   ps1.setString(1, msg);
    	   ps1.setString(2,roll);
    	   ps1.executeUpdate();
       i=1;
       }

              
       else
       {
    	PreparedStatement ps1=con.prepareStatement("insert into msg(roll,msg) values(?,?)");
    	ps1.setString(1, roll);
    	ps1.setString(2, msg);
    	ps1.executeUpdate();
    	 i=1; 
       }
}

catch (SQLException e) {
	e.printStackTrace();
}
}
else if(roll.equals("everyone")){
	
	try {
		PreparedStatement ps=con.prepareStatement("select roll from msg where roll=?");
		ps.setString(1, roll);
	       ResultSet rs=ps.executeQuery();
	       if(rs.next())
	       {
	    	   PreparedStatement ps1=con.prepareStatement("update msg set msg=? where roll=? ");
	    	   ps1.setString(1, msg);
	    	   ps1.setString(2,roll);
	           ps1.executeUpdate();
	    	   i=1;
	       }

	              
	       else
	       {
	    	PreparedStatement ps1=con.prepareStatement("insert into msg(roll,msg) values(?,?)");
	    	ps1.setString(1, roll);
	    	ps1.setString(2, msg);
	    	ps1.executeUpdate();
	    	 i=1; 
	       }
	}

	catch (SQLException e) {
		e.printStackTrace();
		i=0;
	}
}
else
{
	try {
		PreparedStatement ps=con.prepareStatement("select roll from msg where roll=?");
		ps.setString(1,roll);
		ResultSet rs=ps.executeQuery();
	  if(rs.next())
	  {
		  PreparedStatement ps1=con.prepareStatement("update msg set msg=? where roll=?");
		  ps1.setString(1,msg);
		  ps1.setString(2,roll);
		 ps1.executeUpdate();
	  i=1;
	  }
	  else
	  {
		  PreparedStatement ps1=con.prepareStatement("insert into msg (roll,msg) values(?,?)");
		  ps1.setString(1,roll);
		  ps1.setString(2, msg);
		  ps1.executeUpdate();
	  i=1;
	  }
	} catch (SQLException e) {
		
	}
	
}
return i;
}

}



		