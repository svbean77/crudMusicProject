package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.OracleUtil;
import vo.MusicVO;

public class MusicDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	CallableStatement cst;
	ResultSet rs;
	int resultCount;

//	전체 인기 차트
	public List<Map<MusicVO, Integer>> selectAllChart(int ranking) {
		String sql = """
				select rownum, music_name, singer, release_date, sorted.개수
				from music, (select music_no, count(*) 개수
				    from music join playlist using (music_no)
				    group by music_no, music_name
				    order by 개수 desc, music_name asc) sorted
				where sorted.music_no=music.music_no
				and rownum <= ?
					""";
		List<Map<MusicVO, Integer>> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ranking);
			rs = pst.executeQuery();

			while (rs.next()) {
				Map<MusicVO, Integer> music = makeChart(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	남성 인기 차트
	public List<Map<MusicVO, Integer>> selectManChart(int ranking) {
		String sql = """
				select rownum, music_name, singer, release_date, sorted.개수
				from music, (select music_no, count(*) 개수
				    from music join playlist using (music_no)
				    join userlist using (user_no)
				    group by music_no, user_gender, music_name
				    having user_gender='M'
				    order by 개수 desc, music_name asc) sorted
				where sorted.music_no=music.music_no
				and rownum <= ?
					""";
		List<Map<MusicVO, Integer>> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ranking);
			rs = pst.executeQuery();

			while (rs.next()) {
				Map<MusicVO, Integer> music = makeChart(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	여성 인기 차트
	public List<Map<MusicVO, Integer>> selectWomanChart(int ranking) {
		String sql = """
				select rownum, music_name, singer, release_date, sorted.개수
				from music, (select music_no, count(*) 개수
				    from music join playlist using (music_no)
				    join userlist using (user_no)
				    group by music_no, user_gender, music_name
				    having user_gender='W'
				    order by 개수 desc, music_name asc) sorted
				where sorted.music_no=music.music_no
				and rownum <= ?
					""";
		List<Map<MusicVO, Integer>> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ranking);
			rs = pst.executeQuery();

			while (rs.next()) {
				Map<MusicVO, Integer> music = makeChart(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	연도별 인기 차트
	public List<Map<MusicVO, Integer>> selectYearChart(int ranking, int year) {
		String sql = """
				select rownum, music_name, singer, release_date, sorted.개수
				from music, (select music_no, count(*) 개수
				    from music join playlist using(music_no)
				    where to_char(release_date, 'yyyy')=?
				    group by music_no, music_name
				    order by 개수 desc, music_name asc) sorted
				where sorted.music_no=music.music_no
				and rownum <= ?
					""";
		List<Map<MusicVO, Integer>> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, year);
			pst.setInt(2, ranking);
			rs = pst.executeQuery();

			while (rs.next()) {
				Map<MusicVO, Integer> music = makeChart(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	해당 문자가 포함된 가수의 노래 검색
	public List<MusicVO> searchSinger(String singer) {
		String sql = """
				select *
				from music
				where singer like upper('%' || ? || '%')
				order by music_name asc, singer asc
					""";

		List<MusicVO> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, singer);
			rs = pst.executeQuery();

			while (rs.next()) {
				MusicVO music = makeMusic(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	해당 문자가 제목에 포함된 노래 검색
	public List<MusicVO> searchTitle(String title) {
		String sql = """
				select *
				from music
				where music_name like initcap('%'||?||'%')
				order by music_name asc, singer asc
					""";

		List<MusicVO> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			rs = pst.executeQuery();

			while (rs.next()) {
				MusicVO music = makeMusic(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	해당 연도에 발매한 노래 검색
	public List<MusicVO> searchYear(int year) {
		String sql = """
				select *
				from music
				where to_char(release_date, 'yyyy')=?
				order by release_date asc, music_name asc, singer asc
					""";

		List<MusicVO> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, year);
			rs = pst.executeQuery();

			while (rs.next()) {
				MusicVO music = makeMusic(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return musiclist;
	}

//	가수, 제목 정확하게 노래 검색
	public MusicVO searchMusic(String title, String singer) {
		String sql = """
				select *
				from music
				where music_name=? and singer=?
					""";

		MusicVO music = null;
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, singer);
			rs = pst.executeQuery();

			while (rs.next()) {
				music = makeMusic(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}

		return music;
	}
	
//	전체 노래 조회
	public List<MusicVO> searchAll() {
		String sql = "select * from music order by music_name asc, singer asc";

		List<MusicVO> musiclist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				MusicVO music = makeMusic(rs);
				musiclist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}

		return musiclist;
	}

//	차트를 위한 노래
	private Map<MusicVO, Integer> makeChart(ResultSet rs) throws SQLException {
		Map<MusicVO, Integer> map = new HashMap<>();
		MusicVO music = new MusicVO();
		music.setMusic_name(rs.getString("Music_name"));
		music.setSinger(rs.getString("Singer"));
		music.setRelease_date(rs.getDate("Release_date"));
		map.put(music, rs.getInt("개수"));
		return map;
	}

//	검색을 위한 노래
	private MusicVO makeMusic(ResultSet rs) throws SQLException {
		MusicVO music = new MusicVO();
		music.setMusic_no(rs.getInt("Music_no"));
		music.setMusic_name(rs.getString("Music_name"));
		music.setSinger(rs.getString("Singer"));
		music.setRelease_date(rs.getDate("Release_date"));
		return music;
	}
}
