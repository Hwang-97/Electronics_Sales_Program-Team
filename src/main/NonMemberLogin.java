package main;

public class NonMemberLogin {
	public static boolean main() {
		// 메인 - 로그인 - 비회원 로그인
		boolean loop = true;

		while (loop) {
			if (Main.nowLogin) { // 로그인이 되어있는 경우
				printInputLogin();
				menuInputLogin();

				System.out.print("선택: ");
				int sel = Main.inputUserNum(1, 7);
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 1:
					loop = NonMemberData.main();
					break;
				case 2:
					// 주문조회
					loop = OrderDetailsCheck.main();
					break;
				case 3:
					// 상품 검색
					loop = SearchProduct.main();
					break;
				case 4:
					// 배송 조회
					loop = true;
					break;
				case 5:
					// 로그아웃
					Main.id = null;
					Main.pw = null;
					Main.nowLogin = false;
					loop = false;
					break;
				}

			} else { // 로그인이 안돼있는 경우
				System.out.println(
						"===========================================================================================================");
				System.out.println("\t\t\t   ___                 _       __             _       \r\n"
						+ "\t\t\t  / _ \\_   _  ___  ___| |_    / /  ___   __ _(_)_ __  \r\n"
						+ "\t\t\t / /_\\/ | | |/ _ \\/ __| __|  / /  / _ \\ / _` | | '_ \\ \r\n"
						+ "\t\t\t/ /_\\\\| |_| |  __/\\__ \\ |_  / /__| (_) | (_| | | | | |\r\n"
						+ "\t\t\t\\____/ \\__,_|\\___||___/\\__| \\____/\\___/ \\__, |_|_| |_|\r\n"
						+ "\t\t\t                                        |___/         ");
				System.out.println(
						"===========================================================================================================");
				System.out.println();
				System.out.println();

				System.out.print("주문 연락처 입력: ");
				Main.id = Main.scan.nextLine();
				System.out.print("임시 패스워드 입력: ");
				Main.pw = Main.scan.nextLine();
				System.out.println();

				if (isValidLogin(Main.id, Main.pw)) { // 로그인 성공했을 경우
//				System.out.println("로그인에 성공했습니다.");
					Main.nowLogin = true;
					printInputLogin();
					menuInputLogin();
					Main.nonMemberList.stream().filter(m -> (m.getId().equals(Main.id) && m.getPw().equals(Main.pw)))
							.forEach(m -> Main.memberNumber = m.getMemberNumber());

					System.out.print("선택: ");
					int sel = Main.inputUserNum(1, 5);
					Main.scan.nextLine();

					System.out.println("\n\n\n\n\n\n\n\n\n\n");

					switch (sel) {
					case 1:
						loop = NonMemberData.main();
						break;
					case 2:
						loop = OrderDetailsCheck.main();
						break;
					case 3:
						loop = SearchProduct.main();
						break;
					case 4:
						loop = true;
						break;

					case 5:
						loop = false;
						Main.nowLogin = false;
						break;
					}
				} else { // 로그인 실패했을 경우
					printFailLogin();

					System.out.print("선택: ");
					int sel = Main.inputUserNum(0, 1);

					switch (sel) {
					case 0:
						loop = false;
						break;
					case 1:
						Main.scan.nextLine();
						loop = true;
						break;
					}
				}

			}

		} // while (loop)
		return true;

	} // 메인 메소드

	private static void menuInputLogin() {

		// 메인 - 로그인 - 회원 로그인 후
		// 메뉴출력
		System.out.println(
				"─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 개인정보 확인 \t\t\t\t 2. 구매내역");
		System.out.println();
		System.out.println("\t\t\t 3. 상품조회 \t\t\t\t 4. 배송조회");
		System.out.println();
		System.out.println("\t\t\t 5. 로그아웃 ");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────────────");

	}

	private static void printFailLogin() {
		System.out.println();
		System.out.println(
				"──────────────────────────────────────────── [❌ 로그인 실패 ❌] ────────────────────────────────────────────");
		System.out.println("로그인에 실패했습니다. 다시 입력하시겠습니까?");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 다시 입력하기");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────────────");

	}

	private static void printInputLogin() {
		System.out.println(
				"───────────────────────────────────────────── [ ⭕ 로그인 성공 ⭕ ] ────────────────────────────────────────────");
		System.out.println();
	}

	private static boolean isValidLogin(String id, String pw) {
		// TODO 아이디 비밀번호 유효성검사
		for (int i = 0; i < Main.nonMemberList.size(); i++) {
			if (Main.nonMemberList.get(i).getId().equals(id)) {
				break;
			} else if (i == Main.nonMemberList.size() - 1 && !(Main.nonMemberList.get(i).getId().equals(id))) {
				System.out.println("잘못된 아이디입니다");
				return false;
			} else {
				continue;
			}
		}

		for (int i = 0; i < Main.nonMemberList.size(); i++) {
			if (Main.nonMemberList.get(i).getId().equals(id) && Main.nonMemberList.get(i).getPw().equals(pw)) {
				return true;
			} else if (i == Main.nonMemberList.size() - 1 && !(Main.nonMemberList.get(i).getId().equals(id)
					&& Main.nonMemberList.get(i).getPw().equals(pw))) {
				System.out.println("잘못된 비밀번호입니다");
				return false;
			} else {
				continue;
			}
		}

		return true;
	}

}
