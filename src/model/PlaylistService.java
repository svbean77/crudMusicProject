package model;

import java.util.List;

import vo.MusicVO;

public class PlaylistService {
	PlaylistDAO playlistDao = new PlaylistDAO();

	public List<MusicVO> showPlaylist(int userno) {
		return playlistDao.showPlaylist(userno);
	}

	public boolean isExistList(String title, String singer, int userno) {
		return playlistDao.isExistList(title, singer, userno);
	}

	public String addPlaylist(String title, String singer, int userno) {
		int cnt = playlistDao.addPlaylist(title, singer, userno);
		return cnt > 0 ? "플레이 리스트에 추가되었습니다." : "플레이 리스트에 추가 실패하였습니다.";
	}
	public String deletePlaylist(String title, String singer, int userno) {
		int cnt = playlistDao.deletePlaylist(title, singer, userno);
		return cnt > 0 ? "플레이 리스트에서 삭제되었습니다." : "플레이 리스트에서 삭제 실패하였습니다.";
	}
}
