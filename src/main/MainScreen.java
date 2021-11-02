package main;

import java.util.Scanner;

public class MainScreen {
	public static void main() {
		
		
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
			case 1: //로그인
				loop = Login.main();
				break;
			case 2: //회원가입
//				loop = register.main();
				break;
			case 3: //상품조회
//				loop = searchProduct.main();
				break;
			case 4: //배송조회
//				loop = searchDelivery.main();
				break;
			}
		}
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 종료");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 상품조회");
		System.out.println("4. 배송조회");
		System.out.println("──────────────────────────────────────────────────");
	}

	private static void printMain() {

		// 메인
		// 화면출력

		System.out.println("───────────────── [ 전자제품 쇼핑몰 프로그램 ] ─────────────────");
		// TODO figlet으로 상품조회 이미지 넣기
	}
}
