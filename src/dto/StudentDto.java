package dto;

public class StudentDto {


	private String name;
	private String Roll;
	private String Fname;
	private String gender;
	private String Add;
	private String city;
	private String Password;
	private String state;
	private String dept;
	private String mob; 
   
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return Roll;
	}
	public void setRoll(String roll) {
		Roll = roll;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdd() {
		return Add;
	}
	public void setAdd(String add) {
		Add = add;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob2) {
		this.mob = mob2;
	}
	
}
