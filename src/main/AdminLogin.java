package main;

import createObject.Member;

public class AdminLogin {

	public static final Member ADMIN = new Member(0, 0, 0, 0, "ADMIN", "TEST", "ADMIN", "관리자번호", "", "", "", "", "", "",
			"", true, false, null, null);

	public static boolean main() {
		// 메인 - 로그인 - 관리자

		boolean loop = true;
		while (loop) {
			if (Main.nowLogin) {

				printAdminLogin();
				menuAdminLogin();

				System.out.print("선택: ");
				int sel = Main.inputUserNum(0, 4);
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 0:
					Main.id=null;
					Main.pw=null;
					Main.nowLogin=false;
					loop = false;
					break;
				case 1:
					loop = ManageMemberData.main();
					break;
				case 2:
					loop = AdminProduct.main();
					break;
				case 3:
					loop = AdminStats.main();
					break;
				case 4:
					loop = AdminDelivery.main();
					break;
				}
			} else {
				System.out.println("===========================================================================================================");
				System.out.println("\t\t   _       _           _           __             _       \r\n"
						+ "\t\t  /_\\   __| |_ __ ___ (_)_ __     / /  ___   __ _(_)_ __  \r\n"
						+ "\t\t //_\\\\ / _` | '_ ` _ \\| | '_ \\   / /  / _ \\ / _` | | '_ \\ \r\n"
						+ "\t\t/  _  \\ (_| | | | | | | | | | | / /__| (_) | (_| | | | | |\r\n"
						+ "\t\t\\_/ \\_/\\__,_|_| |_| |_|_|_| |_| \\____/\\___/ \\__, |_|_| |_|\r\n"
						+ "\t\t                                            |___/         ");
				System.out.println("===========================================================================================================");
				System.out.println();
				
				//System.out.println("───────────────── [ 관리자 로그인 ] ─────────────────");
				System.out.print("아이디 입력: ");
				Main.id = Main.scan.nextLine();
				System.out.print("패스워드 입력: ");
				Main.pw = Main.scan.nextLine();
				System.out.println();

				if (Main.id.equals(ADMIN.getId()) && Main.pw.equals(ADMIN.getPw())) {
						Main.nowLogin = true;
				}
			}

		}
		return true;

	}

	private static void menuAdminLogin() {

		// 메인 - 로그인 - 관리자
		// 메뉴출력

		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 회원정보 관리 \t\t\t\t 2. 상품 관리");
		System.out.println();
		System.out.println("\t\t\t 3. 통계 관리 \t\t\t\t 4. 배송 관리");
		System.out.println();
		System.out.println("\t\t\t 0. 로그아웃");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}

	private static void printAdminLogin() {
		System.out.println("관리자 로그인 성공");
	}
}
