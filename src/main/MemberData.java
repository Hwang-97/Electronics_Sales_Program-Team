package main;


public class MemberData {
	public static boolean main()
	{
		
		boolean loop = true;
		
		while (loop) {
			printUserData();
			menuUserData();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 2);
			Main.scan.nextLine();
			
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0:
				loop = false;
				break;
			case 1:
				loop = MemberDataCheck.main();
				break;
			case 2:
				loop = MemberDataEdit.main();
				break;
			}
		}
		return true;
	}
	private static void printUserData() {
		System.out.println(
				"────────────────────────────────────────────── [ 개인정보 확인 ] ──────────────────────────────────────────────");
	}

	private static void menuUserData() {

		System.out.println(
				"─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 개인정보 확인 \t\t\t\t 2. 개인정보 수정");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기 ");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
}
