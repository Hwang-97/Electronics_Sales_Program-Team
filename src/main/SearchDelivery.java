package main;

import java.util.Scanner;

public class SearchDelivery {
	public static boolean main() {
		
		// 메인 배송조회
		boolean loop = true;
		
		while (loop) {
			printSearchDelivery();
			menuSearchDelivery();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,5);
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
			switch(sel) {
			case 0:
				loop=false;
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

	private static void menuSearchDelivery() {
		System.out.println("─────────────────── [ 메뉴 ] ───────────────────");
		System.out.println("0. 뒤로");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("───────────────────────────────────────────────");
	}

	private static void printSearchDelivery() {
		System.out.println("───────────────── [ 배송 조회 ] ─────────────────");
	}
}
