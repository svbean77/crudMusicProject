package model;

import java.sql.Date;

import vo.UserlistVO;

public class UserlistService {
	UserlistDAO userDao = new UserlistDAO();

	public int signin(String userid, String userpw) {
		return userDao.signin(userid, userpw);
	}

	public String signup(String user_id, String user_pw, String user_name, Date user_day, String user_email,
			char user_gender) {
		return userDao.signup(user_id, user_pw, user_name, user_day, user_email, user_gender);
	}

	public UserlistVO showInfo(int userno) {
		return userDao.showInfo(userno);
	}

	public String editInfo(String user_id, String user_pw, String user_name, Date user_day, String user_email,
			char user_gender) {
		return userDao.editInfo(user_id, user_pw, user_name, user_day, user_email, user_gender);
	}

	public String quitUser(int userno) {
		int result = userDao.quitUser(userno);
		return result > 0 ? "회원 탈퇴하였습니다." : "회원 탈퇴에 실패하였습니다.";
	}

	public int isExistUser(String userid, String username, String useremail) {
		return userDao.isExistUser(userid, username, useremail);
	}

	public String editPassword(String userpw, int userno) {
		int result = userDao.editPassword(userpw, userno);
		return result > 0 ? "비밀번호를 변경하였습니다." : "비밀번호 변경에 실패하였습니다.";
	}
}
