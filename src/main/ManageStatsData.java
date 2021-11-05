package main;

public class ManageStatsData {
	public static boolean main() {
		// 관리자 - 통계 관리
		boolean loop = true;
		while (loop) {
			if (Main.nowLogin) {
				printManageStatsData();
				menuManageStatsData();
				System.out.print("선택: ");
				int sel = Main.inputUserNum(0, 4);
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 0:
					loop = false;
					break;
				case 1:
					loop = true;
					break;
				case 2:
					loop = true;
					break;
				case 3:
					loop = true;
					break;
				case 4:
					loop = StatsMember.main();
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

	private static void menuManageStatsData() {
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 구매 통계");
		System.out.println("2. 장바구니 통계");
		System.out.println("3. 매출 통계");
		System.out.println("4. 회원 통계");
		System.out.println("───────────────────────────────────────────────");
	}

	private static void printManageStatsData() {
		System.out.println("───────────────── [ 통계 관리 ] ─────────────────");
	}

}
