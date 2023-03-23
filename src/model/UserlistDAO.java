package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import utils.OracleUtil;
import vo.UserlistVO;

public class UserlistDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	CallableStatement cst;
	ResultSet rs;
	int resultCount;

//	로그인
	public int signin(String userid, String userpw) {
		String sql = """
				select user_no
				from userlist
				where user_id=? and user_pw=?
				""";
		int user = 0;

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, userpw);
			rs = pst.executeQuery();

			while (rs.next()) {
				user = rs.getInt("user_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return user;
	}

//	회원가입
	public String signup(String user_id, String user_pw, String user_name, Date user_day, String user_email,
			char user_gender) {
		String sql = "{call p_signup(seq_user.nextval, ?, ?, ?, ?, ?, ?, ?)}";
		String message = null;

		conn = OracleUtil.getConnection();
		try {
			cst = conn.prepareCall(sql);
			cst.setString(1, user_id);
			cst.setString(2, user_pw);
			cst.setString(3, user_name);
			cst.setDate(4, user_day);
			cst.setString(5, user_email);
			cst.setString(6, Character.toString(user_gender));
			cst.registerOutParameter(7, Types.VARCHAR);
			cst.execute();

			message = cst.getString(7);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, cst, conn);
		}
		return message;
	}

//	내 정보 조회
	public UserlistVO showInfo(int userno) {
		String sql = "select * from userlist where user_no=" + userno;
		UserlistVO user = null;

		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				user = makeUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return user;
	}

//	내 정보 수정
	public String editInfo(String user_id, String user_pw, String user_name, Date user_day, String user_email,
			char user_gender) {
		String sql = "{call p_editInfo(?, ?, ?, ?, ?, ?, ?)}";
		String message = null;

		conn = OracleUtil.getConnection();
		try {
			cst = conn.prepareCall(sql);
			cst.setString(1, user_id);
			cst.setString(2, user_pw);
			cst.setString(3, user_name);
			cst.setDate(4, user_day);
			cst.setString(5, user_email);
			cst.setString(6, Character.toString(user_gender));
			cst.registerOutParameter(7, Types.VARCHAR);
			cst.execute();

			message = cst.getString(7);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, cst, conn);
		}
		return message;
	}

//	회원 탈퇴
	public int quitUser(int userno) {
		String sql = "delete from userlist where user_no=?";

		try {
			conn = OracleUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userno);
			resultCount = pst.executeUpdate();

		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, st, conn);
		}

		return resultCount;
	}

//	존재하는 회원인지 확인
	public int isExistUser(String userid, String username, String useremail) {
		String sql = """
				select user_no
				from userlist
				where user_id=?
				and user_name=?
				and user_email=?
								""";
		int user = 0;

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, username);
			pst.setString(3, useremail);
			rs = pst.executeQuery();

			while (rs.next()) {
				user = rs.getInt("user_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return user;
	}

//	비밀번호 변경
	public int editPassword(String userpw, int userno) {
		String sql = """
				update userlist
				set user_pw=?
				where user_no=?
					 """;

		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userpw);
			pst.setInt(2, userno);
			resultCount = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

	private UserlistVO makeUser(ResultSet rs) throws SQLException {
		UserlistVO user = new UserlistVO();

		user.setUser_id(rs.getString("user_id"));
		user.setUser_pw(rs.getString("user_pw"));
		user.setUser_name(rs.getString("user_name"));
		user.setUser_day(rs.getDate("user_day"));
		user.setUser_email(rs.getString("user_email"));
		user.setUser_gender(rs.getString("user_gender").charAt(0));

		return user;
	}
}
