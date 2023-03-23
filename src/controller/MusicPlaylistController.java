package controller;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.MusicService;
import model.PlaylistService;
import model.UserlistService;
import utils.DateUtil;
import view.MusicView;
import view.PlaylistView;
import view.UserlistView;
import vo.MusicVO;

public class MusicPlaylistController {
	static int userNo = 0;
	static String userId = null;
	static MusicService mService = new MusicService();
	static UserlistService uService = new UserlistService();
	static PlaylistService pService = new PlaylistService();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String select;
			if (userNo == 0) {
				System.out.println("<< 서양 수박♪♬ >>");
				System.out.println("1. 인기 차트 | 2. 노래 검색 | 3. 로그인&회원가입 | exit. 프로그램 종료");
				System.out.println("=============================================================");
				System.out.print(">> ");
				select = sc.next();

				if (select.equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}

				switch (select) {
				case "1": {
					showChart(sc);
					break;
				}
				case "2": {
					searchMusic(sc);
					break;
				}
				case "3": {
					signInAndOut(sc);
					break;
				}
				default:
					System.out.println("올바른 번호를 선택하세요");
					break;
				}
			} else {
				System.out.println("<< " + userId + "님의 서양 수박♪♬ >>");
				System.out.println("1. 인기 차트 | 2. 노래 검색 | 3. 플레이리스트 | 4. 마이페이지 | exit. 프로그램 종료");
				System.out.println("========================================================================");
				System.out.print(">> ");
				select = sc.next();

				if (select.equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}

				switch (select) {
				case "1": {
					showChart(sc);
					break;
				}
				case "2": {
					searchMusic(sc);
					break;
				}
				case "3": {
					myPlaylist(sc);
					break;
				}
				case "4": {
					mypage(sc);
					break;
				}
				default:
					System.out.println("올바른 번호를 선택하세요");
					break;
				}
			}
		}
	}

//	인기 차트
	private static void showChart(Scanner sc) {
		String subSelect;
		boolean loop = true;

		while (loop) {
			System.out.println("< 인기 차트 >");
			System.out.println("1. 전체 인기 차트 | 2. 연도별 인기 차트 | 3. 남성 인기 차트 | 4. 여성 인기 차트 | 5. 홈");
			System.out.print(">> ");
			subSelect = sc.next();

			switch (subSelect) {
			case "1": {
				int ranking = 0;
				while (ranking < 5 || ranking > 50) {
					System.out.println("몇위까지 검색하시겠습니까? (5~50)");
					System.out.print(">> ");
					ranking = sc.nextInt();
				}
				System.out.println("< 전체 인기 차트 >");
				MusicView.print(mService.selectAllChart(ranking), 1);

				break;
			}
			case "2": {
				int year = 0;
				while (year < 2010 || year > 2023) {
					System.out.println("연도를 입력해주세요 (2010~2023)");
					System.out.print(">> ");
					year = sc.nextInt();
				}
				int ranking = 0;
				while (ranking < 3 || ranking > 10) {
					System.out.println("몇위까지 검색하시겠습니까? (3~10)");
					System.out.print(">> ");
					ranking = sc.nextInt();
				}
				System.out.println("< " + year + "년 인기 차트 >");
				MusicView.print(mService.selectYearChart(ranking, year), 1);

				break;
			}
			case "3": {
				int ranking = 0;
				while (ranking < 5 || ranking > 50) {
					System.out.println("몇위까지 검색하시겠습니까? (5~50)");
					System.out.print(">> ");
					ranking = sc.nextInt();
				}
				System.out.println("< 남성 인기 차트 >");
				MusicView.print(mService.selectManChart(ranking), 1);

				break;
			}
			case "4": {
				int ranking = 0;
				while (ranking < 5 || ranking > 50) {
					System.out.println("몇위까지 검색하시겠습니까? (5~50)");
					System.out.print(">> ");
					ranking = sc.nextInt();
				}
				System.out.println("< 여성 인기 차트 >");
				MusicView.print(mService.selectWomanChart(ranking), 1);

				break;
			}
			case "5": {
				loop = false;
				break;
			}
			default: {
				System.out.println("올바른 번호를 선택해주세요.");
				break;
			}
			}
		}
	}

