package dto;

public class updateAttendenceDto extends AttendenceDto{

private String present[];
private String absent[];
private int presentcount;
private int absentcount;
public int getPresentcount() {
	return presentcount;
}
public void setPresentcount(int presentcount) {
	this.presentcount = presentcount;
}
public int getAbsentcount() {
	return absentcount;
}
public void setAbsentcount(int absentcount) {
	this.absentcount = absentcount;
}
private String sub;
public String[] getPresent() {
	return present;
}
public void setPresent(String[] present) {
	this.present = present;
}
public String[] getAbsent() {
	return absent;
}
public void setAbsent(String[] absent) {
	this.absent = absent;
}
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}

}
