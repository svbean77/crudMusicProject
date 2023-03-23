package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.OracleUtil;
import vo.MusicVO;

public class PlaylistDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	CallableStatement cst;
	ResultSet rs;
	int resultCount;

//	플레이리스트 조회
	public List<MusicVO> showPlaylist(int userno) {
		String sql = """
				select *
				from playlist join music using (music_no)
				join userlist using (user_no)
				where user_no=?
				""";
		List<MusicVO> playlist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userno);
			rs = pst.executeQuery();

			while (rs.next()) {
				MusicVO music = makeMusic(rs);
				playlist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return playlist;
	}

//	플레이 리스트에 존재하는 노래인가
	public boolean isExistList(String title, String singer, int userno) {
		boolean result = false;
		String sql = """
				select *
				from playlist join music using (music_no)
				join userlist using (user_no)
				where music_name=?
				and singer=?
				and user_no=?
				""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, singer);
			pst.setInt(3, userno);
			rs = pst.executeQuery();
			
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return result;
	}

//	플레이 리스트에 노래 추가
	public int addPlaylist(String title, String singer, int userno) {
		String sql = """
				insert into playlist
				values (seq_playlist.nextval, (select music_no
				from music
				where music_name=? and singer=?), ?)
				""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, singer);
			pst.setInt(3, userno);
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

//	플레이 리스트에서 노래 삭제
	public int deletePlaylist(String title, String singer, int userno) {
		String sql = """
				delete from playlist
				where music_no=(select music_no
				    from music
				    where music_name=? and singer=?)
				and user_no=?
								""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, singer);
			pst.setInt(3, userno);
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

//	플레이리스트를 위한 노래
	private MusicVO makeMusic(ResultSet rs) throws SQLException {
		MusicVO music = new MusicVO();
		music.setMusic_no(rs.getInt("Music_no"));
		music.setMusic_name(rs.getString("Music_name"));
		music.setSinger(rs.getString("Singer"));
		music.setRelease_date(rs.getDate("Release_date"));
		return music;
	}
}
