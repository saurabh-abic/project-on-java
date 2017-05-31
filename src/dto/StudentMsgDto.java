package dto;

public class StudentMsgDto { 
	private String roll;
	private String Amsg;
	private String AAmsg;
	public String getAAmsg() {
		return AAmsg;
	}
	public void setAAmsg(String aAmsg) {
		AAmsg = aAmsg;
	}
	private String msg;
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getAmsg() {
		return Amsg;
	}
	public void setAmsg(String msg) {
		this.Amsg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
