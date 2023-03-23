package view;

import vo.UserlistVO;

public class UserlistView {
	public static void print(String message) {
		System.out.println("[알림] " + message);
		System.out.println();
	}

	public static void print(UserlistVO user) {
		System.out.println(user);
		System.out.println();
	}
}