//	노래 검색
	private static void searchMusic(Scanner sc) {
		String subSelect;
		boolean loop = true;

		while (loop) {
			System.out.println("< 노래 검색 >");
			System.out.println("1. 가수로 검색 | 2. 제목으로 검색 | 3. 연도로 검색 | 4. 가수+제목으로 검색 | 5. 전체 노래 조회 | 6. 홈");
			System.out.print(">> ");
			subSelect = sc.next();

			switch (subSelect) {
			case "1": {
				System.out.println("가수를 입력해주세요");
				System.out.print(">> ");
				String singer = sc.next();

				System.out.println("'" + singer + "'이(가) 포함된 가수의 노래 검색 결과");
				MusicView.print(mService.searchSinger(singer));

				break;
			}
			case "2": {
				System.out.println("제목을 입력해주세요");
				System.out.print(">> ");
				sc.nextLine();
				String title = sc.nextLine();

				System.out.println("'" + title + "'이(가) 제목에 포함된 노래 검색 결과");
				MusicView.print(mService.searchTitle(title));

				break;
			}
			case "3": {
				int year = 0;
				while (year < 2010 || year > 2023) {
					System.out.println("연도를 입력해주세요 (2010~2023)");
					System.out.print(">> ");
					year = sc.nextInt();
				}
				System.out.println(year + "년에 발매된 노래 검색 결과");
				MusicView.print(mService.searchYear(year));

				break;
			}
			case "4": {
				System.out.println("제목을 입력해주세요");
				System.out.print(">> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("가수를 입력해주세요");
				System.out.print(">> ");
				String singer = sc.next();

				System.out.println("'" + singer + "' 가수의 '" + title + "' 검색 결과");
				MusicView.print(mService.searchMusic(title, singer));

				break;
			}
			case "5": {
				System.out.println("< 전체 노래 조회 >");
				MusicView.print(mService.searchAll());
				break;
			}
			case "6": {
				loop = false;
				break;
			}
			default: {
				System.out.println("올바른 번호를 선택해주세요.");
				break;
			}
			}
		}
	}

//	로그인&회원가입
	private static void signInAndOut(Scanner sc) {
		String subSelect;
		boolean loop = true;

		while (loop) {
			System.out.println("< 로그인&회원가입 >");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 비밀번호 찾기 | 4. 홈");
			System.out.print(">> ");
			subSelect = sc.next();

			switch (subSelect) {
			case "1": {
				System.out.println("아이디 입력");
				System.out.print(">> ");
				String userid = sc.next();
				System.out.println("비밀번호 입력");
				System.out.print(">> ");
				String userpw = sc.next();

				userNo = uService.signin(userid, userpw);
				if (userNo != 0) {
					userId = userid;
					UserlistView.print("로그인 성공!");
					return;
				} else {
					UserlistView.print("아이디 또는 비밀번호가 맞지 않습니다.");
				}
				break;
			}
			case "2": {
				System.out.println("아이디 입력");
				System.out.print(">> ");
				String userid = sc.next();
				System.out.println("비밀번호 입력");
				System.out.print(">> ");
				String userpw = sc.next();
				System.out.println("이름 입력");
				System.out.print(">> ");
				String username = sc.next();
				System.out.println("생일 입력 (예: 2023/01/01)");
				System.out.print(">> ");
				String tmpday = sc.next();
				String birthPtn = "[0-9]{4}/[0-9]{2}/[0-9]{2}";
				boolean birthResult = Pattern.matches(birthPtn, tmpday);
				Date birthday = null;
				if (birthResult) {
					birthday = DateUtil.convertToDate(tmpday);
				}
				System.out.println("이메일 입력 (예: user@email)");
				System.out.print(">> ");
				String email = sc.next();
				System.out.println("성별 입력 (M, W)");
				System.out.print(">> ");
				String tmpgender = sc.next();
				char gender = tmpgender.charAt(0);

				String mailPtn = "[a-zA-Z0-9]+@\\w+";
				boolean mailResult = Pattern.matches(mailPtn, email);

				if (mailResult && birthResult && (gender == 'M' || gender == 'W')) {
					UserlistView.print(uService.signup(userid, userpw, username, birthday, email, gender));
				} else {
					UserlistView.print("생일, 이메일, 성별 양식을 지켜 작성해주세요.");
				}
				break;
			}
			case "3": {
				System.out.println("아이디 입력");
				System.out.print(">> ");
				String userid = sc.next();
				System.out.println("이름 입력");
				System.out.print(">> ");
				String username = sc.next();
				System.out.println("이메일 입력 (예: user@email)");
				System.out.print(">> ");
				String useremail = sc.next();
				int userno = uService.isExistUser(userid, username, useremail);
				if (userno == 0) {
					UserlistView.print("일치하는 회원이 없습니다.");
				} else {
					System.out.println("새로운 비밀번호 입력");
					System.out.print(">> ");
					String newpw = sc.next();
					UserlistView.print(uService.editPassword(newpw, userno));
				}
				break;
			}
			case "4": {
				loop = false;
				break;
			}
			default: {
				System.out.println("올바른 번호를 선택해주세요.");
				break;
			}
			}
		}
	}

//	플레이리스트
	private static void myPlaylist(Scanner sc) {
		String subSelect;
		boolean loop = true;

		while (loop) {
			System.out.println("< 플레이 리스트 >");
			System.out.println("1. 플레이 리스트 조회 | 2. 플레이 리스트 추가 | 3. 플레이 리스트 삭제 | 4. 홈");
			System.out.print(">> ");
			subSelect = sc.next();

			switch (subSelect) {
			case "1": {
				System.out.println("< " + userId + "님의 플레이 리스트 >");
				MusicView.print(pService.showPlaylist(userNo));
				break;
			}
			case "2": {
				System.out.println("제목을 입력해주세요");
				System.out.print(">> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("가수를 입력해주세요");
				System.out.print(">> ");
				String singer = sc.next();

				if (pService.isExistList(title, singer, userNo)) {
					PlaylistView.print("이미 플레이 리스트에 존재하는 노래입니다.");
				} else {
					MusicVO music = mService.searchMusic(title, singer);
					if (music != null) {
						System.out.println(music);
						while (true) {
							System.out.println("정말 추가하시겠습니까? (Y/N)");
							String select = sc.next();

							if (select.equals("Y")) {
								PlaylistView.print(pService.addPlaylist(title, singer, userNo));
								break;
							} else if (select.equals("N")) {
								break;
							}
						}

					} else {
						PlaylistView.print("존재하지 않는 노래입니다.");
					}
				}
				break;
			}
			case "3": {
				System.out.println("제목을 입력해주세요");
				System.out.print(">> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("가수를 입력해주세요");
				System.out.print(">> ");
				String singer = sc.next();
				MusicVO music = mService.searchMusic(title, singer);
				if (music != null) {
					if (pService.isExistList(title, singer, userNo)) {
						MusicVO musicInList = mService.searchMusic(title, singer);
						System.out.println(musicInList);
						while (true) {
							System.out.println("정말 삭제하시겠습니까? (Y/N)");
							String select = sc.next();

							if (select.equals("Y")) {
								PlaylistView.print(pService.deletePlaylist(title, singer, userNo));
								break;
							} else if (select.equals("N")) {
								break;
							}
						}
					} else {
						PlaylistView.print("플레이 리스트에 존재하지 않는 노래입니다.");
					}
				} else {
					PlaylistView.print("존재하지 않는 노래입니다.");
				}
				break;
			}
			case "4": {
				loop = false;
				break;
			}
			default: {
				System.out.println("올바른 번호를 선택해주세요.");
				break;
			}
			}
		}
	}

//	마이페이지
	private static void mypage(Scanner sc) {
		String subSelect;
		boolean loop = true;

		while (loop) {
			System.out.println("< 마이페이지 >");
			System.out.println("1. 내 정보 조회 | 2. 내 정보 수정 | 3. 로그아웃 | 4. 회원 탈퇴 | 5. 홈");
			System.out.print(">> ");
			subSelect = sc.next();

			switch (subSelect) {
			case "1": {
				UserlistView.print(uService.showInfo(userNo));
				break;
			}
			case "2": {
				UserlistView.print(uService.showInfo(userNo));
				System.out.println("비밀번호 입력");
				System.out.print(">> ");
				String userpw = sc.next();
				System.out.println("이름 입력");
				System.out.print(">> ");
				String username = sc.next();
				System.out.println("생일 입력 (예: 2023/01/01)");
				System.out.print(">> ");
				String tmpday = sc.next();
				String birthPtn = "[0-9]{4}/[0-9]{2}/[0-9]{2}";
				boolean birthResult = Pattern.matches(birthPtn, tmpday);
				Date birthday = null;
				if (birthResult) {
					birthday = DateUtil.convertToDate(tmpday);
				}
				System.out.println("이메일 입력 (예: user@email)");
				System.out.print(">> ");
				String email = sc.next();
				System.out.println("성별 입력 (M, W)");
				System.out.print(">> ");
				String tmpgender = sc.next();
				char gender = tmpgender.charAt(0);

				String mailPtn = "[a-zA-Z0-9]+@\\w+";
				boolean mailResult = Pattern.matches(mailPtn, email);

				if (mailResult && birthResult && (gender == 'M' || gender == 'W')) {
					UserlistView.print(uService.editInfo(userId, userpw, username, birthday, email, gender));
				} else {
					UserlistView.print("생일, 이메일, 성별 양식을 지켜 작성해주세요.");
				}
				break;
			}
			case "3": {
				userNo = 0;
				userId = null;
				UserlistView.print("로그아웃!");
				return;

			}
			case "4": {
				UserlistView.print(uService.showInfo(userNo));
				while (true) {
					System.out.println("정말 탈퇴하시겠습니까? (Y/N)");
					String select = sc.next();

					if (select.equals("Y")) {
						UserlistView.print(uService.quitUser(userNo));
						userNo = 0;
						userId = null;
						return;
					} else if (select.equals("N")) {
						break;
					}
				}
				break;
			}
			case "5": {
				loop = false;
				break;
			}
			default: {
				System.out.println("올바른 번호를 선택해주세요.");
				break;
			}
			}
		}
	}
}
