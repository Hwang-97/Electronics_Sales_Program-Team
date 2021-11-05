package main;

public class ManageMemberData {
	public static boolean main() {

		boolean loop = true;

		while (loop) {
			if (Main.nowLogin) {
				printManageMemberData();
				menuManageMemberData();
				System.out.print("선택: ");
				int sel = Main.inputUserNum(0, 4);
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 0:
					loop = false;
					break;
				case 1:
					loop = SearchMemberAll.main();
					break;
				case 2:
					loop = SearchMember.main();
					break;
				case 3:
					loop = SearchNonMemberAll.main();
					break;
				case 4:
					loop = SearchNonMember.main();
					break;
				default:
					break;
				}

			} else {
				loop = false;
			}
		}

		return true;
	}

	private static void menuManageMemberData() {
		// 메인 - 로그인 - 관리자 - 회원 정보 관리
		// 메뉴출력

		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 전체 회원 조회 \t\t\t\t 2. 개인 회원 조회");
		System.out.println();
		System.out.println("\t\t\t 3. 전체 비회원 조회 \t\t\t 4. 개인 비회원 조회");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}

	private static void printManageMemberData() {

		System.out.println("────────────────────────────────────────────── [ 회원정보 관리 ] ──────────────────────────────────────────────");
		System.out.println();
	}
}
