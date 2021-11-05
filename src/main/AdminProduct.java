package main;

import java.util.ArrayList;
import java.util.List;

import createObject.Product;

public class AdminProduct {
	
	public static boolean main() {
		
		
		boolean loop = true;

		while (loop) {
			printMain();
			menuMain();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 4);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0: //종료
				loop = false;
				break;
			case 1: //상품추가
				loop = AddProduct.main();
				break;
			case 2: //상품검색
				loop = ManageItemSearch.main();
				break;
			case 3: //전체상품검색
				SearchProduct.showProductList();
				break;
			case 4: //문의관리
				loop = ManageQuery.main();
				break;
			}
		}
		return true;
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		// 상품추가 , 상품검색 , 전체상품검색 , 문의관리
		
		
		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 상품 추가 \t\t\t\t 2. 상품 검색");
		System.out.println();
		System.out.println("\t\t\t 3. 전체상품 검색 \t\t\t\t 4. 문의 관리");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}

	private static void printMain() {

		// 메인
		// 화면출력
		String s= "     _    ____  __  __ ___ _   _ \r\n"
				+ "    / \\  |  _ \\|  \\/  |_ _| \\ | |\r\n"
				+ "   / _ \\ | | | | |\\/| || ||  \\| |\r\n"
				+ "  / ___ \\| |_| | |  | || || |\\  |\r\n"
				+ " /_/   \\_\\____/|_|  |_|___|_| \\_|\r\n"
				+ "                                 ";
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		System.out.println(s);
		System.out.println();
		System.out.println("─────────────────────────────────────────────── [ 상품 관리 ] ───────────────────────────────────────────────");
		System.out.println();
		System.out.println();
		// TODO figlet으로 상품조회 이미지 넣기
	}
	
	private static void line() {
		
		for(int i=0;i<50;i++) {
			System.out.print("─");
		}
		System.out.println();
	}
	private static void line(int num) {
		
		for(int i=0;i<num;i++) {
			System.out.print("─");
		}
		System.out.println();
	}
	private static void tap() {
		System.out.print("\t");
	}
	private static void tap(int num) {
		for(int i=0;i<num;i++) {
			System.out.print("\t");
		}
	}
}
