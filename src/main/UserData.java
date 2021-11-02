package main;

import java.util.Scanner;


public class UserData {
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
				loop = UserDataCheck.main();
				break;
			case 2:
				loop = UserDataEdit.main();
				break;
			}
		}
		return true;
	}
	private static void printUserData() {
		System.out.println("───────────────── [ 개인정보 확인 ] ─────────────────");
	}
		
	private static void menuUserData()
	{
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 개인정보 확인");
		System.out.println("2. 개인정보 수정");
		System.out.println("───────────────────────────────────────────────");
	}
}
