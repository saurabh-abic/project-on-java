package dto;

public class StudentMarkDto {
	private String roll;
	private int set;
	
	private String[] sub=new String[set];
	private String[] mark=new String[set];
	public String getRoll() {
		return roll;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String[] getSub() {
		return sub;
	}
	public void setSub(String[] sub) {
		this.sub = sub;
	}
	public String[] getMark() {
		return mark;
	}
	public void setMark(String[] mark) {
		this.mark = mark;
	}
   public void set(int count)
   {
	set=count;   
   }

}
