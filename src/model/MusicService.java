package model;

import java.util.List;
import java.util.Map;

import vo.MusicVO;

public class MusicService {
	MusicDAO musicDao = new MusicDAO();

	public List<Map<MusicVO, Integer>> selectAllChart(int num) {
		return musicDao.selectAllChart(num);
	}

	public List<Map<MusicVO, Integer>> selectManChart(int num) {
		return musicDao.selectManChart(num);
	}

	public List<Map<MusicVO, Integer>> selectWomanChart(int num) {
		return musicDao.selectWomanChart(num);
	}

	public List<Map<MusicVO, Integer>> selectYearChart(int ranking, int year) {
		return musicDao.selectYearChart(ranking, year);
	}

	public List<MusicVO> searchSinger(String singer) {
		return musicDao.searchSinger(singer);
	}

	public List<MusicVO> searchTitle(String title) {
		return musicDao.searchTitle(title);
	}

	public List<MusicVO> searchYear(int year) {
		return musicDao.searchYear(year);
	}

	public MusicVO searchMusic(String title, String singer) {
		return musicDao.searchMusic(title, singer);
	}

	public List<MusicVO> searchAll() {
		return musicDao.searchAll();
	}
}
