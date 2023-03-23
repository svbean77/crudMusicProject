package vo;

import java.sql.Date;

public class UserlistVO {
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private Date user_day;
	private String user_email;
	private char user_gender;

	public UserlistVO() {
	}

	public UserlistVO(int user_no, String user_id, String user_pw, String user_name, Date user_day, String user_email,
			char user_gender) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_day = user_day;
		this.user_email = user_email;
		this.user_gender = user_gender;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getUser_day() {
		return user_day;
	}

	public void setUser_day(Date user_day) {
		this.user_day = user_day;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public char getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(char user_gender) {
		this.user_gender = user_gender;
	}

	@Override
	public String toString() {
		String gender = user_gender=='M' ? "남자" : "여자";
		return "<" + user_id + "님의 회원정보>\n" + "이름: " + user_name + ", 생일: " + user_day + ", 이메일: " + user_email + ", 성별: "
				+ gender;
	}

}
