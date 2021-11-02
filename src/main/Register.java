package main;

import java.util.Scanner;

public class Register {
	public static boolean main() {
		
		// 메인 - 회원가입
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop ) {
			printRegister();
			menuRegister();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,5);
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
			switch(sel) {
			case 0:
				loop =false;
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
		return true;
	}

	private static void menuRegister() {
		System.out.println("─────────────────── [ 메뉴 ] ───────────────────");
		System.out.println("0. 뒤로");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("───────────────────────────────────────────────");
	}

	private static void printRegister() {
		System.out.println("───────────────── [ 회원가입 ] ─────────────────");
		
	}
}
