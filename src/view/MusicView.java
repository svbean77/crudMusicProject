package view;

import java.util.List;
import java.util.Map;

import vo.MusicVO;

public class MusicView {

	public static void print(List<MusicVO> musiclist) {
		for (MusicVO music : musiclist) {
			System.out.println(music);
		}
		System.out.println();
	}

	public static void print(MusicVO music) {
		if (music != null) {
			System.out.println(music);
		}
		System.out.println();
	}

	public static void print(List<Map<MusicVO, Integer>> musiclist, int idx) {
		for (Map<MusicVO, Integer> musics : musiclist) {
			for (MusicVO my : musics.keySet()) {
				System.out.printf("%2d. [♡%d]: ", idx, musics.get(my));
				System.out.println(my);
				idx++;
			}
		}
		System.out.println();
	}

	public static void print(String message) {
		System.out.println("[알림] " + message);
		System.out.println();
	}
}
